package L17_Hashmaps;
/*
Maximum Frequency Number
Send Feedback
You are given an array of integers that contain numbers in random order. Write a program to find and return the number which occurs the maximum times in the given input.
If two or more elements contend for the maximum frequency, return the element which occurs in the array first.
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains most frequent element in the given array.
Constraints:
0 <= N <= 10^8
Time Limit: 1 sec
Sample Input 1 :
13
2 12 2 11 12 2 1 2 2 11 12 2 6
Sample Output 1 :
2
Sample Input 2 :
3
1 4 5
Sample Output 2 :
1
 */
import java.util.HashMap;

public class a1_MaximumFrequencyNumber {

    public static int maxFrequencyNumber(int[] a){
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i = 0 ;i<a.length;i++){
            if(freq.containsKey(a[i])) {
                int currValue = freq.get(a[i]);
                currValue++;
                freq.put(a[i],currValue);
            }else{
                freq.put(a[i],1);
            }
        }
        int maxValue = freq.get(a[0]);
        int maxKey = a[0];

        for(int i =1;i<a.length;i++ ){
            if(freq.get(a[i]) > maxValue){
                maxValue = freq.get(a[i]);
                maxKey = a[i];
            }
        }


        //        for(int key: freq.keySet()){
//            if(freq.get(key) > maxValue){
//                maxValue = freq.get(key);
//                maxKey = key;
//            }
//        }
        return maxKey;
    }
}
