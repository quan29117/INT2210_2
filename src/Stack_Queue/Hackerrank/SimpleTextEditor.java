package Stack_Queue.Hackerrank;

import java.io.*;
import java.util.*;

public class SimpleTextEditor {
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int type, k;
        String last, newString;
        Stack<String> stack = new Stack<>();

        while (queries-- > 0) {
            type = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            switch (type) {
                case 1 -> {
                    if (stack.size() > 0)
                        last = stack.peek();
                    else last = "";
                    newString = last + scanner.next();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    stack.push(newString);
                }
                case 2 -> {
                    k = scanner.nextInt();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    last = stack.peek();
                    newString = last.substring(0, last.length() - k);
                    stack.push(newString);
                }
                case 3 -> {
                    k = scanner.nextInt() - 1;
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    if (stack.size() > 0) {
                        last = stack.peek();
                        String c = String.valueOf(last.charAt(k));
                        System.out.println(c);
                    }
                }
                case 4 -> {
                    stack.pop();
                }
            }
        }
    }
}

}
