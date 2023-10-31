package PriorityQueue;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        StdRandom.setSeed(System.currentTimeMillis());
        int[] a = new int[10000000];

        runTest(1000000, a);
        runTest(1000000, a);
        runTest(1000000, a);

        runTest(4000000, a);
        runTest(4000000, a);
        runTest(4000000, a);

        runTest(8000000, a);
        runTest(8000000, a);
        runTest(8000000, a);

        runTest(10000000, a);
        runTest(10000000, a);
        runTest(10000000, a);
    }

    private static void runTest(int n, int[] a) {
        for (int i = 0; i < n; i++) a[i] = i;
        StdRandom.shuffle(a);

        PQ<Integer> pq = new PQ4ary<Integer>();
        double insertPQ4 = insertAll(pq, a);
        double delMaxPQ4 = delAll(pq, a.length);
        System.out.print(n + "\t" + insertPQ4 + "\t" + delMaxPQ4);

//        pq = new PQ2ary<>();
        double insertPQ2 = insertAll(pq, a);
        double delMaxPQ2 = delAll(pq, a.length);
        System.out.print(n + "\t\t" + insertPQ2 + "\t" + delMaxPQ2);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        double insertPQ = insertAllLib(q, a);
        double delMaxPQ = delAllLib(q, a.length);
        System.out.println("\t\t" + insertPQ  + "\t" + delMaxPQ);
    }

    private static double delAllLib(PriorityQueue<Integer> q, int length) {
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < length; i++)
            q.poll();
        return (System.currentTimeMillis() - t0) * 1.0 / length;
    }

    private static double insertAllLib(PriorityQueue<Integer> pq, int[] a) {
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            pq.add(a[i]);
        }
        return (System.currentTimeMillis() - t0) * 1.0 / a.length;
    }

    private static double delAll(PQ<Integer> pq, int length) {
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < length; i++)
            pq.delMax();
            //System.err.print(" " + pq.delMax());
        return (System.currentTimeMillis() - t0) * 1.0 / length;
    }

    private static double insertAll(PQ<Integer> pq, int[] a) {
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            pq.insert(a[i]);
        }
        return (System.currentTimeMillis() - t0) * 1.0 / a.length;
    }
}
