package L11_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class a2_StackUsing2Queues {
    //Define the data members
    Queue<Integer> q1;
    Queue<Integer> q2;

    public a2_StackUsing2Queues() {
        //Implement the Constructor
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        //Implement the getSize() function
        return q1.size();
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return this.getSize() == 0;
    }

    public void push(int element) {
        if(q1 == null){
            q1.add(element);
        }else{
            q2.add(element);
            while(!q1.isEmpty()){
                q2.add(q1.poll());
            }
            while(!q2.isEmpty())
            {
                q1.add(q2.poll());
            }
        }
    }

    public int pop() {
        if(q1.size() == 0) return -1;
        return q1.poll();
    }

    public int top() {
        //Implement the top() function
        if(q1.size() == 0) return -1;
        return q1.peek();
    }

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        a2_StackUsing2Queues stack = new a2_StackUsing2Queues();

        int q = s.nextInt();

        while (q > 0) {
            int choice, input;
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    input = s.nextInt();
                    stack.push(input);
                    break;

                case 2:
                    System.out.println(stack.pop());
                    break;

                case 3:
                    System.out.println(stack.top());
                    break;

                case 4:
                    System.out.println(stack.getSize());
                    break;

                default:
                    System.out.println((stack.isEmpty()) ? "true" : "false");
            }

            q -= 1;
        }

    }

}