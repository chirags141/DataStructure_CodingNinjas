package test2;
/*
Next Number
Send Feedback
Given a large number represented in the form of a linked list. Write code to increment the number by 1 in-place(i.e. without using extra space).
Note: You don't need to print the elements, just update the elements and return the head of updated LL.
Input Constraints:
1 <= Length of Linked List <=10^6.
Input format :
Line 1 : Linked list elements (separated by space and terminated by -1)
Output Format :
Line 1: Updated linked list elements
Sample Input 1 :
3 9 2 5 -1
Sample Output 1 :
3 9 2 6
Sample Input 2 :
9 9 9 -1
Sample Output 1 :
1 0 0 0
 */
class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}
public class NextNumber {


    public  static LinkedListNode<Integer> reverseLL(LinkedListNode<Integer>  head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode<Integer> smallAns = reverseLL(head.next);
        LinkedListNode<Integer> temp = smallAns;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        head.next = null;

        return smallAns;
    }

    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> temp  = reverseLL(head);
        head = temp;
        head.data += 1;
        while(temp.next != null){
//            if(temp.data > 9){
//                temp.next.data += temp.data/10;
//                temp.data = temp.data%10;
//            }
            if(temp.data == 10){
                temp.next.data += 1 ;
                temp.data = 0 ;
            }
            temp = temp.next;
        }
        if(temp.data == 10){
            temp.data = 0;
            temp.next = new LinkedListNode<>(1);
            temp.next.next = null;
        }

        LinkedListNode<Integer> ans = reverseLL(head);

        return ans;


    }

}
