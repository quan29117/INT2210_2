package Graph.UndirectedGraphs;

import java.util.Arrays;

public class ConnectedComponents {
    private int[] id;
    private int cnt = 0;

    public ConnectedComponents(Graph G) {
        id = new int[G.getV()];
        Arrays.fill(id, -1);

        for (int v = 0; v < G.getV(); v++) {
            if (id[v] < 0) {
                dfs(G,v);
                cnt++;
            }
        }
    }

    public int count() {
        return cnt;
    }

    public int id(int v) {
        return id[v];
    }

    private void dfs(Graph G, int v) {
        id[v] = cnt;
        for (int w : G.adj(v)) {
            if (id[v] < 0) {
                dfs(G, w);
            }
        }
    }
}
