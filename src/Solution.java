import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int queries = sc.nextInt();

        Queue<Integer> way1 = new LinkedList<>();
        Stack<Integer> way2 = new Stack<>();
        Queue<Integer> allTrains = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            allTrains.add(i + 1);
        }

        while (queries-- > 0) {
            int k = sc.nextInt();
            switch (k) {
                case 1 -> {
                    int i = sc.nextInt();
                    if (i == 1) {
                        if (!allTrains.isEmpty()) {
                            way1.add(allTrains.poll());
                        }
                    } else {
                        if (!allTrains.isEmpty()) {
                            way2.push(allTrains.poll());
                        }
                    }
                }

                case 2 -> {
                    int i = sc.nextInt();
                    if (i == 1 && !way1.isEmpty()) {
                        System.out.println(way1.poll());
                    } else if (i == 2 && !way2.isEmpty()) {
                        System.out.println(way2.pop());
                    }
                }

                case 3 -> {
                    int i = sc.nextInt();
                    if (i == 1) {
                        System.out.println(way1.size());
                    } else {
                        System.out.println(way2.size());
                    }
                }

                case 4 -> {
                    System.out.println(allTrains.size());
                }

                case 5 -> {
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    if (u == 1 && !way1.isEmpty()) {
                        System.out.println(way1.peek() + v - 1);
                    } else if (u == 2 && !way2.isEmpty()) {
                        System.out.println(way2.peek() + v - 1);
                    } else {
                        System.out.println(0);
                    }
                }
            }
        }
    }
}