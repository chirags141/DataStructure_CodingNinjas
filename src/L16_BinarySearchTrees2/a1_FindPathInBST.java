package L16_BinarySearchTrees2;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/*
Find path in BST
Send Feedback
Given a BST and an integer k. Find and return the path from the node with data k and root (if a node with data k is present in given BST) in a list. Return empty list otherwise.
Note: Assume that BST contains all unique elements.
Input Format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
The following line of input contains an integer, that denotes the value of k.
Output Format :
The first line and only line of output prints the data of the nodes in the path from node k to root. The data of the nodes is separated by single space.
Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output 1:
2 5 8
 */
public class a1_FindPathInBST {

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
        if(root == null)
            return null;
        if(root.data == data){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(root.data);
            return ans;
        }
        else if(data < root.data){
            ArrayList<Integer> leftAns = getPath(root.left,data);
            if(leftAns != null)
                leftAns.add(root.data);
            return  leftAns;
        }
        else {
            ArrayList<Integer> rightAns = getPath(root.right,data);
            if(rightAns!= null)
                rightAns.add(root.data);
            return  rightAns;
        }
    }
}
