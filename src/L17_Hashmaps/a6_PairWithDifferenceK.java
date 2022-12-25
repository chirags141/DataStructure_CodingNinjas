package L17_Hashmaps;

import java.util.HashMap;

/*
Pairs with difference K
Send Feedback
You are given with an array of integers and an integer K. You have to find and print the count of all such pairs which have difference K.
Note: Take absolute difference between the elements of the array.
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol n.
The following line contains n space separated integers, that denote the value of the elements of the array.
The following line contains an integer, that denotes the value of K.
Output format :
The first and only line of output contains count of all such pairs which have an absolute difference of K.
Constraints :
0 <= n <= 10^4
Time Limit: 1 sec
Sample Input 1 :
4
5 1 2 4
3
Sample Output 1 :
2
Sample Input 2 :
4
4 4 4 4
0
Sample Output 2 :
6
 */
public class a6_PairWithDifferenceK {
    public static int getPairsWithDifferenceK(int arr[], int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int v = map.get(arr[i]);
                v++;
                map.put(arr[i],v);
            }else{
                map.put(arr[i],1);
            }
        }
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            int ele = arr[i];
            int absA = ele-k;
            int absB = ele+k;
            int val = map.get(ele);
            val--;
            map.put(ele,val);
            if(map.containsKey(absA) ){
                count += map.get(absA);
            }
            if(k!=0 && map.containsKey(absB) ){
                count +=  map.get(absB);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,-1,3,5,6,0,-1,2,6};
        System.out.println(getPairsWithDifferenceK(arr,3));
    }
}
