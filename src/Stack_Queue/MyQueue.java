package Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * This Structure use two stacks to contain elements with FIFO
 */
public class MyQueue {
    private Stack<Integer> newestElement;
    private Stack<Integer> oldestElement;

    public MyQueue() {
        newestElement = new Stack<Integer>();
        oldestElement = new Stack<Integer>();
    }

    /**
     * Push new element to "queue"
     *
     * @param n the new element pushed
     */
    public void enqueue(int n) {
        newestElement.push(n);
    }

    /**
     * Remove the oldest element
     *
     * @return value of the oldest element that is removed
     */
    public int dequeue() {
        if (!oldestElement.isEmpty()) return oldestElement.pop();
        oldestElement.empty();
        while (!newestElement.isEmpty())
            oldestElement.push(newestElement.pop());
        return oldestElement.pop();
    }

    /**
     * Get the value of the oldest element
     *
     * @return value of the oldest element
     */
    public int peek() {
        if (!oldestElement.isEmpty()) return oldestElement.peek();
        oldestElement.empty();
        while (!newestElement.isEmpty())
            oldestElement.push(newestElement.pop());
        return oldestElement.peek();
    }

    public boolean isEmpty() {
        return newestElement.isEmpty() || oldestElement.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyQueue queue = new MyQueue();

        int queries = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        while (queries-- > 0) {
            int type = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            switch (type) {
                case 1 -> {
                    int num = scanner.nextInt();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    queue.enqueue(num);
                }

                case 2 -> {
                    if (queue.isEmpty())
                        queue.dequeue();
                }

                case 3 -> {
                    System.out.println(queue.peek());
                }
            }
        }
    }
}
