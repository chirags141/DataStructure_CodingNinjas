package L13_BinaryTrees;

public class test {
}

/*
public class Solution {

	public static void preOrder(BinaryTreeNode<Integer> root) {
		//Your code goes here
        if (root==null)
        {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
	}

}

/*
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.InternalFrameFocusTraversalPolicy;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BTree {

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null)
            return;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> frontNode = q.poll();
            String toBePrinted = frontNode.data + ":";
            if (frontNode.left != null) {
                toBePrinted += "L:" + frontNode.left.data + ",";
                q.add(frontNode.left);
            } else {
                toBePrinted += "L:-1,";
            }

            if (frontNode.right != null) {
                toBePrinted += "R:" + frontNode.right.data;
                q.add(frontNode.right);
            } else {
                toBePrinted += "R:-1";
            }
            System.out.println(toBePrinted);
        }

    }

    public static int nodeWithLargestData(BinaryTreeNode<Integer> root) {
        if (root == null)
            return -1;
        int largestData = -1;
        int ansLeft = nodeWithLargestData(root.left);
        int ansRight = nodeWithLargestData(root.right);

        if (root.data > ansLeft && root.data > ansRight) {
            largestData = root.data;
        } else if (ansLeft > ansRight && ansLeft > root.data)
            largestData = ansLeft;
        else
            largestData = ansRight;

        return largestData;
    }

    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        //Your code goes here
        if (root == null)
            return 0;
        int count = 0;
        if (root.data > x)
            count++;
        count += countNodesGreaterThanX(root.left, x) + countNodesGreaterThanX(root.right, x);

        return count;

    }

    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        int height = 1;
        return height + Math.max(height(root.left), height(root.right));
    }

    public static int noOfleafNodes(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int count = noOfleafNodes(root.left) + noOfleafNodes(root.right);

        return count;
    }

    public static void nodeAtDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null)
            return;
        if (k == 0) {
            System.out.println(root.data);
            return;
        }
        nodeAtDepthK(root.left, k - 1);
        nodeAtDepthK(root.right, k - 1);
    }

    public static void changeToDepthTreeHelper(BinaryTreeNode<Integer> root, int k) {
        if (root == null)
            return;
        root.data = k;
        changeToDepthTreeHelper(root.left, k + 1);
        changeToDepthTreeHelper(root.right, k + 1);

    }

    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
        changeToDepthTreeHelper(root, 0);
    }

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        if (root.left == null && root.right != null) {
            System.out.print(root.right.data + " ");
        } else if (root.left != null && root.right == null) {
            System.out.println(root.left.data + " ");
        }
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);

    }

    public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root){
        if(root == null) return null;
        if(root.left == null && root.right == null)
            return null;

        BinaryTreeNode<Integer> ansLeft,ansRight;

        root.left = removeLeafNodes(root.left);
        root.right = removeLeafNodes(root.right);

        return root;
    }

    public static boolean isBtreeBalanced(BinaryTreeNode<Integer> root){
        if(root == null) return true;
        boolean ans = false;
        int ansLeft = height(root.left);
        int ansRight = height(root.right);
        if(Math.abs(ansLeft - ansRight) <= 1)
            ans = true;
        return ans && isBtreeBalanced(root.left) && isBtreeBalanced(root.right);

    }

    public static class BalancedTreeReturn{
        int height;
        boolean isBalanced;
    }

    public static  BalancedTreeReturn isBtreeBalancedBetter(BinaryTreeNode<Integer> root)
    {
        if(root == null ){
            int height = 0;
            boolean isBal = true;
            BalancedTreeReturn ans = new BalancedTreeReturn();
            ans.height = height;
            ans.isBalanced = isBal;
            return ans;
        }
        BalancedTreeReturn leftOutput = isBtreeBalancedBetter(root.left);
        BalancedTreeReturn rightOutput = isBtreeBalancedBetter(root.right);
        int height = 1 + Math.max(leftOutput.height,rightOutput.height);
        boolean isBal = true;
        if(Math.abs(leftOutput.height - rightOutput.height)>0){
            isBal = false;
        }

        if(!leftOutput.isBalanced || !rightOutput.isBalanced){
            isBal = false;
        }

        BalancedTreeReturn ans = new BalancedTreeReturn();
        ans.isBalanced = isBal;
        ans.height = height;

        return ans;

    }


    public static int diameterOfBtree(BinaryTreeNode<Integer> root){
        if(root == null)return 0;

        int option1 =height(root.left) + height(root.right);
        int option2 = diameterOfBtree(root.left);
        int option3 = diameterOfBtree(root.right);

        return Math.max(option1, Math.max(option2,option3));
    }




    public static class DiameterAns{
        int height;
        int diameter;
    }


    public static DiameterAns diameterOfBinaryTreeHelper(BinaryTreeNode<Integer> root){
        if(root == null) {
            int height = 0;
            int diameter = 0;
            DiameterAns ans  = new DiameterAns();
            return ans;
        }
        DiameterAns leftOutput = diameterOfBinaryTreeHelper(root.left);
        DiameterAns rightOutput = diameterOfBinaryTreeHelper(root.right);
        int height = 1 + Math.max(leftOutput.height,rightOutput.height);
        int option1 = leftOutput.height + rightOutput.height;
        int option2 = Math.max(leftOutput.diameter, rightOutput.diameter);

        DiameterAns ans = new DiameterAns();
        ans.height = height;
        ans.diameter = 1 + Math.max(option1,option2);

        return ans;
    }

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        DiameterAns ans = diameterOfBinaryTreeHelper(root);
        return ans.diameter;
    }

    public static BinaryTreeNode<Integer> mirrorBinaryTreeHelper(BinaryTreeNode<Integer> root) {
        if(root == null ){
            return null;
        }
        BinaryTreeNode<Integer> tempLeft = root.left;
        root.left = mirrorBinaryTreeHelper(root.right);
        root.right = mirrorBinaryTreeHelper(tempLeft);

        return root;
    }
    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
        mirrorBinaryTreeHelper(root);
    }


    public static void inOrderTraversal(BinaryTreeNode<Integer> root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data +" ");
        inOrderTraversal(root.right);
    }
}
 */