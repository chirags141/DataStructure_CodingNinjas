package L3_Recursion1;

public class a12_CheckPalindromeRecursive {
    /*
Check Palindrome (recursive)
Send Feedback
Check whether a given String S is a palindrome using recursion. Return true or false.
Input Format :
String S
Output Format :
'true' or 'false'
Constraints :
0 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
racecar
Sample Output 1:
true
Sample Input 2 :
ninja
Sample Output 2:
false
*/
    public static boolean isStringPalindrome(String input)
    {
        if(input.length() == 0) return true;
        int startIndex = 0,endIndex = input.length()-1;
        if(startIndex == endIndex){
            return true;
        }
        boolean smallAns = false;
        if(input.charAt(startIndex) == input.charAt(endIndex)){
            smallAns = isStringPalindrome(input.substring(startIndex+1,endIndex));
        }
        return smallAns;

    }
}
