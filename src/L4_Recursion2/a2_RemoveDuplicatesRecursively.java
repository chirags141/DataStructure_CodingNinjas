package L4_Recursion2;
/*
Remove Duplicates Recursively
Send Feedback
Given a string S, remove consecutive duplicates from it recursively.
Input Format :
String S
Output Format :
Output string
Constraints :
1 <= |S| <= 10^3
where |S| represents the length of string
Sample Input 1 :
aabccba
Sample Output 1 :
abcba
Sample Input 2 :
xxxyyyzwwzzz
Sample Output 2 :
xyzwz
 */
public class a2_RemoveDuplicatesRecursively {

    public static String removeConsecutiveDuplicates(String s) {
        // Write your code here
        String ans = "";
        if(s.length()<=1){
            return ans + s.charAt(0) ;
        }
        String smallAns = removeConsecutiveDuplicates(s.substring(1));
        if(s.charAt(0) == smallAns.charAt(0)){
            ans +=  smallAns;
        }else{
            ans += s.charAt(0) + smallAns;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(removeConsecutiveDuplicates("aaxxbcddd"));
    }
}
