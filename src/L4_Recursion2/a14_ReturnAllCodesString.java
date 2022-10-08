package L4_Recursion2;
/*
Return all codes - String
Send Feedback
Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a numeric string S. Write a program to return the list of all possible codes that can be generated from the given string.
Note : The order of codes are not important. And input string does not contain 0s.
Input format :
A numeric string
Constraints :
1 <= Length of String S <= 10
Sample Input:
1123
Sample Output:
aabc
kbc
alc
aaw
kw
 */
public class a14_ReturnAllCodesString {
    public static char helper(String n){
        return (char) ('a' + StringToInt(n) -1);
    }

    public static int StringToInt(String n){
        int num = 0;
        for(int i = 0;i<n.length();i++){
            num+= (n.charAt(i)-'0')* Math.pow(10,n.length()-1-i);
        }
        return  num;
    }
//     Return a string array that contains all possible codes



    public static  String[] getCode(String input){
        if (input.length() == 0)
            return new String[]{""};

        String smallAns1[] = {},smallAns2[] = {};

        smallAns1 = getCode(input.substring(1));
        if(input.length()>1 && StringToInt(input.substring(0,2))<=26){
            smallAns2 = getCode(input.substring(2));
        }
        String ans[] = new String[smallAns1.length + smallAns2.length];
        int k = 0;
        for(int i = 0;i< smallAns1.length;i++){
            ans[i] = helper(input.substring(0,1)) + smallAns1[i];
            k++;
        }
        for(int i = 0;i< smallAns2.length;i++){
            ans[i+k] =helper(input.substring(0,2)) + smallAns2[i];
        }
        return ans;
    }
}
