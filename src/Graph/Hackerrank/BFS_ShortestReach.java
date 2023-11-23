package Graph.Hackerrank;

import java.util.*;

public class BFS_ShortestReach {
public class Solution {
    static List<Integer> findShortestReach(ArrayList<ArrayList<Integer>> graph, int start) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            ans.add(-1);
        }
        ans.set(start, 0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (Integer w : graph.get(v)) {
                if (ans.get(w) == -1) {
                    queue.add(w);
                    ans.set(w, ans.get(v) + 6);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; ++q) {
            int N, M, start;
            N = scanner.nextInt();
            M = scanner.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= N; ++i) {
                graph.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < M; ++i) {
                int n1, n2;
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }
            start = scanner.nextInt();
            /*
            for (int i = 0; i < N; ++i) {
                Collections.sort(graph.get(i));
            }
            for (int i = 1; i <= N; ++i) {
                System.out.println("Node: " + i);
                System.out.println(graph.get(i).toString());
            }
            System.out.println("Start: " + start);
            */
            List<Integer> costs = findShortestReach(graph, start);
            for (int i = 1; i < costs.size(); ++i) {
                if (i == start) continue;
                System.out.print(costs.get(i) + " ");
            }
            System.out.println();
        }
    }
}
}
