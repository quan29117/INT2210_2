package Vebo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WhoIsInTheMiddle {
    public static PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
    public static PriorityQueue<Integer> high = new PriorityQueue<>();

    public static void add(Integer x) {
        if (low.size() < high.size()) {
            low.add(x);
        } else high.add(x);

        if (!high.isEmpty() && !low.isEmpty())
            if (high.peek() < low.peek()) {
                Integer tmp = high.poll();
                high.add(low.poll());
                low.add(tmp);
            }
    }

    public static Integer peak() {
        if (!high.isEmpty())
            return (low.size() < high.size() ? high.peek() : low.peek());
        return 0;
    }

    public static Integer poll() {
        if (!high.isEmpty())
            return (low.size() < high.size() ? high.poll() : low.poll());
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int queries = sc.nextInt();

        ArrayList<Integer> height = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            add(sc.nextInt());
        }

        while (queries-- > 0) {
            int k = sc.nextInt();
            switch (k) {
                case 1 -> {
                    add(sc.nextInt());
                }

                case 2 -> {
                    poll();
                }

                case 3 -> {
                    System.out.println(peak());
                }

                case 4 -> {
                    System.out.println(low);
                }

                case 5 -> {
                    System.out.println(high);
                }
            }
        }
    }
}
