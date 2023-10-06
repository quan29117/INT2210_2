package Stack_Queue;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class EqualStacks {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        Stack<Integer> stack3 = new Stack();

        int height = 0;
        for (int i = h1.size() - 1; i > -1; i--) {
            height += h1.get(i);
            stack1.push(height);
        }

        height = 0;
        for (int i = h2.size() - 1; i > -1; i--) {
            height += h2.get(i);
            stack2.push(height);
        }

        height = 0;
        for (int i = h3.size() - 1; i > -1; i--) {
            height += h3.get(i);
            stack3.push(height);
        }

        height = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty() && !stack3.isEmpty()) {
            if (stack1.peek() == stack2.peek() && stack1.peek() == stack3.peek()) {
                height = stack1.peek();
                break;
            }

            if (stack1.peek() >= stack2.peek() && stack1.peek() >= stack3.peek()) {
                stack1.pop();
            }

            if (stack2.peek() >= stack1.peek() && stack2.peek() >= stack3.peek()) {
                stack2.pop();
            }

            if (stack3.peek() >= stack2.peek() && stack3.peek() >= stack1.peek()) {
                stack3.pop();
            }
        }

        return height;
    }

    public static void main(String[] args) throws IOException {;
        //add 3 List<Integer> h1, h2, h3
        List<Integer> h1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            h1.add(1);
        }
        h1.add(2);

        List<Integer> h2 = new ArrayList<>();
        h2.add(3); h2.add(7);

        List<Integer> h3 = new ArrayList<>();
        h3.add(1); h3.add(3); h3.add(1);

        int result = EqualStacks.equalStacks(h1, h2, h3);

        System.out.println(String.valueOf(result));
    }
}
