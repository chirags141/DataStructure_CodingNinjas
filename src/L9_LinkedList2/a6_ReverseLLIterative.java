package L9_LinkedList2;

public class a6_ReverseLLIterative {
    public static LinkedListNode<Integer> reverse_I(LinkedListNode<Integer> head){
        LinkedListNode<Integer> p,c,n;
        p = null;
        c = head;
        n = head.next; // prev,curr,next
        while(c!=null && n.next!=null){
            c.next = p;
            p = c;
            c = n;
            n = n.next;
        }
        return p;
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
    }
}
