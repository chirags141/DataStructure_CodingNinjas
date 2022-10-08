package L4_Recursion2;
/*
Merge Sort Code
Send Feedback
Sort an array A using Merge Sort.
Change in the input array itself. So no need to return or print anything.
Input format :
Line 1 : Integer n i.e. Array size
Line 2 : Array elements (separated by space)
Output format :
Array elements in increasing order (separated by space)
Constraints :
1 <= n <= 10^3
Sample Input 1 :
6
2 6 8 5 4 3
Sample Output 1 :
2 3 4 5 6 8
Sample Input 2 :
5
2 1 5 2 3
Sample Output 2 :
1 2 2 3 5
 */



public class a4_QuickSortCode {
    /*
        To apply the method explained in the hint video, we have to add two more parameters in the function call. This can be done by calling a helper function from given function. The helper function can have three parameters: array, start index, end index.

        Skeleton code to achieve this:
        public class Solution {
            public static void quickSort(int[] input, int startIndex, int endInedx) {
                // your code goes here
            }

            public static void quickSort(int[] input) {
                quickSort(input, 0, input.length - 1);
            }

        }

    */
    public static int partition(int a[],int startIndex,int endIndex){
        int pivot = a[startIndex];
        int temp,start = startIndex,end = endIndex;
        while(start < end){
            while(start <= endIndex && a[start] <= pivot) start++;
            while(end >= startIndex && a[end] > pivot) end--;
            if(start<end){
            temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            }
        }
        temp = a[end];
        a[end] = a[startIndex];
        a[startIndex] = temp;

        return end;
    }

    public static void quickSort(int[] input, int startIndex, int endIndex) {
        // your code goes here
        if(startIndex < endIndex){
        int pivotPos = partition(input,startIndex,endIndex);
        quickSort(input,startIndex,pivotPos-1);
        quickSort(input,pivotPos+1,endIndex);
        }
    }
    public static void quickSort(int[] input) {
        quickSort(input,0,input.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {2,8,1,5,6,4};
        quickSort(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
