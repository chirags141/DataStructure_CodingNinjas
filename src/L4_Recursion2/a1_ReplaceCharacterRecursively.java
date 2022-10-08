package L4_Recursion2;

/*
Replace Character Recursively
Send Feedback
Given an input string S and two characters c1 and c2, you need to replace every occurrence of character c1 with character c2 in the given string.
Do this recursively.
Input Format :
Line 1 : Input String S
Line 2 : Character c1 and c2 (separated by space)
Output Format :
Updated string
Constraints :
1 <= Length of String S <= 10^6
Sample Input :
abacd
a x
Sample Output :
xbxcd
 */
public class a1_ReplaceCharacterRecursively {

    public static String replaceCharacter(String n, char c1, char c2) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        String ans = "";
        if(n.length() < 1){
            return "";
        }
        if(n.charAt(0) == c1){
            ans += c2 + replaceCharacter(n.substring(1),c1,c2);
        }else{
            ans += n.charAt(0) + replaceCharacter(n.substring(1),c1,c2);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(replaceCharacter("ChiragSethiya",'a','*'));
    }
}
