package MapVaDuyetCay;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {
public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        Map<String, String> phoneBook = new HashMap<>();
        for (int i = 0; i < num; i++) {
            String name = sc.nextLine();
            String phone = sc.nextLine();
            phoneBook.put(name, phone);
        }

        while (sc.hasNextLine()) {
            String query = sc.nextLine();
            if (phoneBook.containsKey(query)) {
                System.out.println(query + "=" + phoneBook.get(query));
            } else System.out.println("Not found");
        }
    }
}
}
