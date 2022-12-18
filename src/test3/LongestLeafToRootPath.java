package test3;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
Longest Leaf to root path
Send Feedback
Given a binary tree, return the longest path from leaf to root. Longest means, a path which contain maximum number of nodes from leaf to root.
Input format :

Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Line 1 : Binary Tree 1 (separated by space)

Sample Input 1 :
 5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1 :
9
3
6
5

 */

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class LongestLeafToRootPath {
    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
        // Write your code here
        if(root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> leftAns = longestRootToLeafPath(root.left);
        ArrayList<Integer> rightAns = longestRootToLeafPath(root.right);
        ArrayList<Integer> ans = new ArrayList<>();
        if(leftAns.size() >= rightAns.size()){
            ans = new ArrayList<>(leftAns);
            ans.add(root.data);
        }else{
            ans = new ArrayList<>(rightAns);
            ans.add(root.data);
        }
        return ans;
    }
}
