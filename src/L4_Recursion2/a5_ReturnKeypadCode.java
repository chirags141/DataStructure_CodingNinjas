package L4_Recursion2;
/*
Return Keypad Code
Send Feedback
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Return empty string for numbers 0 and 1.
Note : 1. The order of strings are not important.
2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements populated in the output array.
Input Format :
Integer n
Output Format :
All possible strings in different lines
Constraints :
1 <= n <= 10^6
Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf
 */
public class a5_ReturnKeypadCode {


    public static String[] helper(int n){
        if(n==2) return new String[]{"a","b","c"};
        else if(n==3) return new String[]{"d","e","f"};
        else if(n==4) return new String[]{"g","h","i"};
        else if(n==5) return new String[]{"j","k","l"};
        else if(n==6) return new String[]{"m","n","o"};
        else if(n==7) return new String[]{"p","q","r","s"};
        else if(n==8) return new String[]{"t","u","v"};
        else if(n==9) return new String[]{"w","x","y","z"};
        else return new String[]{""};
    }
    // Return a string array that contains all the possible strings
    public static String[] keypad(int n){
        // Write your code here
        if(n<=1){
            String[] ans = {""};
            return ans;
        }

        String smallAns[] = keypad(n/10);
        String[] keyLetters = helper(n%10);
        String[] ans = new String[smallAns.length* keyLetters.length];
        int i,j,k   = 0;
        for(i = 0;i<smallAns.length;i++){
            for(j = 0;j<keyLetters.length ;j++){
                ans[k] = smallAns[i] + keyLetters[j] ;
                k++;
            }
        }
        return ans;
    }

}

