package L19_PriorityQueue2;
/*
Check Max-Heap
Send Feedback
Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains true if it represents max-heap and false if it is not a max-heap.
Constraints:
1 <= N <= 10^5
1 <= Ai <= 10^5
Time Limit: 1 sec
Sample Input 1:
8
42 20 18 6 14 11 9 4
Sample Output 1:
true
 */
public class a4_CheckMaxHeap {
    public static boolean checkMaxHeap(int arr[],int parentIndex){
        boolean leftAns,rightAns;
        int size = arr.length;
        int leftChild = 2*parentIndex+1,rightChild = 2*parentIndex + 2;
//        if(leftChild < size){
//            if(rightChild < size){
//
//            }
//        }else{
//            return true;
//        }
        if(leftChild < size ){
            if(rightChild < size){
                if(arr[leftChild] < arr[parentIndex] && arr[rightChild] < arr[parentIndex]){
                    leftAns = checkMaxHeap(arr,leftChild);
                    rightAns = checkMaxHeap(arr,rightChild);
                    if(leftAns && rightAns){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                if(arr[leftChild] < arr[parentIndex]){
                    leftAns = checkMaxHeap(arr,leftChild);
                    if(leftAns){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }else{
            return true;
        }
    }

    public static boolean checkMaxHeap(int arr[]) {
        return checkMaxHeap(arr,0);
    }
}
