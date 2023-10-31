import java.util.Scanner;

public class S1 {
    public static class UF {
        public static int[] id;
        public static int connectedComponentNum;
        public static int largestSize;

        public UF(int N) {
            connectedComponentNum = N;
            largestSize = 1;
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = -1;
            }
        }

        public static int findRoot(int u) {
            if (id[u] <= -1) return u;
            else return id[u] = findRoot(id[u]);
        }

        public static void Union(int a, int b) {
            a = findRoot(a);
            b = findRoot(b);

            if (a != b) {
                if (id[a] < id[b]) {
                    id[a] += id[b];
                    if (largestSize < Math.abs(id[a])) largestSize = Math.abs(id[a]);
                    id[b] = a;
                    connectedComponentNum--;
                } else {
                    id[b] += id[a];
                    if (largestSize < Math.abs(id[b])) largestSize = Math.abs(id[b]);
                    id[a] = b;
                    connectedComponentNum--;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int queries = sc.nextInt();

        UF uf = new UF(num);

        while (queries-- > 0) {
            int k = sc.nextInt();
            switch (k) {
                case 1 -> {
                    int p = sc.nextInt();
                    int q = sc.nextInt();
                    uf.Union(p-1, q-1);
                }
                case 2 -> {
                    System.out.println(uf.connectedComponentNum);
                }

                case 3 -> {
                    int u = sc.nextInt();
                    u--;
                    if (uf.id[u] < 0)
                        System.out.println(Math.abs(uf.id[u]));
                    else System.out.println(Math.abs(uf.id[uf.findRoot(u)]));
                }

                case 4 -> {
                    System.out.println(uf.largestSize);
                }
            }
        }
    }
}
