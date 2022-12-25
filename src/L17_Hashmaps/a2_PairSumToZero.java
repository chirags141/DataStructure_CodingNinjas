package L17_Hashmaps;

import java.util.HashMap;

/*
Pair Sum to 0
Send Feedback
Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.
Note: Array A can contain duplicate elements as well.
Input format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output format :
The first and only line of output contains the count of pair of elements in the array which sum up to 0.
Constraints :
0 <= N <= 10^4
Time Limit: 1 sec
Sample Input 1:
5
2 1 -2 2 3
Sample Output 1:
2
 */
public class a2_PairSumToZero {
    public static int PairSum1(int[] input, int size) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int count = 0;
        for(int i = 0;i< input.length;i++){
            if(freq.containsKey((-1)*input[i])){
                count+= freq.get((-1)*input[i]);
                int currFreq = freq.get(input[i]);
                currFreq++;
                freq.put(input[i],currFreq);
            }else{
                freq.put(input[i],1);
            }

            if(freq.containsKey((-1)*input[i])){
                int valuePositive = freq.get(input[i]);
                int valueNegative = freq.get((-1)*input[i]);
                count += valueNegative * valuePositive;

                freq.put(input[i],0);
                freq.put((-1)*input[i],0);

            }
        }
        return count;

//        int count = 0;
//        //Count the number of pairs that turns out to be zero
//        for(int ele: freq.keySet()){
//            if(freq.containsKey((-1)*ele)){
//                int valuePositive = freq.get(ele);
//                int valueNegative = freq.get((-1)*ele);
//                count += valueNegative*valuePositive;
//                freq.put(ele,0);
//                freq.put((-1)*ele,0);
//            }
//        }

/*

        //Printing key value pairs
        for(int ele : freq.keySet()){
            int key = ele;
            int value = freq.get(ele);
            System.out.println("Key :"+ key +" Value :"+value);
        }
*/
    }

    public static int PairSum(int[] input, int size) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int count = 0;
        for(int i = 0;i< input.length;i++){
            int compliment = (-1)*input[i];
            if(freq.containsKey(compliment)){
                count += freq.get(compliment);
//                int x = 0;
//                while(x<freq.get(compliment)) {
//                    System.out.println(input[i] + " " + compliment);
//                    x++;
//                }
                if(freq.containsKey(input[i])){
                    int currValue = freq.get(input[i]) ;
                    currValue++;
                    freq.put(input[i],currValue );
                }else{
                    freq.put(input[i],1 );
                }
            }
            else{
                if(freq.containsKey(input[i])){
                    int currValue = freq.get(input[i]) ;
                    currValue++;
                    freq.put(input[i],currValue );
                }else{
                    freq.put(input[i],1 );
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{0,0,0,0,0};
        int[] arr = new int[]{-2, -12 ,2 ,11 ,12 ,-2 ,1 ,-2 ,2 ,-11 ,12, 2, 6};
        System.out.println(PairSum(arr,arr.length));
    }
}
