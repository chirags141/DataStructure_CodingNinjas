package L6_TimeSpaceComplexityAnalysis;/*
Time Complexity : O(n * log(n))
Space Complexity : O(1)
A more optimized solution to this problem is possible
using HashMaps. Which will take:
Time Complexity: O(n)
Space Complexity : O(n)
Where 'n' is the size of the Array/List
*/
import java.util.Arrays;
public class test {
    public static int pairSum(int[] arr, int num) {
        Arrays.sort(arr);
        int startIndex = 0;
        int endIndex = (arr.length - 1);
        int numPair = 0;
        while(startIndex < endIndex) {
            if(arr[startIndex] + arr[endIndex] < num) {
                startIndex++;
            }
            else if (arr[startIndex] + arr[endIndex] > num) {
                endIndex--;
            } else {
                int elementAtStart = arr[startIndex];
                int elementAtEnd = arr[endIndex];
                if (elementAtStart == elementAtEnd) {
                    int totalElementsFromStartToEnd = (endIndex - startIndex) + 1;
                    numPair += (totalElementsFromStartToEnd *
                            (totalElementsFromStartToEnd - 1) / 2);
                    return numPair;
                }
                int tempStartIndex = startIndex + 1;
                int tempEndIndex = endIndex - 1;
                while (tempStartIndex <= tempEndIndex && arr[tempStartIndex] == elementAtStart) {
                    tempStartIndex += 1;
                }
                while(tempEndIndex >= tempStartIndex && arr[tempEndIndex] == elementAtEnd) {
                    tempEndIndex -= 1;
                }
                int totalElementsFromStart = (tempStartIndex - startIndex);
                int totalElementsFromEnd = (endIndex - tempEndIndex);
                numPair += (totalElementsFromStart * totalElementsFromEnd);
                startIndex = tempStartIndex;
                endIndex = tempEndIndex;
            }
        }
        return numPair;
    }
}