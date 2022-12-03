package L11_Queue;

import java.util.Queue;

public class a4_ReverseFirstKelementsInTheQueue {

    public static void reverseQueue(Queue<Integer> in,int n ){
        if(n<=0) return;
        else{
            int front = in.poll();
            reverseQueue(in,--n);
            in.add(front);
        }
    }

    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
        //Your code goes here
        reverseQueue(input,k);
        int n = input.size();
        for(int i = n-k;i>0;i--){
            input.add(input.poll());
        }
        return input;

    }
}
