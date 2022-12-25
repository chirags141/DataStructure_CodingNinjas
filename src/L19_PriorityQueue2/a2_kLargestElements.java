package L19_PriorityQueue2;
/*
K largest Elements - Code
Send Feedback
You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.
Time complexity should be O(nlogk) and space complexity should be not more than O(k).
Order of elements in the output is not important.
Input Format :
Line 1 : Size of array (n)
Line 2 : Array elements (separated by space)
Line 3 : Integer k
Output Format :
k largest elements
Sample Input :
13
2 12 9 16 10 5 3 20 25 11 1 8 6
4
Sample Output :
12
16
20
25
 */
import java.util.ArrayList;
import java.util.PriorityQueue;

public class a2_kLargestElements {

    public static ArrayList<Integer> kLargest(int input[], int k) {

        //Add first k element to min heap,
        // remove one element and add min element to the heap until the last element
        // the last k elements left would be the largest elements
/*
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i;
        for(i = 0;i<input.length;i++){
            pq.add(input[i]);
        }
        while(pq.size()!=k){
            pq.remove();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.remove());
        }

        return ans;


 */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i;
        for(i = 0;i<k;i++){
            pq.add(input[i]);
        }
        for(;i < input.length;i++ ){
            if(input[i] > pq.peek()){
                pq.remove();
                pq.add(input[i]);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.remove());
        }

        return ans;
    }
}
