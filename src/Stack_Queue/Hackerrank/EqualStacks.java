package Stack_Queue.Hackerrank;

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
class Result {

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

        while (!stack1.isEmpty() && !stack2.isEmpty() && !stack3.isEmpty()) {
            int stack1Height = stack1.peek();
            int stack2Height = stack2.peek();
            int stack3Height = stack3.peek();

            if (stack1Height == stack2Height && stack1Height == stack3Height) {
                return stack1Height;
            }

            if (stack1Height >= stack2Height && stack1Height >= stack3Height) {
                stack1.pop();
            } else if (stack2Height >= stack1Height && stack2Height >= stack3Height) {
                stack2.pop();
            } else if (stack3Height >= stack2Height && stack3Height >= stack1Height) {
                stack3.pop();
            }
        }
        return 0;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
}
