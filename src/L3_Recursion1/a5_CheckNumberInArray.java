package L3_Recursion1;
/*
Check Number in Array
Send Feedback
Given an array of length N and an integer x, you need to find if x is present in the array or not. Return true or false.
Do this recursively.
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x
Output Format :
'true' or 'false'
Constraints :
1 <= N <= 10^3
Sample Input 1 :
3
9 8 10
8
Sample Output 1 :
true
Sample Input 2 :
3
9 8 10
2
Sample Output 2 :
false
 */

public class a5_CheckNumberInArray {
    public static boolean checkNumber(int input[], int x) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        boolean ans;
        int len = input.length;
        if(len == 1){
            return input[0] == x;
        }
        else{
            int smallArr[] = new int[input.length-1];
            for(int i = 1;i< input.length;i++){
                smallArr[i-1] = input[i];
            }
            if(input[0] == x){
                ans = true;
            }else{
                ans =  checkNumber(smallArr,x);
            }
            return ans;

        }
    }

    public static void main(String[] args) {
        int arr[] = {9,8,10,11,5,1};
        System.out.println(checkNumber(arr,11));
    }
}
