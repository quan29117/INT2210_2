package Stack_Queue;

import java.util.Scanner;

public class BaiTapThem {
    /*
    n phần tử, với vị trí i tìm vị trí lớn hơn nó đầu tiên về trước
    Example:
    Input: 5
           10 1 3 20 7
    Output: 0 1 1  0 4
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = scanner.nextInt();
        int indexMax = 1;
        int[] ans = new int[n];
        ans[0] = 0;
        for (int i = 2; i <= n; i++) {
            int element = scanner.nextInt();
            if (element > max) {
                max = element;
                indexMax = i;
                ans[i-1] = 0;
            } else {
                ans[i-1] = indexMax;
            }
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
