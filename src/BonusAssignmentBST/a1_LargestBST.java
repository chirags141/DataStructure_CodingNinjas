package BonusAssignmentBST;

/*
Largest BST
Send Feedback
Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree. You have to return the height of largest BST.
Input format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output format:
The first and only line of output contains the height of the largest BST.
Constraints:
Time Limit: 1 second
Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
2
 */


class Quadruplet{
    int max;
    int min;
    boolean isBST;
    int height;
}
public class a1_LargestBST {
    /*
     * BinaryTreeNode class
     *
     * class BinaryTreeNode<T>
     * {
     * 		T data;
     * 		BinaryTreeNode<T> left;
     * 		BinaryTreeNode<T> right;
     *		public BinaryTreeNode(T data)
     *		{
     *  		this.data = data;
     *  	}
     *  }
     */
    public static Quadruplet largestBSTSubtreeHelper(BinaryTreeNode<Integer> root) {
        // Write your code here
        if(root == null){
            Quadruplet output = new Quadruplet();
            output.max = Integer.MIN_VALUE;
            output.min =    Integer.MAX_VALUE;
            output.isBST = true;
            output.height = 0;
            return output;
        }

        Quadruplet leftAns = largestBSTSubtreeHelper(root.left);
        Quadruplet rightAns = largestBSTSubtreeHelper(root.right);

        int max = Math.max(root.data,Math.max(leftAns.max,rightAns.max));
        int min = Math.min(root.data,Math.min(leftAns.min,rightAns.min));

        boolean isBst = leftAns.isBST && rightAns.isBST
                && (rightAns.min >= root.data)
                && (leftAns.max < root.data);
        int height;
        if(isBst){
            height = 1 + Math.max(leftAns.height, rightAns.height);
        }else{
            height = Math.max(leftAns.height, rightAns.height);
        }

        Quadruplet output = new Quadruplet();
        output.isBST = isBst;
        output.min = min;
        output.max = max;
        output.height = height;

        return output;

    }
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root){
        return largestBSTSubtreeHelper(root).height;
    }

}

/*
class Triplet<T, V, U> {
    public T isBST;
    public V max;
    public U min;
}


public class a1_LargestBST {
    public static int height(BinaryTreeNode<Integer> root) {
        if(root == null ) return 0;
        int height = 1;
        return height + Math.max(height(root.left),height(root.right));
    }
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

    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        // Write your code here
        if(root == null)return 0;

        if(isBST(root)){
            return  height(root);
        }else{
            return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right));
        }

    }

//    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
//        // Write your code here
//        if(root == null)return 0;
//
//
//        int ans = -1;
//        if(isBST(root)){
//            ans = height(root);
//            return ans;
//        }
//        int leftAns = largestBSTSubtree(root.left);
//        int rightAns = largestBSTSubtree(root.right);
//
//        return Math.max(ans,Math.max(leftAns,rightAns));
//
//    }

}
*/