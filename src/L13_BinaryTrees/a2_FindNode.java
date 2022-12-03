package L13_BinaryTrees;

public class a2_FindNode {
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        if(root == null){
            return false;
        }
        if(root.data == x) return true;
        boolean ansLeft = isNodePresent(root.left,x);
        boolean ansRight = isNodePresent(root.right,x);

        return ansLeft || ansRight;
    }
}
