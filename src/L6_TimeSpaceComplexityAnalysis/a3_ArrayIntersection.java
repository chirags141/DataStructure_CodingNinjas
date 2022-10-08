package L6_TimeSpaceComplexityAnalysis;
/*
Array Intersection
Send Feedback
You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.
Note :
Input arrays/lists can contain duplicate elements.

The intersection elements printed would be in ascending order.


Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains an integer 'N' representing the size of the first array/list.

The second line contains 'N' single space separated integers representing the elements of the first the array/list.

The third line contains an integer 'M' representing the size of the second array/list.

The fourth line contains 'M' single space separated integers representing the elements of the second array/list.
Output format :
For each test case, print the intersection elements in a row, separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^6
0 <= M <= 10^6

Time Limit: 1 sec
Sample Input 1 :
2
6
2 6 8 5 4 3
4
2 3 4 7
2
10 10
1
10
Sample Output 1 :
2 3 4
10
Sample Input 2 :
1
4
2 6 1 2
5
1 2 3 4 2
Sample Output 2 :
1 2 2
Explanation for Sample Output 2 :
Since, both input arrays have two '2's, the intersection of the arrays also have two '2's. The first '2' of first array matches with the first '2' of the second array. Similarly, the second '2' of the first array matches with the second '2' if the second array.
 */
public class a3_ArrayIntersection {
    public static void merge(int[] a,int start,int mid,int end){
        int newArray[] = new int[end-start+1];
        int i = start,j = mid+1,k=0;
        while(i<=mid && j<=end){
            if(a[i] <= a[j]) newArray[k++] = a[i++];
            else newArray[k++] = a[j++];
        }

        while(i<=mid) newArray[k++] = a[i++];
        while(j<=end) newArray[k++] = a[j++];
        for(i = 0,j = start;i< newArray.length && j<=end;i++,j++) a[j] = newArray[i];
    }
    public static void mergeSort(int[] a,int start,int end){
        if(start >=end ) return;
        int mid = (start + end )/2;
        mergeSort(a,start,mid);
        mergeSort(a,mid+1,end);
        merge(a,start,mid,end);
    }

    public static void intersection(int[] arr1, int[] arr2) {
        mergeSort(arr1,0, arr1.length-1);
        mergeSort(arr2,0, arr2.length-1);
//        int min = arr1.length< arr2.length? arr1.length : arr2.length;
//        int[] arrSmall = arr1.length< arr2.length? arr1 : arr2;
//        int[] arrLarge = arr1.length> arr2.length? arr1 : arr2;
//        int j = 0;
//        for(int i = 0;i<min;){
//            if(arrSmall[i]< arrLarge[j]) i++;
//            else if(arrSmall[i]> arrLarge[j]) j++;
//            else System.out.print(arrSmall[i]+" ");
//        }
            int i=0,j = 0;
            while(i< arr1.length && j< arr2.length){
                if(arr1[i] == arr2[j]){
                    System.out.print(arr1[i] + " ");
                    j++;i++;
                }
                else if(arr1[i] < arr2[j]){
                    i++;
                }else j++;
            }
    }

    public static void main(String[] args) {
        int a1[] = {2,1,5,9,8};
        int a2[] = {2,5,1,0};
        intersection(a1,a2);
    }
}
