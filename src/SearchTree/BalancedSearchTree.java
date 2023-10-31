package SearchTree;

public class BalancedSearchTree<Key extends Comparable, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    Node root;

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    public Value get(Key key) {
        Node ele = root;
        while (ele != null) {
            int cmp = key.compareTo(ele.key);
            if (cmp < 0) ele = ele.left;
            else if (cmp > 0) ele = ele.right;
            else return ele.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        root = put(key, val, root);
    }

    private Node put(Key key, Value val, Node x) {
        if (x == null) return new Node(key, val, RED);
        return null;
    }

    private void rotateRight(Node x) {

    }

    private void rotateLeft(Node x) {

    }

    private class Node {
        Key key;
        Value val;
        Node left, right;
        boolean color;

        public Node(Key key, Value val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }
}