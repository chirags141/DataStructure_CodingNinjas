package L15_BinarySearchTrees1;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {

    public static int countOfNodes(BinaryTreeNode<Integer> root){
        if(root == null) return 0;
        int ans = 1;
        ans += countOfNodes(root.left);
        ans += countOfNodes(root.right);

        return ans;
    }
    public static BinaryTreeNode<Integer> takeInputIteratively(){
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter root Data:");
        int rootData = sc.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        q.add(root);

        while(!q.isEmpty()){

            BinaryTreeNode<Integer> frontNode = q.poll();
            System.out.println("Enter the left child for "+ frontNode.data);
            int leftChild = sc.nextInt();
            System.out.println("Enter the right child for "+ frontNode.data);
            int rightChild = sc.nextInt();
            if(leftChild!= -1){
                BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>(leftChild);
                q.add(leftNode);
                frontNode.left = leftNode;
            }
            if(rightChild!= -1){
                BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<>(rightChild);
                q.add(rightNode);
                frontNode.right = rightNode;
            }

        }
        return root;

    }
    public static void printTree(BinaryTreeNode<Integer> root){
        if(root == null) return;
        String toBePrinted = root.data + ":";
        if(root.left != null){
            toBePrinted += "L->" + root.left.data + ",";
        }
        if(root.right != null){
            toBePrinted += "R->" + root.right.data + ",";
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }
    public static BinaryTreeNode<Integer> takeInput(Scanner sc){
        System.out.println("Enter data to add in the tree");
        int rootData = sc.nextInt() ;
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        root.left = takeInput(sc);
        root.right = takeInput(sc);

        return root;

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root;
        Scanner sc = new Scanner(System.in);
        root = takeInputIteratively();
        printTree(root);
        System.out.println("Count of nodes is: "+ countOfNodes(root));

/*
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);

        BinaryTreeNode<Integer> nodeLeft = new BinaryTreeNode<>(2);
        root.left = nodeLeft;

        BinaryTreeNode<Integer> nodeRight = new BinaryTreeNode<>(3);
        root.right = nodeRight;
 */
    }
}
