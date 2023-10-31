package SortingAlgorithm;

import edu.princeton.cs.algs4.StdRandom;

public class QuickDuelPivot {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        if (less(a[hi], a[lo])) exch(a, lo, hi);
        int lt = lo+1, gt = hi-1, i = lo+1;

        while (i <= gt) {
            if (less(a[i], a[lo])) { exch(a, lt++, i++); }
            else if (less(a[hi], a[i])) exch(a, i, gt--);
            else i++;
        }
        exch(a, lo, --lt);
        exch(a, hi, ++gt);

        sort(a, lo, lt-1);
        sort(a, lt+1, gt-1);
        sort(a, gt+1, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable left, Comparable right) {
        return left.compareTo(right) < 0;
    }
}
