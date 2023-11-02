package Vebo;

import java.util.Scanner;

public class CamThuat {
    public static int n, m;
    public static int[] a = new int[100005];

    public static int[] t = new int[100005 * 4];

    public static void build(int l, int r, int id) {
        if (l == r) {
            t[id] = a[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(l, mid, 2 * id);
        build(mid + 1, r, 2 * id + 1);
        t[id] = Math.max(t[2 * id], t[2 * id + 1]);
    }

    private static int get(int l, int r, int id, int u, int v) {
        if (v < l || r < u) return -100000000;
        if (u <= l && r <= v) return t[id];
        int mid = l + (r - l) / 2;
        int left = get(l, mid, 2 * id, u, v);
        int right = get(mid + 1, r, 2 * id + 1, u, v);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        build(1, n, 1);

        for (int i = 1; i <= m; i++) {
            int l, r;
            l = sc.nextInt();
            r = sc.nextInt();
            System.out.println(get(1, n, 1, l, r));
        }
    }
}
