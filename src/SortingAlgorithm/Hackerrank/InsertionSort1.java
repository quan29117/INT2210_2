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

public class InsertionSort1 {
    class Result {

        /*
         * Complete the 'insertionSort1' function below.
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

        public static void insertionSort1(int n, int[] arr) {
            // Write your code here
            int sortElement = arr[n-1];
            int i;
            for (i = n - 2; i > -1; i--) {
                if (sortElement < arr[i]) {
                    arr[i+1] = arr[i];
                    print(n, arr);
                } else break;
            }
            arr[i+1] = sortElement;
            print(n, arr);
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
            Result.insertionSort1(s, ar);
        }
    }
}
