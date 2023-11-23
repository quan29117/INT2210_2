package Vebo;

import java.util.Scanner;

public class CamThuat {
    public static int[] arr = new int[300005];
    public static int[] tree = new int[300005 * 4];

    public static void build(int l, int r, int id) {
        if (l == r) {
            tree[id] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(l, mid, id * 2);
        build(mid + 1, r, id * 2 + 1);
        tree[id] = Math.max(tree[id * 2], tree[id * 2 + 1]);
    }

    private static int get(int l, int r, int id, int u, int v) {
        if (v < l || r < u) return Integer.MIN_VALUE;
        if (u <= l && r <= v) return tree[id];
        int mid = l + (r - l) / 2;
        int left = get(l, mid, id * 2, u, v);
        int right = get(mid + 1, r, id * 2 + 1, u, v);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            arr[i] = sc.nextInt();
        }

        build(1, num, 1);

        int queries = sc.nextInt();
        while (queries-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(get(1, num, 1, l, r));
        }
    }
}
