package Graph.Hackerrank;

import java.util.List;

public class ConnectedCells {
class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    static boolean[][] marked;
    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        marked = new boolean[matrix.size()][matrix.get(0).size()];
        int maxCnt = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                if (matrix.get(i).get(j) == 1) {
                    int cnt = dfs(matrix, i, j);
                    maxCnt = Math.max(maxCnt, cnt);
                }
            }
        }
        return maxCnt;
    }

    public static int dfs(List<List<Integer>> matrix, int i, int j) {
        if (i < 0 || i >= matrix.size() ||
                j < 0 || j >= matrix.get(0).size() ||
                matrix == null || matrix.get(i).get(j) == 0
                || marked[i][j] == true) {
            return 0;
        }
        marked[i][j] = true;
        int cnt = 1;
        for (int i1 = i - 1; i1 <= i + 1; i1++) {
            for (int j1 = j - 1; j1 <= j + 1; j1++) {
                cnt += dfs(matrix, i1, j1);
            }
        }
        return cnt;
    }
}
}
