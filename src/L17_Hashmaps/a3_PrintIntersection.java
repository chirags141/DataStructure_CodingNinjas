package L17_Hashmaps;
/*
Print Intersection
Send Feedback
You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.
Note :
Input arrays/lists can contain duplicate elements.

The intersection elements printed would be in the order they appear in the second array/list (ARR2).


Input format :
The first line of input contains an integer 'N' representing the size of the first array/list.

The second line contains 'N' single space separated integers representing the elements of the first the array/list.

The third line contains an integer 'M' representing the size of the second array/list.

The fourth line contains 'M' single space separated integers representing the elements of the second array/list.
Output format :
Print the intersection elements. Each element is printed in a separate line.
Constraints :
0 <= N <= 10^6
0 <= M <= 10^6

Time Limit: 1 sec
Sample Input 1 :
6
2 6 8 5 4 3
4
2 3 4 7
Sample Output 1 :
2
3
4
Sample Input 2 :
4
2 6 1 2
5
1 2 3 4 2
Sample Output 2 :
1
2
2
 */
import java.util.HashMap;

public class a3_PrintIntersection {

    public static void printIntersection(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> freqArr1 = new HashMap<>();
        for(int i = 0;i < arr1.length;i++){
            if(freqArr1.containsKey(arr1[i])){
                int currValue = freqArr1.get(arr1[i]);
                currValue++;
                freqArr1.put(arr1[i],currValue);
            }else{
                freqArr1.put(arr1[i],1);
            }
        }

        for(int i=0 ; i< arr2.length;i++){
            if(freqArr1.containsKey(arr2[i]) &&  freqArr1.get(arr2[i]) > 0){
                System.out.println(arr2[i]);
                int currValue = freqArr1.get(arr2[i]);
                currValue--;
                freqArr1.put(arr2[i],currValue);
            }
        }

    }


    public static void main(String[] args) {
        int[] a1 = new int[]{7,7,7};
        int[] a2 = new int[]{7,7,7,7};
        printIntersection(a1,a2);
    }
}
