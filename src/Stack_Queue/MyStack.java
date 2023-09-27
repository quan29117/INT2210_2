package Stack_Queue;

import edu.princeton.cs.algs4.*;

import java.util.Scanner;

public class MyStack {
    public static String isBalanced(String s) {
        // Write your code here
        if (s.length() % 2 != 0) return "NO";

        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')
            return "NO";

        Stack<Character> charVAR = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                charVAR.push(s.charAt(i));
                continue;
            }
            else if (charVAR.isEmpty()) return "NO";

            if (s.charAt(i) == ')' && charVAR.peek() != '(')
                return "NO";
            if (s.charAt(i) == ']' && charVAR.peek() != '[')
                return "NO";
            if (s.charAt(i) == '}' && charVAR.peek() != '{')
                return "NO";
            charVAR.pop();
        }
        return charVAR.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        String s = "{[()]}";
        System.out.print(isBalanced(s));
    }
}
