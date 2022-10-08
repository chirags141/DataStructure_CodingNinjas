package L6_TimeSpaceComplexityAnalysis;
/*
Pair sum in array
Send Feedback
You have been given an integer array/list(ARR) and a number 'num'. Find and return the total number of pairs in the array/list which sum to 'num'.
Note:
Given array/list can contain duplicate elements.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the first array/list.

Second line contains 'N' single space separated integers representing the elements in the array/list.

Third line contains an integer 'num'.
Output format :
For each test case, print the total number of pairs present in the array/list.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^4
0 <= num <= 10^9

Time Limit: 1 sec
Sample Input 1:
1
9
1 3 6 2 5 4 3 2 4
7
Sample Output 1:
7
Sample Input 2:
2
9
1 3 6 2 5 4 3 2 4
12
6
2 8 10 5 -2 5
10
Sample Output 2:
0
2


 Explanation for Input 2:
Since there doesn't exist any pair with sum equal to 12 for the first query, we print 0.

For the second query, we have 2 pairs in total that sum up to 10. They are, (2, 8) and (5, 5).
 */
import java.lang.reflect.Array;
import  java.util.Arrays;
public class a4_PairSumInArray {
    public static int pairSum(int[] arr, int num) {
        if(arr.length == 0) return 0;
        Arrays.sort(arr);
        int count =0;
        int i=0,j= arr.length-1;

        while(i<j){
            if(arr[i] == arr[j] && arr[i]+arr[j] == num)
                return (arr.length*(arr.length-1))/2;
            if(arr[i]+arr[j] > num)
                j--;
            else if(arr[i]+arr[j] < num)
                i++;
            else{
                int tempStartIndex = i+1;
                int tempEndIndex = j-1;
                int elementAtStart = arr[i];
                int elementAtEnd = arr[j];
                while(tempStartIndex<=tempEndIndex && arr[tempStartIndex] == elementAtStart){
                    tempStartIndex++;
                }
                while(tempStartIndex<=tempEndIndex && arr[tempEndIndex] == elementAtEnd){
                    tempEndIndex--;
                }
                count += (tempStartIndex-i)*(j-tempEndIndex);
                i = tempStartIndex;
                j = tempEndIndex;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int arr[] = {2,3,1,4,3,4,5};
        System.out.println(pairSum(arr,7));
    }
}
