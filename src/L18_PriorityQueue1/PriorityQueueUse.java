package L18_PriorityQueue1;

public class PriorityQueueUse {
    public static void main(String[] args) throws PriorityQueueException {
        PriorityQueue pq = new PriorityQueue();
        pq.insert(10);
        pq.print();
//        pq.insert(8);
//        pq.print();
//        pq.insert(7);
//        pq.print();
//        pq.insert(11);
//        pq.print();
//        pq.insert(5);
//        pq.print();
//        pq.insert(4);
//        pq.print();

        System.out.println("REmoving elements" );
        System.out.println(pq.removeMin());
        pq.print();
//        System.out.println(pq.removeMin());
//        pq.print();
//        System.out.println(pq.removeMin());
//        pq.print();
//        System.out.println(pq.removeMin());
//        pq.print();
//        System.out.println(pq.removeMin());
//        pq.print();
//        System.out.println(pq.removeMin());
//        pq.print();
    }
}
