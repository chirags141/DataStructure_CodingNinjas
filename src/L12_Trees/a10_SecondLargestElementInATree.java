package L12_Trees;

import com.sun.source.tree.Tree;

/*
Second Largest Element In Tree
Send Feedback
Given a generic tree, find and return the node with second largest value in given tree. Return NULL if no node with required value is present.
Input format :
Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
Output format:
Second Largest node data
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0
Sample Output 1 :
40
 */
public class a10_SecondLargestElementInATree {

    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;
    static TreeNode<Integer> ceilNode = null;
    static TreeNode<Integer> floorNode = null;

    //Helper fucntion
    public static void ceilAndFloor(TreeNode<Integer> root,int data){
        TreeNode<Integer> ansNode = null;
        if(root.data > data){
            if( root.data < ceil){
                ceil = root.data;
                ceilNode = root;
            }
        }
        if(root.data < data){
            if( root.data > floor){
                floor = root.data;
                floorNode = root;
            }
        }

        for(TreeNode<Integer> child : root.children){
            ceilAndFloor(child,data);
        }
    }

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        int factor;

        factor = Integer.MAX_VALUE; // Smallest among Larger
        floor = Integer.MIN_VALUE;  // Largest among smaller
        TreeNode<Integer> ans = null;
        for(int i = 0 ;i<2;i++){
            ceilAndFloor(root,factor);
            factor = floor;
            ans = floorNode;
            floor = Integer.MIN_VALUE;
            floorNode = null;
        }
        return ans;
    }

}
