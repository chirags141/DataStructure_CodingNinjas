package L9_LinkedList2;
/*
Swap two Nodes of LL
Send Feedback
You have been given a singly linked list of integers along with two integers, 'i,' and 'j.' Swap the nodes that are present at the 'i-th' and 'j-th' positions.
Note :
Remember, the nodes themselves must be swapped and not the datas.

No need to print the list, it has already been taken care. Only return the new head to the list.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space.

The second line of input contains two integer values 'i,' and 'j,' respectively. A single space will separate them.
 Remember/consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= i < M
0 <= j < M

Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3 4
Sample Output 1 :
3 4 5 6 2 1 9
 Sample Input 2 :
2
10 20 30 40 -1
1 2
70 80 90 25 65 85 90 -1
0 6
 Sample Output 2 :
10 30 20 40
90 80 90 25 65 85 70
 */
public class a10_SwapTwoNodesOfALL {

    public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
        LinkedListNode<Integer> p1 = null;
        LinkedListNode<Integer> c1 = null;
        LinkedListNode<Integer> p2 = null;
        LinkedListNode<Integer> c2 = null;
        LinkedListNode<Integer> temp = null;
        LinkedListNode<Integer> tempHead = head;
        int pos = 0;

        // Multiple cases
        // Case 1
        // When one of the position is 0
        if(i == 0 || j == 0){
            if(i == 0){
                c1 = head;

                tempHead = head;
                pos = 0;
                while(pos < j-1 && tempHead != null){
                    tempHead = tempHead.next;
                    pos++;
                }
                p2 = tempHead;
                if(p2 == null){
                    return head;
                }
                c2 = p2.next;

                // Swapping nodes
                head = c2;
                temp = c2.next;
                c2.next = c1.next;
                p2.next = c1;
                c1.next = temp;
            }
            if(j == 0){
                c2 = head;
                tempHead = head;
                pos = 0;
                while(pos < i-1 && tempHead != null){
                    tempHead = tempHead.next;
                    pos++;
                }
                p1 = tempHead;
                if(p1 == null){
                    return head;
                }
                c1 = p1.next;

                // Swapping nodes
                head = c1;
                temp = c1.next;
                c1.next = c2.next;
                p1.next = c2;
                c2.next = temp;

            }
        }
        else{
            while(pos < i-1 && tempHead != null){
                tempHead = tempHead.next;
                pos++;
            }
            p1 = tempHead;
            if(p1 == null){
                return head;
            }
            c1 = p1.next;

            tempHead = head;
            pos = 0;
            while(pos < j-1 && tempHead != null){
                tempHead = tempHead.next;
                pos++;
            }
            p2 = tempHead;
            if(p2 == null){
                return head;
            }
            c2 = p2.next;
            // SWAPPING OF NODES
            p1.next = c2;
            p2.next = c1;
            temp = c1.next;
            c1.next = c2.next;
            c2.next = temp;
        }

        return head;
    }

}
