package L4_Recursion2;
/*
Return subset of an array
Send Feedback
Given an integer array (of length n), find and return all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important.
Input format :

Line 1 : Size of array

Line 2 : Array elements (separated by space)

Sample Input:
3
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12
20
20 12
15
15 12
15 20
15 20 12
 */
public class a12_ReturnSubsetOfAnArray {
    // Return a 2D array that contains all the subsets
    public static int[][] subsets(int input[],int startIndex,int endIndex) {
        // Write your code here
        if(startIndex>endIndex){
            return new int[][]{{}};
        }
        int smallAns[][]  = subsets(input,startIndex+1,endIndex);
//        int smallAnsLength = smallAns.length;
        int ansLength = (int) Math.pow(2,smallAns.length);
        int[][] ans = new int[ansLength][];
        int i,j,k = 0;
        for (i = 0;i<smallAns.length;i++){
            ans[i] = new int[smallAns[i].length];
            for(j=0;j<smallAns[i].length;j++){
                ans[i][j] = smallAns[i][j];
            }
            k++;
        }
        for (i=0;i<smallAns.length;i++){
            ans[i+k] = new int[smallAns[i].length+1];
            ans[i+k][0] = input[startIndex];
            for(j=0;j<smallAns[i].length;j++){
                ans[i+k][j+1] = smallAns[i][j];
            }
        }

        return ans;
    }
    public static int[][] subsets(int input[]) {
        // Write your code here
        return subsets(input,0,input.length-1);
    }

    public static void main(String[] args) {
        System.out.println(subsets(new  int[]{15 ,15, 14, 7 ,2 ,8 ,3 ,2 }));
    }
}
