package UnionFind;

//Union Find don't use size_array
public class UnionFind2 {
    private final int[] id;
    //id[i]: if "i" is a root, id[i] < 0 and -id[i] is the size of component
    //       else id[i] > 0 for the root of i

    private final int num;
    private int connectedComponentNum;

    public UnionFind2(int N) {
        num = N;
        id = new int[N];
        for (int i = 0; i < N; ++i)
            id[i] = -1;

        connectedComponentNum = N;
    }

    public int getCCN() {
        return connectedComponentNum;
    }

    //-> Update 1: Weight to add the smaller to the bigger node-num one
    //-> Update 2: Path compression
    public int getRoot(int i) {
        while (id[i] > 0) {
            id[i] = id[id[i]];
        }
        return id[i];
    }

    public void unionQuick(int num1, int num2) {
        int id1 = getRoot(num1);
        int id2 = getRoot(num2);

        //Set id1 become child of id2

        connectedComponentNum--;
    }
}

