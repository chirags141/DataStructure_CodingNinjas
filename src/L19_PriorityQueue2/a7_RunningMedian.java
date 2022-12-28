package L19_PriorityQueue2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/*
Running Median
Send Feedback
You are given a stream of 'N' integers. For every 'i-th' integer added to the running list of integers, print the resulting median.
Print only the integer part of the median.
Input Format :
The first line of input contains an integer 'N', denoting the number of integers in the stream.

The second line of input contains 'N' integers separated by a single space.
Output Format :
Print the running median for every integer added to the running list in one line (space-separated).
Input Constraints
0 <= N <= 10 ^ 5
1 <= ARR[i] <= 10 ^ 5

Time Limit: 1 sec
Sample Input 1 :
6
6 2 1 3 7 5
Sample Output 1 :
6 4 2 2 3 4
Explanation of Sample Output 1 :
S = {6}, median = 6
S = {6, 2} -> {2, 6}, median = 4
S = {6, 2, 1} -> {1, 2, 6}, median = 2
S = {6, 2, 1, 3} -> {1, 2, 3, 6}, median = 2
S = {6, 2, 1, 3, 7} -> {1, 2, 3, 6, 7}, median = 3
S = {6, 2, 1, 3, 7, 5} -> {1, 2, 3, 5, 6, 7}, median = 4
Sample Input 2 :
5
5 4 3 2 1
Sample Output 2 :
5 4 4 3 3
 */
public class a7_RunningMedian {

    public static void findMedian(int arr[])  {
        ArrayList<Integer> sortedList = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0;i<arr.length;i++){

            if(maxHeap.isEmpty() && minHeap.isEmpty()){
                maxHeap.add(arr[i]);
                System.out.print(maxHeap.peek()+" ");
            }
            else{
                if(arr[i] > maxHeap.peek() ){
                    minHeap.add(arr[i]);
                }else {
                    maxHeap.add(arr[i]);
                }
                // Balancing the max and min heaps with the atmost diff in size of 1
                //if more than 1 then send the peek of greater heap to smalller heap

                if(Math.abs(maxHeap.size()- minHeap.size()) > 1){
                    if(maxHeap.size()> minHeap.size()){
                        int maxPeekElement = maxHeap.remove();
                        minHeap.add(maxPeekElement);
                    }else{
                        int minPeekElement = minHeap.remove();
                        maxHeap.add(minPeekElement);
                    }
                }

                //Peeks of both the heaps will be the middle elements and
                // as the size is same the total elements would be evwn
                if(maxHeap.size() == minHeap.size()){
                    int median = (maxHeap.peek()+ minHeap.peek())/2;
                    System.out.print(median+" ");
                }
                // else whichever heap has greater size would contain
                // the middle element on the top/peek
                else if(maxHeap.size() > minHeap.size()){
                    System.out.print(maxHeap.peek()+" ");
                }else{
                    System.out.print(minHeap.peek()+" ");
                }
            }
        }

    }

}


/*
            if(maxHeap.size()+ minHeap.size() == 1){
                System.out.println(maxHeap.isEmpty()?minHeap.peek():maxHeap.peek());
            }
            if((i+1)%2 == 0){
                //maxheap size == mean heap size

            }else{
                // abs(maxheap.size - meanheap.size ) <=1
            }
 */