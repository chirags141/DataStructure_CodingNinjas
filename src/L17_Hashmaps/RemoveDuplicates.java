package L17_Hashmaps;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {
    public static ArrayList<Integer> removeDuplicates(int[] arr){
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> seen = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            if(seen.containsKey(arr[i]))
                continue;
            output.add(arr[i]);
            seen.put(arr[i],true);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,1,3,2,5,6,4};
        ArrayList<Integer> ans = removeDuplicates(arr);
        for(int ele: ans){
            System.out.println(ele);
        }
    }
}
