package HashTable.Hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingNumbers {
    //Cach 1


    //Cach 2
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        Collections.sort(arr);
        Collections.sort(brr);
        int arrIndex = 0;
        for (Integer ele : brr) {
            while (arrIndex < arr.size() && arr.get(arrIndex) < ele)
                arrIndex++;
            if (arrIndex < arr.size() && arr.get(arrIndex).equals(ele)) {
                arrIndex++;
                continue;
            }
            ans.add(ele);
            if (ans.size() > 1 && ans.get(ans.size()-2).equals(ele))
                ans.remove(ele);
        }
        return ans;
    }
}
