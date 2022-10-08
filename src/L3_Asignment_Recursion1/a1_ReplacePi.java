package L3_Asignment_Recursion1;

/*
Replace pi (recursive)
Send Feedback
Given a string, compute recursively a new string where all appearances of "pi" have been replaced by "3.14".
Constraints :
1 <= |S| <= 50
where |S| represents the length of string S.
Sample Input 1 :
xpix
Sample Output :
x3.14x
Sample Input 2 :
pipi
Sample Output :
3.143.14
Sample Input 3 :
pip
Sample Output :
3.14p
Constraints:-
1<=|S|<=50
 */

public class a1_ReplacePi {
    // Return the changed string
    public static String replace(String input){
        if(input.length() <= 1){
            return input;
        }
        String ans = "";
        if(input.charAt(0) == 'p' && input.length() >= 2) {
            if(input.charAt(1) == 'i')
                ans += "3.14" + replace(input.substring(2));
            else
                ans +=input.charAt(0) + replace(input.substring(1));
        }
        else{
            ans +=input.charAt(0) + replace(input.substring(1));
        }
        return ans;
    }
}
