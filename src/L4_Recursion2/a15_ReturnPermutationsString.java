package L4_Recursion2;
/*
Return Permutations - String
Send Feedback
Given a string S, find and return all the possible permutations of the input string.
Note 1 : The order of permutations is not important.
Note 2 : If original string contains duplicate characters, permutations will also be duplicates.
Input Format :
String S
Output Format :
All permutations (in different lines)
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba
 */
public class a15_ReturnPermutationsString {

    public static String[] permutationOfString(String input){
        if(input.length()==1)
            return new String[]{input.charAt(0)+""};

        String[] smallAns = permutationOfString(input.substring(1));
        String[] ans = new String[smallAns.length*input.length()];
        int k = 0;
        for(int i = 0;i< smallAns.length;i++){
            String currentString = smallAns[i];
            for(int j = 0;j<= currentString.length();j++){
                ans[k] = currentString.substring(0,j)+ input.charAt(0) + currentString.substring(j);
                k++;
            }
        }
        return ans;
    }
}
