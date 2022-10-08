package L3_Asignment_Recursion1;
/*
Pair Star
Send Feedback
Given a string S, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".
Input format :
String S
Output format :
Modified string
Constraints :
0 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
hello
Sample Output 1:
hel*lo
Sample Input 2 :
aaaa
Sample Output 2 :
a*a*a*a
 */
public class a4_PairStar {
    // Return the updated string
    public static String addStars(String s) {
        if(s.length()<=1){
            return s;
        }
        String ans = "";
        if(s.charAt(0) == s.charAt(1)){
            ans += s.charAt(0) + "*" + addStars(s.substring(1));
        }else{
            ans += s.charAt(0) + addStars(s.substring(1));
        }
        return ans;

    }
}
