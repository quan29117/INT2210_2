package Graph.UndirectedGraphs;

import edu.princeton.cs.algs4.Queue;

import java.util.Stack;

public class BFS implements Paths{
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public BFS(Graph G, int s) {
        this.source = s;
        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        bfs(G, source);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(s);
        marked[s] = true;
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    q.enqueue(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<>();
        for (int i = v; i != source; i = edgeTo[i]) {
            path.push(i);
        }
        path.push(source);
        return path;
    }
}
