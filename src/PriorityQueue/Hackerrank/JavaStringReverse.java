package PriorityQueue.Hackerrank;

import java.util.Scanner;

public class JavaStringReverse {
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        boolean ans = true;
        for (int i = 0; i < A.length() / 2; i++) {
            if (A.charAt(i) != A.charAt(A.length() - 1 - i)) {
                ans = false;
                break;
            }
        }
        System.out.println(ans ? "Yes" : "No");
    }
}
}
