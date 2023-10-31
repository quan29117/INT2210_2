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

public class InsertionSort2 {
    class Result {

        /*
         * Complete the 'insertionSort2' function below.
         *
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER_ARRAY arr
         */

        public static void print(int n, int[] arr) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        public static void insertionSort2(int n, int[] arr) {
            // Write your code here
            for (int i = 0; i < n - 1; i++) {
                int j = i + 1;
                while (j > 0) {
                    if (arr[j] < arr[j-1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = tmp;
                        j--;
                    } else break;
                }
                print(n, arr);
            }
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            Scanner in = new Scanner(System.in);
            int s = in.nextInt();
            int[] ar = new int[s];
            for(int i = 0; i < s; i++) {
                ar[i] = in.nextInt();
            }
            Result.insertionSort2(s, ar);
        }
    }

}
