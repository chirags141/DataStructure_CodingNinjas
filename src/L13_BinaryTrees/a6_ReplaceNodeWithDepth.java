package L13_BinaryTrees;
/*
Replace Node With Depth
Send Feedback
For a given a Binary Tree of integers, replace each of its data with the depth of the tree.
Root is at depth 0, hence the root data is updated with 0. Replicate the same further going down the in the depth of the given tree.
The modified tree will be printed in the in-order fashion.
Example:
Alt text

The above tree after updating will look like this:
Alt text

Output: 2 1 2 0 2 1 2 (printed in the in-order fashion)
 Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
The first and the only line of output prints the updated tree in the in-order fashion.
Note:
You are not required to print anything explicitly. It has already been taken care of.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1sec
 Sample Input 1:
2 35 10 2 3 5 2 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
2 1 2 0 2 1 2
 Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
2 1 2 0 2 1 2
 */
public class a6_ReplaceNodeWithDepth {
    public static void changeToDepthTreeHelper(BinaryTreeNode<Integer> root, int k){
        if(root == null) return;
        root.data = k;
        changeToDepthTreeHelper(root.left,k+1);
        changeToDepthTreeHelper(root.right,k+1);

    }
    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
        changeToDepthTreeHelper(root,0);
    }
}
