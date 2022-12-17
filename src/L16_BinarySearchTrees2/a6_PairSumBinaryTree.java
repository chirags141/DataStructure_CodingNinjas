package L16_BinarySearchTrees2;
/*
Pair Sum Binary Tree
Send Feedback
Given a binary tree and an integer S, print all the pair of nodes whose sum equals S.
Note:
1. Assume the given binary tree contains all unique elements.
2. In a pair, print the smaller element first. Order of different pairs doesn't matter.
Input format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have a left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
The following line of input contains an integer, that denotes the value of S.
Output Format :
Print each pair in a new line, as described in the task.
Constraints:
Time Limit: 1 second
Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
15
Sample Output 1:
5 10
6 9
 */


import java.util.ArrayList;
import java.util.Collections;

public class a6_PairSumBinaryTree {
    private static ArrayList<Integer> elements = new ArrayList<>();
    private static void helperFunctionToCreateAnArray(BinaryTreeNode<Integer> root){
        if(root == null)
            return;
        helperFunctionToCreateAnArray(root.left);
        elements.add(root.data);
        helperFunctionToCreateAnArray(root.right);

    }
    public static void pairSum(BinaryTreeNode<Integer> root, int sum){
        helperFunctionToCreateAnArray(root);
        ArrayList<Integer> array = new ArrayList<>(elements);
        Collections.sort(array);
        int i =0, j = array.size()-1;
        while(i<j){
            int left = array.get(i),right =array.get(j);
            if(left + right == sum){
                System.out.println(left + " " + right);
                i++; j--;
            }else if(left + right > sum){
                j--;
            }else{
                i++;
            }
        }
    }
}

//Solution from Coding Ninjas
/*
// Time complexity: O(N) Space complexity: O(N) where N is the number of nodes in the input tree
 import java.util.ArrayList;
 import java.util.Collections;
 public class Solution
 {
     public static void convertToArray(BinaryTreeNode<Integer> root, ArrayList<Integer> output)
    {
     if(root == null)
     { return; }
     output.add(root.data);
     convertToArray(root.left, output);
     convertToArray(root.right, output);
    }
    public static void pairSum(BinaryTreeNode<Integer> root, int sum)
    {
        ArrayList<Integer> output = new ArrayList<Integer>();
        convertToArray(root, output);
        Collections.sort(output);
        int i = 0, j = output.size() - 1;
        while(i < j)
        {
            if(output.get(i) + output.get(j) == sum)
            {
                // If duplicate elements are present
                int countI = 1, countJ = 1;
                // Count the number of times 1st element is present
                int k = i + 1;
                while(output.get(k) == output.get(i))
                {
                    countI++; k++;
                }
                // Count the number of times 2nd element is present
                k = j - 1;
                while(output.get(k) == output.get(j))
                {
                    countJ++;
                    k--;
                }
                // Print the pair count times
                int count = countI * countJ;
                while(count > 0) {
                    System.out.println(output.get(i) + " " + output.get(j));
                    count--;
                }
                i += countI;
                j -= countJ;
            }
            else if(output.get(i) + output.get(j) > sum)
            {
                j--;
            } else {
                i++; }
        }
    }
 }

 */

/*
    public static int findSum(BinaryTreeNode<Integer> root,int  sum){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        if(root.data - sum == 0 )
            return root.data;
        int leftAns = findSum(root.left,sum);
        int rightAns = findSum(root.right,sum);
        if(leftAns != Integer.MIN_VALUE){
            return leftAns;
        }else if(rightAns != Integer.MIN_VALUE){
            return rightAns;
        }else{
            return Integer.MIN_VALUE;
        }
    }
    public static void pairSumHelper(BinaryTreeNode<Integer> root, int sum, BinaryTreeNode<Integer> temp) {
        if(root == null || (root.left == null && root.right == null)){
            return;
        }

        int remSum = sum - root.data;
        int ansA = root.data;
        root.data = Integer.MIN_VALUE;
        int ans = findSum(temp,remSum);
        if(ans != Integer.MIN_VALUE){
            if(ansA < ans)
                System.out.println(ansA + " " + ans);
            else
                System.out.println(ans + " " + ansA);

        }
        pairSumHelper(root.left,sum,temp);
        pairSumHelper(root.right,sum,temp);
    }
    public static void pairSum(BinaryTreeNode<Integer> root, int sum){
        BinaryTreeNode<Integer> temp = root;
        pairSumHelper(root,sum,temp);
    }
 */