package L18_PriorityQueue1;

import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<Integer> heap ;

    public PriorityQueue(){
        heap = new ArrayList<>();
    }

    boolean isEmpty(){
        return heap.size() == 0;
    }

    int size(){
        return heap.size();
    }

    int getMin() throws PriorityQueueException{
        if(isEmpty()){
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    private void swap(ArrayList<Integer> arr,int i , int j){
        int temp;
        temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }
    void insert(int element){
        if(isEmpty()){
            heap.add(element);
            return;
        }
        heap.add(element);
        int child = size()-1;
        int parent = (child - 1)/2;
        while(child > 0 && (heap.get(parent) > heap.get(child))){
            swap(heap,parent,child);
            child = parent;
            parent = (child-1)/2;
        }
    }

    int removeMin() throws PriorityQueueException {
        if(isEmpty()){
            throw  new PriorityQueueException();
        }

        //Removing last element and setting first element as last element

        int temp = heap.get(0);
        int lastElementIndex = size()-1;
        heap.set(0,heap.get(lastElementIndex));
        heap.remove(lastElementIndex);

        int parentIndex =0;
        int minElementIndex = parentIndex;
        int leftChildIndex = 2*parentIndex+1;
        int rightChildIndex = 2*parentIndex+2;


        while(leftChildIndex < size()){

            if(heap.get(leftChildIndex) < heap.get(minElementIndex)) {
                minElementIndex = leftChildIndex;
            }
            if(rightChildIndex < size() && heap.get(rightChildIndex) < heap.get(minElementIndex)) {
                minElementIndex = rightChildIndex;
            }
            if(minElementIndex == parentIndex) {
                break;
            }
            else {
                swap(heap, minElementIndex, parentIndex);
                parentIndex = minElementIndex;
                leftChildIndex = 2 * parentIndex + 1;
                rightChildIndex = 2 * parentIndex + 2;
            }
        }
        return temp;
    }

    void print(){
        for(int i = 0;i<heap.size();i++){
            System.out.print(heap.get(i)+ " ");
        }
        System.out.println();
    }

    //My custom remove min
    int removeMin1() throws PriorityQueueException {
        // Complete this function
        // Throw the exception PriorityQueueException if queue is empty
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        if (size() == 1) {
            int temp = heap.get(0);
            // System.out.println("Removing last element");
            heap.remove(0);
            return temp;
        }

        int temp = heap.get(0);
        int lastElementIndex = size() - 1;
        int lastElement = heap.get(lastElementIndex);
        heap.set(0, lastElement);
        heap.remove(lastElementIndex);

        int parentIndex = 0;
        int parent = heap.get(parentIndex);

        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        int leftChild, rightChild;

        int minChildIndex;

        if (leftChildIndex < size() && rightChildIndex < size()) {
            leftChild = heap.get(leftChildIndex);
            rightChild = heap.get(rightChildIndex);
            minChildIndex = leftChild < rightChild ? leftChildIndex : rightChildIndex;
        } else if (leftChildIndex < size()) {
            minChildIndex = leftChildIndex;
        } else {
            return temp;
        }
        int minChild = heap.get(minChildIndex);

        while (minChildIndex < size() && (parent > minChild)) {
            swap(heap, parentIndex, minChildIndex);
            parentIndex = minChildIndex;

            // Finding the min child index from left and right
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;

            // Check if left and right index are in range and not out of range
            if (leftChildIndex < size() && rightChildIndex < size()) {
                leftChild = heap.get(leftChildIndex);
                rightChild = heap.get(rightChildIndex);
                minChildIndex = leftChild < rightChild ? leftChildIndex : rightChildIndex;
            } else if (leftChildIndex < size()) {
                minChildIndex = leftChildIndex;
            } else {
                break;
            }
            minChild = heap.get(minChildIndex);
        }
        return temp;

    }
}

