package L15_BinarySearchTrees1;
/*
Check if a Binary Tree is BST
Send Feedback
Given a binary tree with N number of nodes, check if that input tree is BST (Binary Search Tree). If yes, return true, return false otherwise.
Note: Duplicate elements should be kept in the right subtree.
Input format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have a left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output format :
The first and only line of output contains either true or false.
Constraints :
Time Limit: 1 second
Sample Input 1 :
3 1 5 -1 2 -1 -1 -1 -1
Sample Output 1 :
true
Sample Input 2 :
5 2 10 0 1 -1 15 -1 -1 -1 -1 -1 -1
Sample Output 2 :
false
 */
class Triplet<T, V, U> {
    public T isBST;
    public V max;
    public U min;
}
public class a3_CheckIfABinaryTreeIsABST {

    public static Triplet<Boolean, Integer, Integer> isBSTHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            Triplet<Boolean, Integer, Integer> output = new Triplet<>();
            output.isBST = true;
            output.max = Integer.MIN_VALUE;
            output.min = Integer.MAX_VALUE;

            return output;
        }
        Triplet<Boolean, Integer, Integer> leftAns = isBSTHelper(root.left);
        Triplet<Boolean, Integer, Integer> rightAns = isBSTHelper(root.right);

        Triplet<Boolean, Integer, Integer> ans = new Triplet<>();
        // Find leftMAx and rightMin
        int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
        int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));

        boolean isBst = leftAns.isBST && rightAns.isBST
                && (root.data > leftAns.max)
                && (root.data <= rightAns.min);

        ans.max = max;
        ans.min = min;
        ans.isBST = isBst;

        return ans;

    }

    public static boolean isBST(BinaryTreeNode<Integer> root) {
        return isBSTHelper(root).isBST;
    }


}

//  Try- 1
    /*
    private static int maximum(BinaryTreeNode<Integer> root) {
        if(root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.data,Math.max(maximum(root.left),maximum(root.right)));
    }
    private static int minimum(BinaryTreeNode<Integer> root) {
        if(root == null)
            return Integer.MAX_VALUE;
        return Math.min(root.data,Math.min(minimum(root.left),minimum(root.right)));
    }
    public static boolean isBST(BinaryTreeNode<Integer> root) {
        if(root == null)
            return true;

        int leftMax = maximum(root.left);
        int rightMin = minimum(root.right);
        boolean leftAns = isBST(root.left);
        boolean rightAns = isBST(root.right);

        if(root.data <= leftMax  || root.data>rightMin){
            return false;
        }
//        boolean ans = leftAns && rightAns;
        if(leftAns && rightAns)
            return true;
        else
            return false;

    }

*/


