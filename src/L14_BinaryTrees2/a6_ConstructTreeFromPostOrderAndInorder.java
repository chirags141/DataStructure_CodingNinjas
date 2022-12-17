package L14_BinaryTrees2;
/*
Construct Tree from Postorder and Inorder
Send Feedback
For a given postorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
Note:
Assume that the Binary Tree contains only unique elements.
Input Format:
The first line of input contains an integer N denoting the size of the list/array. It can also be said that N is the total number of nodes the binary tree would have.

The second line of input contains N integers, all separated by a single space. It represents the Postorder-traversal of the binary tree.

The third line of input contains N integers, all separated by a single space. It represents the inorder-traversal of the binary tree.
Output Format:
The given input tree will be printed in a level order fashion where each level will be printed on a new line.
Elements on every level will be printed in a linear fashion. A single space will separate them.
Constraints:
1 <= N <= 10^4
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
4 5 2 6 7 3 1
4 2 5 1 6 3 7
Sample Output 1:
1
2 3
4 5 6 7
Sample Input 2:
6
2 9 3 6 10 5
2 6 3 9 5 10
Sample Output 2:
5
6 10
2 3
9
 */
public class a6_ConstructTreeFromPostOrderAndInorder {

    public static BinaryTreeNode<Integer> buildTreeHelper(int[] postOrder, int[] inOrder, int postS,int postE, int inS,int inE) {
        if(inS >  inE)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(postOrder[postE]);
        int indexOfInorderRoot = -1;
        for(int i = inS; i<= inE; i++){
            if(inOrder[i] == root.data){
                indexOfInorderRoot = i;
            }
        }

        int lengthOfRightSubstree = inE - indexOfInorderRoot;

        int inLeftS = inS;
        int inLeftE = indexOfInorderRoot -1;
        int inRightS = indexOfInorderRoot +1;
        int inRightE  = inE;
        int postLeftS = postS;
        int postLeftE = postE -lengthOfRightSubstree -1;
        int postRightS = postLeftE+1;
        int postRightE = postE-1;

        root.left = buildTreeHelper(postOrder,inOrder,postLeftS,postLeftE,inLeftS,inLeftE);
        root.right = buildTreeHelper(postOrder,inOrder,postRightS,postRightE,inRightS,inRightE);

        return root;

    }

    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
        return buildTreeHelper(postOrder,inOrder,0,postOrder.length-1,0,inOrder.length-1);
    }

}
