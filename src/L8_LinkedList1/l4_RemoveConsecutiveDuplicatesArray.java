package L8_LinkedList1;

import java.util.ArrayList;

public class l4_RemoveConsecutiveDuplicatesArray {
    public static ArrayList<Integer> removeDuplicates(int arr[]){
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0,currentIndex = 0;
        int nextIndex = 1;

        while(i < arr.length){
            int elem = arr[i];
            list.add(elem);
            while(i<arr.length && arr[i] == elem) i++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,10,10,30,30,40,20,20,20,20,50};
        ArrayList<Integer> list = removeDuplicates(arr);
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
