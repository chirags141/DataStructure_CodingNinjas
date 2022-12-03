package L12_Trees;

import com.sun.source.tree.Tree;

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
