package L14_BinaryTrees2;

import java.util.ArrayList;


public class printNodesAtKdistanceFromTarget {
    static ArrayList<BinaryTreeNode<Integer>> path = new ArrayList<>();
    public static boolean nodeToRootPath(BinaryTreeNode<Integer> node,int targetData){

        if(node == null){
            return false;
        }
        System.out.println("Current root node is "+node.data);
        if(node.data == targetData)
        {
            path.add(node);
            return true;
        }
        boolean findInLeft = nodeToRootPath(node.left,targetData);
        if(findInLeft){
            path.add(node);
            return true;
        }

        boolean findInRight = nodeToRootPath(node.right,targetData);
        if(findInRight ){
            path.add(node);
            return true;
        }

        return false;
    }

    public static void printKLevelsDown(BinaryTreeNode<Integer> root,int k, BinaryTreeNode<Integer> blocker ){
        if(root == null || k<0 || root == blocker )
            return;
        if(k == 0){
            System.out.println(root.data);
            return;
        }
        printKLevelsDown(root.left,k-1, blocker);
        printKLevelsDown(root.right,k-1, blocker);
    }

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int target, int k) {
        boolean findTarget  = nodeToRootPath(root,target);
        for(int i = 0;i< path.size();i++){
            printKLevelsDown(path.get(i),k-i, i == 0 ? null: path.get(i-1));

        }
    }

}






//import java.util.ArrayList;
//public class Solution {
//
//    static ArrayList<BinaryTreeNode> path;
//    public static boolean pathFromNodeToRoot(BinaryTreeNode<Integer> root, int data){
//        if(root == null)
//            return false;
//        if(root.data == data){
//            path.add(root);
//            return true;
//        }
//
//        boolean leftAns = pathFromNodeToRoot(root.left,data);
//        if(leftAns){
//            path.add(root);
//            return true;
//        }
//        boolean rightAns = pathFromNodeToRoot(root.right,data);
//        if(rightAns){
//            path.add(root);
//            return true;
//        }
//
//        return false;
//
//    }
//
//    public static  void printKLevelDown(BinaryTreeNode<Integer> root , int depthK){
//        if(root == null || depthK<0) return;
//        if( depthK == 0) {
//            System.out.println(root.data);
//            return;
//        }
//        printKLevelDown(root.left,depthK-1);
//        printKLevelDown(root.right,depthK-1);
//        return;
//    }
//    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
//        if(root == null)
//            return;
//        boolean ans = pathFromNodeToRoot(root,node);
//        for (int i = 0;i<path.size();i++){
//            printKLevelDown(path.get(i),k-i);
//        }
//    }
//
//}
