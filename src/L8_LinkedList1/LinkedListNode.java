package L8_LinkedList1;

public class LinkedListNode<T> {

    T data;
    LinkedListNode<T> next;

    LinkedListNode(T data){
        this.data = data;
        next = null;
    }

}