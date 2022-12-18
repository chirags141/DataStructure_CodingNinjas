package test3;
/*
Check cousins
Send Feedback
Given the binary Tree and two nodes say ‘p’ and ‘q’. Determine whether the two nodes are cousins of each other or not. Two nodes are said to be cousins of each other if they are at same level of the Binary Tree and have different parents.
Do it in O(n).
Input format :
Line 1 : Nodes in level order form (separated by space). If any node does not have left or right child, take -1 in its place
Line 2 : integer value of p
Line 3 : Integer value of q
Output format :
true or false
Constraints :
1 <= N <= 10^5
Sample Input :
5 6 10 2 3 4 -1 -1 -1 -1 9 -1 -1 -1 -1
2
4
Sample Output :
true
 */
public class CheckCousins{

    public static int height(BinaryTreeNode<Integer> root,int data){
        if(root == null) return 0;
        if(root.data == data){
            return 1;
        }
        int leftHeight = height(root.left,data);
        if(leftHeight >= 1){
        int ans = 1 + leftHeight;
        return ans;
        }

        int rightHeight = height(root.right,data);
        if(rightHeight >= 1){
            int ans = 1 + rightHeight;
            return ans;
        }
        return 0;
    }

    public static boolean isSibiling(BinaryTreeNode<Integer> root,int p,int q){
        if(root == null){
            return false;
        }
        if((root.left != null && root.left.data == p ) && (root.right != null && root.right.data == q)){
            return true;
        }
        else if((root.left != null && root.left.data == q ) && (root.right != null && root.right.data == p)){
            return true;
        }
        else{
            return isSibiling(root.left,p,q) || isSibiling(root.right,p,q);
        }
    }
    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        if(root == null){
            return false;
        }
        int heightP = height(root,p);
        int heightQ = height(root,q);
//        System.out.println(heightP + " " +heightQ);
//        System.out.println(isSibiling(root,p,q));

        if(heightP == heightQ && !isSibiling(root,p,q)){
            return true;
        }else{
            return false;
        }

    }
}
