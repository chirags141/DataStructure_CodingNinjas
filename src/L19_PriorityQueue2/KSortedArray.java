package L19_PriorityQueue2;

import java.util.PriorityQueue;

public class KSortedArray {
    public static void kSortedArray(int[] a,int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i;
        for(i = 0;i<k;i++){
            pq.add(a[i]);
        }

        for( ; i<a.length;i++){
             a[i-k] = pq.remove();
             pq.add(a[i]);
        }
        for(int j = k;j< a.length;j++){
            a[j] = pq.remove();
        }

        /*
        for(int i = 0;i<=a.length-k;i++){
            for(int j =0;j<k;j++){
                pq.add(a[i+j]);
            }
            for(int j =0;j<k;j++){
                a[i+j] = pq.remove();
            }
        }
        */
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2,1,4,9,6,8};
        kSortedArray(arr,3);
        for(int i = 0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
