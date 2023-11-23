package SearchTree;

public class TestBST {
    public static void main(String[] args) {
        String s = "PSEUDOMYTHICAL";
        BalancedSearchTree<Character, Integer> test = new BalancedSearchTree<>();
        for (int i = 0; i < s.length(); i++) {
            test.put(s.charAt(i), i);
        }
    }
}
