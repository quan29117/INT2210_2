import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Result {
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        Integer pivot = arr.get(0);
        List<Integer> left = new LinkedList<>(), right = new LinkedList<>();
        for (int i = 1; i < arr.size(); ++i) {
            if (arr.get(i).compareTo(pivot) > 0) {
                right.add(arr.get(i));
            } else left.add(arr.get(i));
        }
        List<Integer> ans = new LinkedList<>();

        ans.addAll(left);
        ans.add(pivot);
        ans.addAll(right);
        return ans;
    }
}
