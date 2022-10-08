package L4_Recursion2;
/*
Return subsets sum to K
Send Feedback
Given an array A of size n and an integer K, return all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important.
Input format :
Line 1 : Integer n, Size of input array
Line 2 : Array elements separated by space
Line 3 : K
Constraints :
1 <= n <= 20
Sample Input :
9
5 12 3 17 1 18 15 3 17
6
Sample Output :
3 3
5 1
 */
public class a13_ReturnSubsetsSumToK {
    public static int[][] subsetsSumK(int input[],int startIndex, int k) {
        if(startIndex >= input.length){
            if(k == 0){
                return new int[][]{{}};    //return new int[1][0];
            }else{
                return  new int[][]{}; 	   //return  new int[0][0];
            }
        }

        int[][] smallAns1 = subsetsSumK(input,startIndex+1,k-input[startIndex]);
        int[][] smallAns2 = subsetsSumK(input,startIndex+1,k);

        int[][] ans = new int[smallAns1.length+ smallAns2.length][];

        int x = 0;
        for(int i = 0;i<smallAns1.length;i++){
            ans[i] = new int[smallAns1[i].length+1];
            ans[i][0] = input[startIndex];
            for (int j = 0;j< smallAns1[i].length;j++){
                ans[i][j+1] = smallAns1[i][j];
            }
            x++;
        }

        for(int i = 0;i< smallAns2.length;i++){
            ans[i+x] = new int[smallAns2[i].length];
            for(int j = 0;j< smallAns2[i].length;j++){
                ans[i+x][j] = smallAns2[i][j];
            }
        }
        return ans;
    }
    public static int[][] subsetsSumK(int input[], int k) {
        return subsetsSumK(input,0,k);
    }
}
