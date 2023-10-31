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

public class BalancedBrackets {
class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

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
            } else if (charVAR.isEmpty()) return "NO";

            if (s.charAt(i) == ')' && charVAR.peek() != '(')
                return "NO";
            if (s.charAt(i) == ']' && charVAR.peek() != '[')
                return "NO";
            if (s.charAt(i) == '}' && charVAR.peek() != '{')
                return "NO";
            charVAR.pop();
        }
        return charVAR.size() == 0 ? "YES" : "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
}
