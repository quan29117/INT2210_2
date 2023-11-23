package Graph.UndirectedGraphs;

import java.util.Stack;

public class DFS implements Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DFS(Graph G, int s) {
        marked = new boolean[s];
        edgeTo = new int[s];
        this.s = s;
        dfs(G,s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G,w);
                edgeTo[w] = v;
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
