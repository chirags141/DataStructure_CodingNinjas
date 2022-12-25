package L19_PriorityQueue2;
/*
Code - Implace Heap sort
Send Feedback
Given an integer array of size N. Sort this array (in decreasing order) using heap sort.
Note: Space complexity should be O(1).
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array or N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains array elements after sorting. The elements of the array in the output are separated by single space.
Constraints :
1 <= n <= 10^6
Time Limit: 1 sec
Sample Input 1:
6
2 6 8 5 4 3
Sample Output 1:
8 6 5 4 3 2
 */
public class a1_InplaceHeapSort {

    public static void swap(int[] arr,int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void inplaceHeapSort(int arr[]) {

        //Build a heap
        for (int i = 1;i<arr.length;i++){
            int heapEndIndex = i-1;

            int child = heapEndIndex+1;
            int parent = (child-1)/2;
            while(child > 0 && arr[child] < arr[parent]){
                swap(arr,child,parent);
                child = parent;
                parent = (child-1)/2;
            }
        }

        // Downward heapify / Removal of min element
        int si = 0,ei = arr.length-1;
        while(si < ei){
            swap(arr,si,ei);
            ei--;
            //down heapify on remaining elements
            int minIndex = 0;
            int parentIndex = 0;
            int leftChildIndex  = 2*parentIndex+1;
            int rightChildIndex = 2*parentIndex + 2;

            while(leftChildIndex <= ei ){
                if(arr[leftChildIndex] < arr[minIndex]){
                    minIndex = leftChildIndex;
                }
                if(rightChildIndex<=ei && arr[rightChildIndex]<arr[minIndex]){
                    minIndex = rightChildIndex;
                }
                if(minIndex == parentIndex){
                    break;
                }
                else{
                    swap(arr,minIndex,parentIndex);
                    parentIndex = minIndex;
                    leftChildIndex  = 2*parentIndex + 1;
                    rightChildIndex = 2*parentIndex + 2;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6};
        inplaceHeapSort(arr);
        for (int ele:arr){
            System.out.println(ele);
        }
    }
}
