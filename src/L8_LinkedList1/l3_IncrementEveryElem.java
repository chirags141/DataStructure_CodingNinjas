package L8_LinkedList1;

public class l3_IncrementEveryElem {
    public static  void increment(LinkedListNode<Integer> head){
        LinkedListNode<Integer> temp = head;
        while(temp!=null)
        {
            temp.data++;
            temp = temp.next;
        }
    }
}
