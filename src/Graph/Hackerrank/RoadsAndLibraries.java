package Graph.Hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class RoadsAndLibraries {
public class Solution {
    static int N, M, costLib, costRoad, libCnt, roadCnt;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] marked;

    public static long roadsAndLibraries() {
        if (costLib <= costRoad) {
            return (long) costLib * N;
        }

        for (int v = 1; v <= N; v++) {
            if (!marked[v]) {
                dfs(v);
                libCnt++;
            }
        }
        return (long) costLib * libCnt + (long) costRoad * roadCnt;
    }

    public static void dfs(int v) {
        marked[v] = true;
        for (int w : graph.get(v)) {
            if (!marked[w]) {
                dfs(w);
                roadCnt++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            costLib = scanner.nextInt();
            costRoad = scanner.nextInt();

            graph = new ArrayList<>();
            for (int i = 0; i <= N; ++i) {
                graph.add(new ArrayList<>());
            }
            marked = new boolean[N + 1];
            libCnt = roadCnt = 0;

            for (int i = 0; i < M; ++i) {
                int n1, n2;
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }
            System.out.println(roadsAndLibraries());
        }
    }
}
}
