package L6_TimeSpaceComplexityAnalysis;
/*Duplicate in array
Send Feedback
You have been given an integer array/list(ARR) of size N which contains numbers from 0 to (N - 2). Each number is present at least once. That is, if N = 5, the array/list constitutes values ranging from 0 to 3, and among these, there is a single integer value that is present twice. You need to find and return that duplicate number present in the array.
Note :
Duplicate number is always present in the given array/list.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the array/list.

Second line contains 'N' single space separated integers representing the elements in the array/list.
Output Format :
For each test case, print the duplicate element in the array/list.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^6

Time Limit: 1 sec
Sample Input 1:
1
9
0 7 2 5 4 7 1 3 6
Sample Output 1:
7
Sample Input 2:
2
5
0 2 1 3 1
7
0 3 1 5 4 3 2
Sample Output 2:
1
3

 */
public class a2_DuplicateInArray {
    /*
    public static int findDuplicate(int[] arr) {
        int ans = -1;
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr.length;j++){
                if(arr[i] == arr[j] && i !=j){
                    ans = arr[i];
                }
            }
        }
        return ans;

     */
    public static int findDuplicate(int[] arr) {
        int sum1 = 0;
        for(int i = 0;i<arr.length;i++){
            sum1 += arr[i];
        }
        int sum2 = 0;
        for(int i = 0;i<=arr.length-2;i++){
            sum2 += i;
        }
        return sum1-sum2;

}

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,1,2,3};
        System.out.println(findDuplicate(arr));
    }
}

/*
public class Solution {

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
        if(startIndex >= endIndex){
            return;
        }
        int mid = (startIndex + endIndex)/2;

        mergeSort(input,startIndex,mid);
        mergeSort(input,mid+1,endIndex);
        merge(input,startIndex,mid,endIndex);

    }

    public static int findDuplicate(int[] arr) {

        mergeSort(arr,0,arr.length-1);
        int ans = -1;
        for(int i = 1;i<arr.length;i++){
            if(arr[i-1] == arr[i]){
                ans = arr[i-1];
            }
        }
        return ans;
	}
}
*/
