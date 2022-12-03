package L13_BinaryTrees;

public class a1_SumOfNodes {
    public static int getSum(BinaryTreeNode<Integer> root) {
     if(root == null){
         return 0;
     }
     int ans = root.data;
     ans += getSum(root.left) + getSum(root.right);
     return ans;
    }
}
