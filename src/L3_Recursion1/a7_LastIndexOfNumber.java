package L3_Recursion1;

/*
Last Index of Number
Send Feedback
Given an array of length N and an integer x, you need to find and return the last index of integer x present in the array. Return -1 if it is not present in the array.
Last index means - if x is present multiple times in the array, return the index at which x comes last in the array.
You should start traversing your array from 0, not from (N - 1).
Do this recursively. Indexing in the array starts from 0.
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x
Output Format :
last index or -1
Constraints :
1 <= N <= 10^3
Sample Input :
4
9 8 10 8
8
Sample Output :
3
 */
public class a7_LastIndexOfNumber {

    public static int lastIndex(int input[], int x, int startIndex){
        if( startIndex == input.length-1){
            return input[startIndex] == x ? startIndex : -1 ;
        }
        int ans = -1;
        ans = lastIndex(input,x,startIndex+1);
        if(input[startIndex] == x && ans<0)
            ans = startIndex;
        return ans;
    }

    public static int lastIndex(int input[], int x) {
        return lastIndex(input,x,0);
    }
    public static void main(String[] args) {
        int arr[] = {2,1,3,5,1,8};
        System.out.println(lastIndex(arr,1));
    }
}
