package UnionFind;

import edu.princeton.cs.algs4.UF;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UFClient2 {
    public void run() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("./src/UnionFind/testUFC2.txt"));
        int N = scan.nextInt();
        UF uf = new UF(N);

        int ansPair = 1;

        while (scan.hasNextInt()) {
            int node1 = scan.nextInt();
            int node2 = scan.nextInt();
            if (!uf.connected(node1, node2))
                uf.union(node1, node2);

            if (uf.count() > 1) ansPair++;
        }

        if (uf.count() == 1) System.out.println(ansPair);
        else System.out.println("FAILED");
    }
}
