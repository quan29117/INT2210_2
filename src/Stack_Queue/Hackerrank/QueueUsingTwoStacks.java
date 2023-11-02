//package Stack_Queue.Hackerrank;
//
//import java.io.*;
//import java.util.*;
//
///**
// * This Structure use two stacks to contain elements with FIFO
// */
//public class QueueUsingTwoStacks {
//public class Solution {
//    private Stack<Integer> newestElement;
//    private Stack<Integer> oldestElement;
//
//    public Solution() {
//        newestElement = new Stack<Integer>();
//        oldestElement = new Stack<Integer>();
//    }
//
//    public void enqueue(int n) {
//        newestElement.push(n);
//    }
//
//    public int dequeue() {
//        if (!oldestElement.isEmpty()) return oldestElement.pop();
//        oldestElement.empty();
//        while (!newestElement.isEmpty())
//            oldestElement.push(newestElement.pop());
//        return oldestElement.pop();
//    }
//
//    public int peek() {
//        if (!oldestElement.isEmpty()) return oldestElement.peek();
//        oldestElement.empty();
//        while (!newestElement.isEmpty())
//            oldestElement.push(newestElement.pop());
//        return oldestElement.peek();
//    }
//
//    public boolean isEmpty() {
//        return newestElement.isEmpty() || oldestElement.isEmpty();
//    }
//
//    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner scanner = new Scanner(System.in);
//        Solution queue = new Solution();
//
//        int queries = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        while (queries-- > 0) {
//            int type = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            switch (type) {
//                case 1 -> {
//                    int num = scanner.nextInt();
//                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//                    queue.enqueue(num);
//                }
//
//                case 2 -> {
//                    queue.dequeue();
//                }
//
//                case 3 -> {
//                    System.out.println(queue.peek());
//                }
//            }
//        }
//    }
//}
//
//}
