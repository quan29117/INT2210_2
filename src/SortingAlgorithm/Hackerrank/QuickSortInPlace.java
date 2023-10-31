package SortingAlgorithm.Hackerrank;

import java.util.Scanner;

public class QuickSortInPlace {
public class Solution {
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pIndex = low;
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        int temp = arr[high];
        arr[high] = arr[pIndex];
        arr[pIndex] = temp;
        printArray(arr);
        return pIndex;
    }

    private static void quickSort(int[] arr, int low, int high) {
        int pivotIndex;
        if (low >= high) return;
        pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, arr.length - 1);
    }
}
}
