package Sum_Week2;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

import static java.lang.Math.ceil;

public class ThreeSum {
    public void print(int num1, int num2) {
        System.out.println(num1 + " " + num2 + " " + -(num1 + num2));
    }

    public int binarySearch(int[] arr, int key, int firstIndex, int lastIndex) {
        int mid = firstIndex + (lastIndex - firstIndex) / 2;

        if (firstIndex < lastIndex) {
            if (arr[mid] < key)
                return binarySearch(arr, key, mid + 1, lastIndex);
            else if (arr[mid] > key)
                return binarySearch(arr, key, firstIndex, mid - 1);
            else
                return mid;
        }
        //Key not found
        return -1;
    }

    public void run() {
        In in = new In("E:\\Study\\UET\\2023_2024\\Term_1\\DSA\\Thuc_hanh\\src\\Sum_Week2\\test.txt");
        int[] arr = in.readAllInts();

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; ++i)
            for (int j = i + 1; j < arr.length; ++j) {
                int thirdNum = (int) ((double) arr[i] / 2 + (double) arr[j] / 2) * -2;   //1.4.2
                int k = binarySearch(arr, thirdNum, j + 1, arr.length - 1);
                if (k > -1) print(arr[i], arr[j]);
            }
    }
}
