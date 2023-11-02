package PriorityQueue.Hackerrank;

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

public class FindTheRunningMedian {
class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
    public static PriorityQueue<Integer> high = new PriorityQueue<>();

    public static void add(Integer x) {
        if (low.size() < high.size()) {
            low.add(x);
        } else high.add(x);

        if (!high.isEmpty() && !low.isEmpty())
            if (high.peek() < low.peek()) {
                Integer tmp = high.poll();
                high.add(low.poll());
                low.add(tmp);
            }
    }

    public static Integer peak() {
        if (!high.isEmpty())
            return (low.size() < high.size() ? high.peek() : low.peek());
        return 0;
    }

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        List<Double> ans = new ArrayList<>();

        for (Integer ele : a) {
            add(ele);
            if ((low.size() + high.size()) % 2 == 0) {
                ans.add((low.peek() + high.peek()) / 2.);
            } else if (!low.isEmpty()){
                ans.add(peak().doubleValue());
            } else {
                ans.add(high.peek().doubleValue());
            }
        }
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
}
