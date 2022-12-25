package L18_PriorityQueue1;

import java.util.ArrayList;

/*
Code : Max Priority Queue
Send Feedback
Implement the class for Max Priority Queue which includes following functions -
1. getSize -
Return the size of priority queue i.e. number of elements present in the priority queue.
2. isEmpty -
Check if priority queue is empty or not. Return true or false accordingly.
3. insert -
Given an element, insert that element in the priority queue at the correct position.
4. getMax -
Return the maximum element present in the priority queue without deleting. Return -Infinity if priority queue is empty.
5. removeMax -
Delete and return the maximum element present in the priority queue. Return -Infinity if priority queue is empty.
Note : main function is given for your reference which we are using internally to test the class.

 */


public class a3_MaxPriorityQueue {
    // Complete this class
    ArrayList<Integer> maxHeap ;

    public a3_MaxPriorityQueue(){
        maxHeap = new ArrayList<>();
    }

    boolean isEmpty() {
        return maxHeap.size() == 0;
    }

    int getSize() {
        return maxHeap.size();
    }

    int getMax() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        return maxHeap.get(0);
    }

    private void swap(ArrayList<Integer> arr,int i , int j){
        int temp;
        temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }

    void insert(int element) {
        if(isEmpty()){
            maxHeap.add(element);
            return;
        }
        maxHeap.add(element);
        int child = getSize()-1;
        int parent = (child-1)/2;
        while(child>0 && (maxHeap.get(parent) < maxHeap.get(child))){
            swap(maxHeap,parent,child);
            child = parent;
            parent = (child-1)/2;
        }
    }

    int removeMax() {
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }

        int temp = maxHeap.get(0);
        int lastEleIndex = getSize()-1;
        maxHeap.set(0,maxHeap.get(lastEleIndex));
        maxHeap.remove(lastEleIndex);

        int parentIndex = 0;
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;
        int maxEleIndex = 0;
        while(leftChildIndex< getSize())
        {
            if (maxHeap.get(maxEleIndex) < maxHeap.get(leftChildIndex)) {
                maxEleIndex = leftChildIndex;
            }
            if (rightChildIndex < getSize() && maxHeap.get(maxEleIndex) < maxHeap.get(rightChildIndex)) {
                maxEleIndex = rightChildIndex;
            }
            if (maxEleIndex == parentIndex) {
                return temp;
            } else {
                swap(maxHeap, maxEleIndex, parentIndex);
                parentIndex = maxEleIndex;
                leftChildIndex = 2 * parentIndex + 1;
                rightChildIndex = 2 * parentIndex + 2;
            }
        }

        return temp;
    }
}