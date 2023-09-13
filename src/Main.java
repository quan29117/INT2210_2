// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import Sum_Week2.ThreeSum;
import UnionFind.UnionFind;
import UnionFind.UFClient2;
import Sum_Week2.TwoSum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner myObj = new Scanner(new File("./algs4-data/largeUF.txt"));
//        int nodeNum = myObj.nextInt();
//
//        UnionFind UF = new UnionFind(nodeNum);
//
//        while (myObj.hasNextInt()) {
//            int node1 = myObj.nextInt();
//            int node2 = myObj.nextInt();
//            UF.unionQuick(node1, node2);
//        }
//
//        System.out.println(UF.getCCN());

//        UFClient2 uf2 = new UFClient2();
//        uf2.run();

//        TwoSum TS = new TwoSum();
//        TS.run();
        ThreeSum TrS = new ThreeSum();
        TrS.run();

    }
}