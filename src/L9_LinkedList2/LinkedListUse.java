package L9_LinkedList2;

import java.util.Scanner;

public class LinkedListUse {
    public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int position, int elem){
        LinkedListNode<Integer> newNode = new LinkedListNode<>(elem);
        LinkedListNode<Integer> temp = head;
        int count = 0 ;
        if(position == 0){
            newNode.next = head;
            head = newNode;
            return head;
        }
        while(temp != null && count <position-1){
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    public static LinkedListNode<Integer> takeInput()
    {
        LinkedListNode<Integer> head = null, tail = null;
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        while(data != -1){
            LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode; // tail = tail.next
            }
            data = s.nextInt();
        }
        return head;
    }

    public static void print(LinkedListNode<Integer> head){

        while(head != null){
            System.out.print(head.data +" ");
            head = head.next;
        }
        System.out.println();

    }

    public  static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos){

        // Write your code here.
        if(head == null) return head;
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> prev = null;
        int i = 0;

        if(pos == 0){
            return head.next;
        }
        while (curr != null && i<pos){
            prev = curr;
            curr = curr.next;
            i++;
        }
        if(curr == null ) return head;
        prev.next = curr.next;

        return head;
    }

    public static void main(String[] args) {

        LinkedListNode<Integer> head = takeInput();

        LinkedListNode<Integer> newHead = a6_ReverseLLIterative.reverse_I(head);
        print(head);
        /*
        LinkedListNode head1 = a5_ReverseRecursiveLL.reverseLinkedListRec(head);
        print(head1);
 */

    }

}