package SearchTree;

import edu.princeton.cs.algs4.Queue;

public class BinarySearchTree<Key extends Comparable, Value> {
    Node root;

    public int sizeTree() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);

        if      (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else              return size(x.left);
    }

    public void put(Key key, Value val) {
        root = put(key, val, root);
    }

    private Node put(Key key, Value val, Node x) {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);

        if      (cmp > 0) x.right = put(key, val, x.right);
        else if (cmp < 0) x.left = put(key, val, x.left);
        else              x.val = val;

        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key key) {
        Node ele = root;
        while (ele != null) {
            int cmp = key.compareTo(ele.key);
            if (cmp < 0) {
                ele = ele.left;
            } else if (cmp > 0) {
                ele = ele.right;
            } else return ele.val;
        }
        return null;
    }

    public void print() {
        print(root);
        System.out.print("\n");
    }

    private void print(Node x) {
        if (x == null) return;
        System.out.print("(");
        print(x.left);
        System.out.print(" " + x.key + " ");
        print(x.right);
        System.out.print(")");
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        inOrder(root, queue);
        return queue;
    }

    private void inOrder(Node x, Queue<Key> queue) {
        if (x == null) return;
        inOrder(x.left, queue);
        queue.enqueue(x.key);
        inOrder(x.right, queue);
    }

    public Iterable<Key> keysDesc() {
        Queue<Key> queue = new Queue<>();
        inReverse(root, queue);
        return queue;
    }

    private void inReverse(Node x, Queue<Key> queue) {
        if (x == null) return;
        inReverse(x.right, queue);
        queue.enqueue(x.key);
        inReverse(x.left, queue);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node x) {
        if (x == null) return;
        System.out.println(x.key);
        preOrder(x.left);
        preOrder(x.right);
    }

    public Key min() {
        return min(root);
    }

    private Key min(Node x) {
        if (x == null) return null;
        if (x.left != null) return min(x.left);
        return x.key;
    }

    public Key floor(Key key) {
        return floor(key, root);
    }

    private Key floor(Key key, Node x) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);

        if (cmp == 0 ) return key;
        if (cmp < 0) return floor(key, x.left);
        Key result = floor(key, x.right);
        if (result != null) return result;
        return x.key;
    }

    public Key ceil(Key key) {
        return ceil(key, root);
    }

    private Key ceil(Key key, Node x) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);

        if (cmp == 0) return key;
        if (cmp > 0) return floor(key, x.right);
        Key result = floor(key, x.left);
        if (result != null) return result;
        return x.key;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x == null) return null;
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void delete(Key key) {
        root = delete(key, root);
    }

    private Node delete(Key key, Node x) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);

        if (cmp < 0) x.left = delete(key, x.left);
        else if (cmp > 0) x.right = delete(key, x.right);
        else {
            //delete x
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;

            Key minRightKey = min(x.right);
            Value minRightVal = get(minRightKey);
            deleteMin(x.right);
            x.key = minRightKey;
            x.val = minRightVal;
        }
        return x;
    }

    private class Node {
        Key key;
        Value val;
        Node left;
        Node right;
        int count;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
}
