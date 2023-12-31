package SortingAlgorithm;

import edu.princeton.cs.algs4.In;

import java.io.FileNotFoundException;

public class InsertionSort {
    @Override
    public boolean equals(Object a) {
        if (a.getClass() != InsertionSort.class) return false;
        return true;
    }

    public static void insertionSort(int[] a) {
        int temp;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j-1]) {
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                } else break;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        In in = new In("E:\\Study\\UET\\2023_2024\\Term_1\\DSA\\Thuc_hanh\\algs4-data\\16Kints.txt");
        int[] arr = in.readAllInts();
        System.out.println("Length: " + arr.length);
        long start = System.currentTimeMillis();
        insertionSort(arr);
        long end = System.currentTimeMillis();

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\nTime used: " + (end - start) + "ms");
    }
}