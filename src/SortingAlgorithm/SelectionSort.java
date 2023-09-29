package SortingAlgorithm;

import edu.princeton.cs.algs4.In;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int l = arr.length;
        for (int i = 0; i < l - 1; i++) {
            int minI = i;
            for (int j = i + 1; j < l; j++)
                if (arr[j] < arr[minI])
                    minI = j;
            int temp = arr[minI];
            arr[minI] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        In in = new In("E:\\Study\\UET\\2023_2024\\Term_1\\DSA\\Thuc_hanh\\algs4-data\\1Mints.txt");
        int[] arr = in.readAllInts();
        System.out.println("Length: " + arr.length);
        long start = System.currentTimeMillis();
        selectionSort(arr);
        long end = System.currentTimeMillis();

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("Time used: " + (end - start) + "ms");
    }

}