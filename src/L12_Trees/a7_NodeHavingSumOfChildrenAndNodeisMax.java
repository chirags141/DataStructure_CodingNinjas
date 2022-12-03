package L12_Trees;

public class a7_NodeHavingSumOfChildrenAndNodeisMax {

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        if (root.children.size() == 0)
            return root;
        int maxSum = 0;
        int sum = root.data;
        TreeNode<Integer> ans = root;
        for (int i = 0; i < root.children.size(); i++) {
            sum += root.children.get(i).data;
        }
        if(sum > maxSum){
            maxSum = sum;
        }

        return root;
    }

}
