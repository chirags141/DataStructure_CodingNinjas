package L4_Recursion2;
/*
Binary Search
Send Feedback
Given an integer sorted array (sorted in increasing order) and an element x, find the x in given array using binary search. Return the index of x.
Return -1 if x is not present in the given array.
Note : If given array size is even, take first mid.
Input format :

Line 1 : Array size

Line 2 : Array elements (separated by space)

Line 3 : x (element to be searched)

Sample Input :
6
2 3 4 5 6 8
5
Sample Output:
3
 */
public class a7_BinarySearchCode {
    // element - number to be searched
    public static int binarySearch(int input[],int start,int end, int element) {
        int mid;
        mid = (start + end)/2;
        if(input[mid] == element) return mid;
        if(start > end) return -1;

        if(input[mid] > element)
            return binarySearch(input,start,mid-1,element);
        else
            return binarySearch(input, mid+1, end, element);

    }

    public static int binarySearch(int input[], int element) {
        // Write your code here
        return binarySearch(input,0,input.length-1,element);

    }
}
