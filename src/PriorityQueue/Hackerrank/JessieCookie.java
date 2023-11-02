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

public class JessieCookie {
class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static class PQ2ary {
        public Integer[] pq;
        public int size;

        public PQ2ary(int size) {
            pq = new Integer[size + 1];
            this.size = 0;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        private void resize(int size) {
            Integer[] temp = new Integer[size];
            for (int i = 1; i <= this.size; i++) {
                temp[i] = pq[i];
            }
            pq = temp;
        }

        public void insert(int key) {
            if (size == pq.length - 1)
                resize(pq.length * 2);
            pq[++size] = key;
            swim(size);
        }

        public int delMax() {
            int max = pq[1];
            exch(1, size--);
            pq[size + 1] = null;
            sink(1);
            return max;
        }

        private void swim(int k) {
            while (k > 1 && greater(k / 2, k)) {
                exch(k, k / 2);
                k = k / 2;
            }
        }

        private void sink(int k) {
            while (2 * k <= this.size) {
                int j = 2 * k;
                if (j < this.size && greater(j, j + 1)) j++;
                if (!greater(k, j)) break;
                exch(k, j);
                k = j;
            }
        }

        public int peek() {
            return pq[1];
        }

        private boolean greater(int i, int j) {
            return pq[i] > pq[j];
        }

        private void exch(int i, int j) {
            int tmp = pq[i];
            pq[i] = pq[j];
            pq[j] = tmp;
        }
    }

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        int N = A.size();
        PQ2ary pq = new PQ2ary(N);
        for (int i = 0; i < N; i++) {
            pq.insert(A.get(i));
        }
        int ans = 0;
        while (pq.size > 0) {
            Integer firstEle = pq.delMax();
            if (firstEle >= k) break;
            else if (pq.isEmpty()) {
                ans = -1;
                break;
            } else {
                Integer secondEle = pq.delMax();
                Integer addEle = firstEle + 2*secondEle;
                pq.insert(addEle);
                ans++;
            }
        }
        return ans;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
}
