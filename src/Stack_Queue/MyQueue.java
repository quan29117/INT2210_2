package Stack_Queue;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MyQueue {
    public static void main(String[] args) {
        int numberOfQueries = StdIn.readInt();
        Queue<Integer> myQueue = new Queue<Integer>();
        while (numberOfQueries-- > 0) {
            int query = StdIn.readInt();
            int num = StdIn.readInt();
            switch (query) {
                case 1-> myQueue.enqueue(num);
                case 2-> myQueue.dequeue();
                case 3-> StdOut.println(myQueue.peek());
            }
            StdIn.
        }
    }
}
