package L12_Trees;

public class a12_ReplaceNodeWithDepth {

    public static void helper(TreeNode<Integer> root,int k){
        if(root == null ){
            return;
        }
        root.data =k;
        for(TreeNode<Integer> child: root.children){
            helper(child,k+1);
        }

        return;
        // Write your code here

    }

    public static void replaceWithDepthValue(TreeNode<Integer> root){

        helper(root,0);

    }
}
