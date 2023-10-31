import java.util.*;

public class S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int queries = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();
        int id = 0;

        while (queries-- > 0) {
            int k = sc.nextInt();
            switch (k) {
                case 1 -> {
                    dq.add(++id);
                }

                case 2 -> {
                    if (!dq.isEmpty()) {
                        int tmp = dq.pollFirst();
                        System.out.println(tmp);
                    } else System.out.println(0);
                }

                case 3 -> {
                    if (!dq.isEmpty()) {
                        int tmp = dq.pollLast();
                        System.out.println(tmp);
                    } else System.out.println(0);
                }

                case 4 -> {
                    System.out.println(dq.size());
                }

                case 5 -> {
                    int u = sc.nextInt();
                    if (u > 0 && u <= dq.size()) {
                        int index = 1;
                        for (Integer ele : dq) {
                            if (index == u) {
                                System.out.println(ele);
                                break;
                            }
                            index++;
                        }
                    } else
                        System.out.println(0);
                }
            }
        }
    }
}