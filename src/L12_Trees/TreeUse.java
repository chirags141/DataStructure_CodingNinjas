package L12_Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class TreeUse {

    public static TreeNode<Integer> takeInputLevelwise(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter root Data:");
        int rootData = sc.nextInt();

        Queue<TreeNode<Integer>> q = new LinkedList<>();

        TreeNode<Integer> root = new TreeNode<>(rootData);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode<Integer> frontNode = q.poll();
            System.out.println("Enter the number of children of " + frontNode.data);
            int children = sc.nextInt();
            for(int i = 0;i<children;i++){
                System.out.println("Enter the data for " + (i+1) + "th children of " + frontNode.data );
                int childData = sc.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(childData);
                frontNode.children.add(childNode);
                q.add(childNode);
            }
        }
        return root;
    }

    public static void print(TreeNode<Integer> root){
        String s = root.data + ":";
        for(int i = 0; i<root.children.size();i++){
            s += root.children.get(i).data+",";
        }
        System.out.println(s);
        for(int i = 0; i<root.children.size();i++){
            print(root.children.get(i));
        }
    }

    public static TreeNode<Integer> takeInput(Scanner sc){
        int n;
        System.out.println("Enter next node data");
        n = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter the number of children for "+ n);
        int childCount = sc.nextInt();
        for(int i =0 ; i<childCount;i++){
            TreeNode<Integer> child = takeInput(sc);
            root.children.add(child);
        }
        return root;
    }

    public static int numberOfNodes(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int count = 1;
        for(int i = 0;i< root.children.size();i++){
            count += numberOfNodes(root.children.get(i));
        }
        return count;
    }

    public static int nodeWithLargestData(TreeNode<Integer> root){
        if(root ==null){
            return Integer.MIN_VALUE;
        }
        int largest = root.data;
        for(int i = 0;i<root.children.size();i++){
            if(largest < nodeWithLargestData(root.children.get(i))){
                largest = nodeWithLargestData(root.children.get(i));
            }
        }
        return largest;
    }

    //print node at depth k
    public static void printAtK(TreeNode<Integer> root,int k){
        if(k<0) return;
        if(k == 0){
            System.out.println(root.data);
        }
        for (int i = 0;i<root.children.size();i++){
            printAtK(root.children.get(i),k-1 );
        }
    }

    public static void preOrderTraversal(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data+ " ");
        for (int i = 0;i<root.children.size();i++){
            preOrderTraversal(root.children.get(i));
        }
    }

    public static void printPostOrder(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        for (int i = 0;i<root.children.size();i++){
            printPostOrder(root.children.get(i));
        }
        System.out.print(root.data+ " ");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        TreeNode<Integer> root = takeInputLevelwise();
        a1_PrintLevelWise.printLevelWise(root);
        System.out.println("Largest:" + nodeWithLargestData(root));
        System.out.println("number of nodes" + numberOfNodes(root));

        preOrderTraversal(root);
        System.out.println();
        printPostOrder(root);

//        print(root);
//        System.out.println("-------------------");

//        TreeNode<Integer> root = takeInput(s);
//        print(root);
//

    /*
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(5);
        TreeNode<Integer> node4 = new TreeNode<>(1);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
    */
    }
}
