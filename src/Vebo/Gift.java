package Vebo;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Gift {
    public static PriorityQueue<Integer> low = new PriorityQueue<>();
    public static long sum = 0;

    public static void add(Integer x) {
        if (low.size() < 4) {
            low.add(x);
            sum += x;
        } else if (low.peek() < x) {
            sum -= low.poll();
            low.add(x);
            sum += x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < num; i++) {
            add(sc.nextInt());
            System.out.print(sum + " ");
        }
    }
}
