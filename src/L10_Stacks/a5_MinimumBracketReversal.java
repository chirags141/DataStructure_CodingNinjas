package L10_Stacks;

import java.util.Stack;

/*
Minimum bracket Reversal
Send Feedback
For a given expression in the form of a string, find the minimum number of brackets that can be reversed in order to make the expression balanced. The expression will only contain curly brackets.
If the expression can't be balanced, return -1.
Example:
Expression: {{{{
If we reverse the second and the fourth opening brackets, the whole expression will get balanced. Since we have to reverse two brackets to make the expression balanced, the expected output will be 2.

Expression: {{{
In this example, even if we reverse the last opening bracket, we would be left with the first opening bracket and hence will not be able to make the expression balanced and the output will be -1.
Input Format :
The first and the only line of input contains a string expression, without any spaces in between.
Output Format :
The only line of output will print the number of reversals required to balance the whole expression. Prints -1, otherwise.
Note:
You don't have to print anything. It has already been taken care of.
Constraints:
0 <= N <= 10^6
Where N is the length of the expression.

Time Limit: 1sec
Sample Input 1:
{{{
Sample Output 1:
-1
Sample Input 2:
{{{{}}
Sample Output 2:
1
 */
public class a5_MinimumBracketReversal {
    public static int countBracketReversals(String input) {
        int n = input.length();
        if(n%2 != 0){
            return -1;
        }
        Stack<Character> s = new Stack<>();
        for(int i = 0; i<n;i++){
            char ch = input.charAt(i);
            if(s.size() == 0){
                s.push(ch);
            } else if ( s.peek() == '{' && ch == '}'  ) {
                s.pop();
            }else {
                s.push(ch);
            }
        }

        int count = 0;
        char c1,c2;
        while(s.size() != 0){
            c1 = s.pop();
            c2 = s.pop();
            if((c1 == '{' && c2 == '{') || (c1 == '}' && c2 == '}')){
                count += 1;
            } else if (c1 == '{' && c2 == '}') {
                count += 2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBracketReversals("}}}{{{"));
    }
}
