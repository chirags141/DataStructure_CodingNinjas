package L12_Trees;
/*
Code : Print Level Wise
Send Feedback
Given a generic tree, print the input tree in level wise order. That is, print the elements at same level in one line (separated by space). Print different levels in differnet lines.
Input format :
Elements in level order form separated by space (as per done in class). Order is -
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
Output Format :
Level wise print
Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0
Sample Output :
10
20 30 40
40 50
 */

import java.util.LinkedList;
import java.util.Queue;

public class a1_PrintLevelWise {

/*	TreeNode structure
 *
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/

     public static void printLevelWise(TreeNode<Integer> root){
         Queue<TreeNode<Integer>> qParent = new LinkedList<>();
         Queue<TreeNode<Integer>> qChild = new LinkedList<>();
         qParent.add(root);


         // Take a queue and child queue
         // remove print add rpa
         while(!qParent.isEmpty()){
             TreeNode<Integer> frontNode = qParent.poll();
             System.out.print(frontNode.data + " ");
             for(int  i = 0;i< frontNode.children.size();i++){
                 qChild.add(frontNode.children.get(i));
             }
             if(qParent.isEmpty()){
                 qParent = qChild;
                 qChild = new LinkedList<>();
                 System.out.println();
             }

         }

     }
}
