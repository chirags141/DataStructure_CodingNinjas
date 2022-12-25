package L18_PriorityQueue1;
/*
Code : Remove Min
Send Feedback
Implement the function RemoveMin for the min priority queue class.
For a minimum priority queue, write the function for removing the minimum element present. Remove and return the minimum element.
Note : main function is given for your reference which we are using internally to test the code.

 */
import java.util.ArrayList;

public class a1_RemoveMin {

    private ArrayList<Integer> heap;

    public a1_RemoveMin() {
        heap = new ArrayList<Integer>();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int size() {
        return heap.size();
    }

    int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            // Throw an exception
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    private void swap(ArrayList<Integer> arr,int i , int j){
        int temp;
        temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }

    int removeMin() throws PriorityQueueException {
        // Complete this function
        // Throw the exception PriorityQueueException if queue is empty
        if(isEmpty()){
            throw  new PriorityQueueException();
        }
        if(size() == 1){
            int temp = heap.get(0);
            heap.remove(0);
            return temp;
        }

        int lastElementIndex = size()-1;
        int lastElement = heap.get(lastElementIndex);
        heap.remove(lastElementIndex);

        int parentIndex =0;
        int parent = heap.get(parentIndex);

        int leftChildIndex = 2*parentIndex+1;
        int rightChildIndex = 2*parentIndex+2;
        int leftChild,rightChild;

        int minChildIndex;

        if(rightChildIndex > size() - 1){
            minChildIndex = leftChildIndex;
        }else{
            leftChild = heap.get(leftChildIndex);
            rightChild = heap.get(rightChildIndex);
            minChildIndex = leftChild < rightChild ? leftChildIndex : rightChildIndex;
        }
        int minChild = heap.get(minChildIndex);

        while(leftChildIndex<size()  && (parent > minChild)){
            swap(heap,parentIndex,minChildIndex);
            parentIndex = minChildIndex;

            //Finding the min child index from left and right
            leftChildIndex = 2*parentIndex+1;
            rightChildIndex = 2*parentIndex+2;
            leftChild = heap.get(leftChildIndex);
            rightChild = heap.get(rightChildIndex);

            if(rightChildIndex > size() - 1){
                minChildIndex = leftChildIndex;
            }else{
                minChildIndex = leftChild < rightChild ? leftChildIndex : rightChildIndex;
            }
            minChild = heap.get(minChildIndex);

        }

        return lastElement;

    }
}

