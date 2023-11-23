package Graph.UndirectedGraphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaiTapBonus {
    public static int[] distance;
    public static boolean[] marked;

    public static void bfs(Graph graph, int source) {
        Arrays.fill(marked, false);

        Queue<Integer> q = new LinkedList<>();
        boolean stop = false;
        q.add(source);
        marked[source] = true;
        int dist = 0;
        distance[source] = dist++;

        while (!q.isEmpty() && !stop) {
            int v = q.poll();
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    q.add(w);
                    marked[w] = true;
                    if (distance[w] < 0 || distance[w] > dist)
                        distance[w] = dist;
                    else if (distance[w] < dist) {
                        stop = true;
                        break;
                    }
                }
            }
            dist++;
        }
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        Graph graph = new Graph(n);
//        distance = new int[n];
//        Arrays.fill(distance, -1);
//        marked = new boolean[n];
//        for (int i = 0; i < m; i++) {
//            graph.addEdge(scanner.nextInt(),scanner.nextInt());
//        }
//        int queries = scanner.nextInt();
//        while (queries-- > 0) {
//            bfs(graph, scanner.nextInt());
//        }

        Graph graph = new Graph(6);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(4,5);

        distance = new int[6];
        Arrays.fill(distance, -1);
        marked = new boolean[6];
        bfs(graph, 1);
        bfs(graph, 3);

        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
    }
}
