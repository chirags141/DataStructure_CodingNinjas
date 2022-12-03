package L13_BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class a3_PrintTreeLevelWise {
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if(root == null )return;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(q.size() != 1){
            BinaryTreeNode<Integer> frontNode = q.poll();
            if(frontNode.data != -1){
                if(frontNode.left != null)
                    q.add(frontNode.left);
                else
                    q.add(new BinaryTreeNode<>(-1));

            }
        }
    }
}
