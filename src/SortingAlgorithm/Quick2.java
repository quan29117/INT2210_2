package SortingAlgorithm;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Comparator;

public class Quick2 {

    static class MyComparator implements Comparator<Comparable> {
        @Override
        public int compare(Comparable l, Comparable r) {
            return l.compareTo(r);
        }
    };

    public static void sort(Comparable[] a) {
        Comparator<Comparable> comparator = new MyComparator();
        sort(a, comparator);
    }

    public static<Item> void sort(Item[] a, Comparator<Item> comparator) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1, comparator);
    }

    private static<Item> void sort(Item[] a, int lo, int hi, Comparator<Item> comparator) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi, comparator);
        sort(a, lo, j-1, comparator);
        sort(a, j+1, hi, comparator);
    }

    private static<Item> int partition(Item[] a, int lo, int hi, Comparator<Item> comparator) {
        int i = lo;
        int j = hi+1;
        while (true) {
            while (less(a[++i], a[lo], comparator))
                if (i == hi) break;
            while (less(a[lo], a[--j], comparator))
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static<Item> void exch(Item[] a, int i, int j) {
        Item temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static<Item> boolean less(Item left, Item right, Comparator<Item> comparator) {
        return comparator.compare(left, right) < 0;
    }

    public static void main(String[] args) {
        int N = 10;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) a[i] = i;
        StdRandom.shuffle(a);

        Arrays.sort(a, new ReverseOrder());
        Quick2.sort(a, new ReverseOrder());
        for (int i = 0; i < N; i++)
            StdOut.print(a[i] + " ");

        StdOut.println("\n==============");
        StdRandom.shuffle(a);
        Quick2.sort(a);
        for (int i = 0; i < N; i++)
            StdOut.print(a[i] + " ");
    }

    static class ReverseOrder implements Comparator<Integer> {
        @Override
        public int compare(Integer l, Integer r) {
            return -Integer.compare(l,r);
        }
    }

//    static class PersonOrderByName implements Comparator<Person> {
//        @Override
//        public int compare(Person l, Person r) {
//            return l.name.compareTo(r.name);
//        }
//    }
//
//    static class PersonOrderByAge implements Comparator<Person> {
//        @Override
//        public int compare(Person l, Person r) {
//            return Integer.compare(l.age,r.age);
//        }
//    }
}
