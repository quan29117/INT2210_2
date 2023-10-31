package SortingAlgorithm.Hackerrank;

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

public class IntroToTutorialChalleges {
    class Result {

        /*
         * Complete the 'introTutorial' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER V
         *  2. INTEGER_ARRAY arr
         */

        private static int binarySearch(List<Integer> arr, int V, int lo, int hi) {
            int mid = lo + (hi - lo) / 2;

            if (lo <= hi) {
                if (arr.get(mid).intValue() < V) {
                    return binarySearch(arr, V, mid + 1, hi);
                } else if (arr.get(mid).intValue() > V) {
                    return binarySearch(arr, V, lo, mid - 1);
                } else
                    return mid;
            }
            return -1;
        }

        public static int introTutorial(int V, List<Integer> arr) {
            return binarySearch(arr, V, 0, arr.size() - 1);
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int V = Integer.parseInt(bufferedReader.readLine().trim());

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = Result.introTutorial(V, arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
