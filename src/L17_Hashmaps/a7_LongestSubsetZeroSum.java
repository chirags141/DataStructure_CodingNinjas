package L17_Hashmaps;

import java.util.HashMap;

/*
Longest subset zero sum
Send Feedback
Given an array consisting of positive and negative integers, find the length of the longest subarray whose sum is zero.
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format
The first and only line of output contains length of the longest subarray whose sum is zero.
Constraints:
0 <= N <= 10^8
Time Limit: 1 sec
Sample Input 1:
10
 95 -97 -387 -435 -5 -70 897 127 23 284
Sample Output 1:
5
Explanation:
The five elements that form the longest subarray that sum up to zero are: -387, -435, -5, -70, 897
 */
public class a7_LongestSubsetZeroSum {
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
            // Write your code here
        HashMap<Integer,Integer> mapSumIndex= new HashMap<>();
        int sum = 0;
        int maxSubsetLength = 0;
        mapSumIndex.put(0,-1);   // Sum : 0 at index: -1 ;  To take boundary cases ;
        for(int i = 0;i<arr.length;i++){
            int ele = arr[i];
            sum+=ele;
            if(mapSumIndex.containsKey(sum)){
                int indexOfSumInMap = mapSumIndex.get(sum);
                if(maxSubsetLength < (i - indexOfSumInMap)){
                    maxSubsetLength = i - indexOfSumInMap;
                }
            }else{
                mapSumIndex.put(sum,i);
            }
        }
        return maxSubsetLength;
    }
}
