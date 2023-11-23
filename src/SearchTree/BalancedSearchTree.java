package SearchTree;

public class BalancedSearchTree<Key extends Comparable, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    Node root;

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
        root = put(root, key, val);
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) return new Node(key, val, RED);
        int cmp = key.compareTo(h.key);

        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else if (cmp == 0) h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColor(h);

        return h;
    }

    private Node rotateLeft(Node h) {
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColor(Node h) {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
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