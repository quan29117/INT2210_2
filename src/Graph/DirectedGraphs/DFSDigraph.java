package Graph.DirectedGraphs;

import java.util.Stack;

public class DFSDigraph {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DFSDigraph(Digraph G, int s) {
        source = s;
        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        dfs(G,s);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[v]) {
                dfs(G, w);
                edgeTo[w] = v;
            }
        }
    }

    public Iterable<Integer> pathTo(int v) {
        if (!marked[v]) return null;
        Stack<Integer> stack = new Stack<>();
        for (int i = v; i != source; i = edgeTo[i]) {
            stack.push(i);
        }
        stack.push(source);
        return stack;
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }
}
