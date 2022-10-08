package L4_Recursion2;
/*
Quick Sort Code
Send Feedback
Sort an array A using Quick Sort.
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
1 5 2 7 3
Sample Output 2 :
1 2 3 5 7
 */
public class a3_MergeSortCode {
    public static void merge(int[] input, int start, int mid, int end){
        int arr[] = new int[end-start+1];
        int i = start,j=mid+1,k=0;
        while(i<=mid && j<=end){
            if(input[i]<= input[j]){
                arr[k++] = input[i++];
            }else{
                arr[k++] = input[j++];
            }
        }
        while(i<=mid){
            arr[k++] = input[i++];
        }
        while(j<=end){
            arr[k++] = input[j++];
        }
        for(i=0,j=start;i<arr.length && j<end+1;i++,j++){
            input[j] = arr[i];
        }
    }
    public static void mergeSort(int[] input, int startIndex, int endIndex){
        if(startIndex == endIndex){
            return;
        }
        int mid = (startIndex + endIndex)/2;

        mergeSort(input,startIndex,mid);
        mergeSort(input,mid+1,endIndex);
        merge(input,startIndex,mid,endIndex);

    }
    public static void mergeSort(int[] input){
        mergeSort(input,0,input.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {2,8,1,5,6,4};
        mergeSort(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
