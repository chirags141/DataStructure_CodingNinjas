package L4_Recursion2;
/*
Print Keypad Combinations Code
Send Feedback
Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.
Note : The order of strings are not important. Just print different strings in new lines.
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
public class a6_PrintKeypadCombinationCode {
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

    public static void printKeypad(int input, String output){
        if(input == 0){
            System.out.println(output);
            return;
        }
        int i;
        String[] keypadLetters = helper(input%10);
        for(i = 0; i<keypadLetters.length;i++){
            printKeypad(input/10,keypadLetters[i]+output);
        }
    }
    public static void printKeypad(int input){
        printKeypad(input,"");
    }
}
