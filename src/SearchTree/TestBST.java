package SearchTree;

public class TestBST {
    public static void main(String[] args) {
        String s = "PSEUDOMYTHICAL";
        BinarySearchTree<Character, Integer> test = new BinarySearchTree<>();
        for (int i = 0; i < s.length(); i++) {
            test.put(s.charAt(i), i);
        }
        test.print();
    }
}
