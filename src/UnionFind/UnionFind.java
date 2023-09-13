package UnionFind;

public class UnionFind {
    private final int[] id;
    private final int num;
    private final int[] sz;
    private int connectedComponentNum;

    public UnionFind(int N) {
        num = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; ++i) {
            id[i] = i;
            sz[i] = 1;
        }

        connectedComponentNum = N;
    }

    public int getCCN() {
        return connectedComponentNum;
    }

    //Quick Find - Too weak for big data
    public int findQuick(int i) {
        return id[i];
    }

    public void union(int num1, int num2) {
        int id1 = findQuick(num1);
        int id2 = findQuick(num2);

        if (id1 != id2) {
            for (int i = 0; i < num; ++i)
                if (id[i] == id1) id[i] = id2;
            connectedComponentNum--;
        }
    }

    //Quick Union
    //-> Update 1: Weight to add the smaller to the bigger node-num one
    //-> Update 2: Path compression
    public int findRootQuickUnion(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }

        return i;
    }

    public void unionQuick(int num1, int num2) {
        int id1 = findRootQuickUnion(num1);
        int id2 = findRootQuickUnion(num2);

        //Set id1 become child of id2
        if (id1 == id2) return;
        if (sz[id1] < sz[id2]) {
            id[id1] = id2;
            sz[id2] += sz[id1];
        } else {
            id[id2] = id1;
            sz[id1] += sz[id2];
        }
        connectedComponentNum--;
    }
}