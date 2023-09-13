package UnionFind;

public class UnionFind {
    private final int[] root;
    private final int num;
    private final int[] sz;
    private int connectedComponentNum;

    public UnionFind(int N) {
        num = N;
        root = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; ++i) {
            root[i] = i;
            sz[i] = 1;
        }

        connectedComponentNum = N;
    }

    public int getCCN() {
        return connectedComponentNum;
    }

    //Quick Find - Too weak for big data
    public int findQuick(int i) {
        return root[i];
    }

    public void union(int num1, int num2) {
        int root1 = findQuick(num1);
        int root2 = findQuick(num2);

        if (root1 != root2) {
            for (int i = 0; i < num; ++i)
                if (root[i] == root1) root[i] = root2;
            connectedComponentNum--;
        }
    }

    //Quick Union
    //-> Update 1: Weight to add the smaller to the bigger node-num one
    //-> Update 2: Path compression
    public int findRootQuickUnion(int i) {
        while (i != root[i]) {
            root[i] = root[root[i]];
            i = root[i];
        }

        return i;
    }

    public void unionQuick(int num1, int num2) {
        int root1 = findRootQuickUnion(num1);
        int root2 = findRootQuickUnion(num2);

        //Set root1 become child of root2

        if (root1 == root2) return;
        if (sz[root1] < sz[root2]) {
            root[root1] = root2;
            sz[root2] += sz[root1];
        } else {
            root[root2] = root1;
            sz[root1] += sz[root2];
        }
        connectedComponentNum--;
    }
}