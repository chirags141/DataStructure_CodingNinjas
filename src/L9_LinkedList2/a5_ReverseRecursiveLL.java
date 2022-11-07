package L9_LinkedList2;

public class a5_ReverseRecursiveLL {

    public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode<Integer> smallHead = reverseLinkedListRec(head.next);
        LinkedListNode<Integer> tail = head.next;
        tail.next = head;
        head.next = null;

        return smallHead;
    }
    /*
    public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
        if(head == null || head.next == null){
            return head;
        }

        LinkedListNode<Integer> smallAns = reverseLinkedListRec(head.next);
        LinkedListNode<Integer> temp = smallAns;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        head.next = null;

        return smallAns;
    }
 */
}
