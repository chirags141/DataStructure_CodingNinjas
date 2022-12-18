package BonusAssignmentBST;

    class quadruplet {
        int max;
        int min;
        boolean isBST;
        int height;
    }

public class test {
    public static quadruplet largestBSTSubtreeHelper(BinaryTreeNode<Integer> root) {
        // Write your code here
        if(root == null){
            quadruplet output = new quadruplet();
            output.max = Integer.MIN_VALUE;
            output.min =    Integer.MAX_VALUE;
            output.isBST = true;
            output.height = 0;
            return output;
        }

        quadruplet leftAns = largestBSTSubtreeHelper(root.left);
        quadruplet rightAns = largestBSTSubtreeHelper(root.right);

        int max = Math.max(root.data,Math.max(leftAns.max,rightAns.max));
        int min = Math.min(root.data,Math.min(leftAns.min,rightAns.min));

        boolean isBst = leftAns.isBST && rightAns.isBST
                        && (rightAns.min >= root.data)
                        && (leftAns.max < root.data);
        int height;
        if(isBst){
            height = 1 + Math.max(leftAns.height, rightAns.height);
        }else{
            height = Math.max(leftAns.height, rightAns.height);
        }

        quadruplet output = new quadruplet();
        output.isBST = isBst;
        output.min = min;
        output.max = max;
        output.height = height;

        return output;

    }
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root){
        return largestBSTSubtreeHelper(root).height;
    }
}
