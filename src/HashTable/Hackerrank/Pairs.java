package HashTable.Hackerrank;

import HashTable.SeparateChaining;

import java.util.List;

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        SeparateChaining<Integer, Integer> sc = new SeparateChaining<>();
        int cnt = 0;
        for (Integer ele : arr)
            sc.put(ele, ele);
        for (Integer ele : sc.keys()) {
            if (sc.get(ele - k) != null)
                cnt++;
        }
        return cnt;
    }
}
