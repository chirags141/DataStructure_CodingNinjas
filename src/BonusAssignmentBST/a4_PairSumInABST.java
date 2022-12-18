package BonusAssignmentBST;

import java.util.ArrayList;

public class a4_PairSumInABST {
    private static ArrayList<Integer> inOrderList = new ArrayList<>();
    public static void printNodesSumToSHelper(BinaryTreeNode<Integer> root) {
        if(root == null){
            return;
        }
        printNodesSumToSHelper(root.left);
        inOrderList.add(root.data);
        printNodesSumToSHelper(root.right);

    }
    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int sum){

        printNodesSumToSHelper(root);
        ArrayList<Integer> list = new ArrayList<>(inOrderList);
        int i = 0, j = list.size()-1;
        while(i<j){
            int left = list.get(i),right = list.get(j);
            if(left + right == sum){
                System.out.println(left+" "+right);
                i++;j--;
            }else if(left+right>sum){
                j--;
            }else{
                i++;
            }
        }
    }
}
