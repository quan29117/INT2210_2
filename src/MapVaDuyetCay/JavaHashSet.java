package MapVaDuyetCay;

import java.util.*;

public class JavaHashSet {
public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        Set<String> containers = new HashSet<>();

        for (int i = 0; i < num; i++) {
            containers.add(sc.nextLine());
            System.out.println(containers.size());
        }
    }
}
}
