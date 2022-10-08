package L9_LinkedList2;

public class a2_MergeTwoSortedLL {
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        if (head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        LinkedListNode<Integer> t1 = head1,t2 = head2;
        LinkedListNode<Integer> t3 = null ,h3 = null ;
        if(t1.data <t2.data){
            t3 = t1;
            h3 = t1;
            t1 = t1.next;
        }else{
            t3 = t2;
            h3 = t2;
            t2 = t2.next;
        }
        while(t1!= null && t2 != null){
            if(t1.data < t2.data){
                t3.next =   t1;
                t3 = t1;
                t1 = t1.next;
            }else{
                t3.next = t2;
                t3 = t2;
                t2 = t2.next;
            }
        }

        if(t1!=null){
            t3.next = t1;
        }else if(t2!=null){
            t3.next = t2;
        }
        return  h3;
    }
}
