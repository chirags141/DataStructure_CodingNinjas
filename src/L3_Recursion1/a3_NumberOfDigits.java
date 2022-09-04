package L3_Recursion1;
/*
Number of Digits
Send Feedback
Given the number 'n', find out and return the number of digits present in a number recursively.
Input Format :
Integer n
Output Format :
Count of digits
Constraints :
1 <= n <= 10^6
Sample Input 1 :
 156
Sample Output 1 :
3
Sample Input 2 :
 7
Sample Output 2 :
1
 */
public class a3_NumberOfDigits {
    public static int count(int n){
        int res = 0;
        if(n == 0)
            return 0;
        else {

            res = count(n/10);
            res++;
            return res;
        }
    }
}
