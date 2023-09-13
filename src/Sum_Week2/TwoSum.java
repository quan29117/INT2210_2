package Sum_Week2;

import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class TwoSum {
    public void print(int num, int pairNum) {
        System.out.println(num + " " + -num + " Num of Pairs: " + pairNum);
    }

    public void run() {
        In in = new In("E:\\Study\\UET\\2023_2024\\Term_1\\DSA\\Thuc_hanh\\src\\Sum_Week2\\test.txt");
        int[] arr = in.readAllInts();

        Arrays.sort(arr);
        int head = 0, tail = arr.length - 1;
        while (arr[head] < 0 && arr[tail] > 0) {
            if (arr[head] + arr[tail] < 0) head++;
            else if (arr[head] + arr[tail] > 0) tail--;
            else {
                //Check duplicate
                int headDup = 1, tailDup = 1;
                while (arr[head] == arr[++head]) headDup++;
                while (arr[tail] == arr[--tail]) tailDup++;
                int pairNum = headDup * tailDup;

                //Print
                print(arr[head - 1], pairNum);
            }
        }

        //Count how many number 0
        int zeroDup = 0;
        while (arr[head++] == 0) zeroDup++;
        if (zeroDup > 1)
            print(0,zeroDup * (zeroDup - 1) / 2);
    }
}
