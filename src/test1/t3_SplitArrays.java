package test1;
/*
Split Array
Send Feedback
Given an integer array A of size N, check if the input array can be splitted in two parts such that -
- Sum of both parts is equal
- All elements in the input, which are divisible by 5 should be in same group.
- All elements in the input, which are divisible by 3 (but not divisible by 5) should be in other group.
- Elements which are neither divisible by 5 nor by 3, can be put in any group.
Groups can be made with any set of elements, i.e. elements need not to be continuous. And you need to consider each and every element of input array in some group.
Return true, if array can be split according to the above rules, else return false.
Note : You will get marks only if all the test cases are passed.
Input Format :
Line 1 : Integer N (size of array)
Line 2 : Array A elements (separated by space)
Output Format :
true or false
Constraints :
1 <= N <= 50
Sample Input 1 :
2
1 2
Sample Output 1 :
false
Sample Input 2 :
3
1 4 3
Sample Output 2 :
true
 */
public class t3_SplitArrays {
    public static boolean divByFive(int n) {
        return (n % 5) == 0;
    }

    public static boolean divByThree(int n) {
        return (n % 3) == 0;
    }

    public static int sumOfArray(int[] a){
        int sum = 0;
        for(int i = 0 ; i<a.length;i++){
            sum+= a[i];
        }
        return sum;
    }

    public static boolean splitArray(int input[],int startIndex,int g1, int g2) {
        boolean smallAns1 = false,smallAns2 = false;
        if(startIndex >= input.length){
            if(g1==g2) {
                System.out.print(g1 + " " + g2);
                System.out.println();
            }
            return g1 == g2;
        }
        if(divByFive(input[startIndex])){
            smallAns1 = splitArray(input,startIndex+1,g1 - input[startIndex],g2);
        }else if(divByThree(input[startIndex]) && !divByFive(input[startIndex])){
             smallAns2 = splitArray(input,startIndex+1,g1 ,g2 - input[startIndex]);
        }else{
         smallAns1 = splitArray(input,startIndex+1,g1 - input[startIndex],g2);
         smallAns2 = splitArray(input,startIndex+1,g1 ,g2 - input[startIndex]);
        }

        if(smallAns1 || smallAns2) return true;
        return false;
    }
    public static boolean splitArray(int input[]) {
        int sum = sumOfArray(input);
        return splitArray(input,0,sum,sum);
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{1,2,3,4}));

    }
}
