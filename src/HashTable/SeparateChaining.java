package HashTable;

import edu.princeton.cs.algs4.Queue;

public class SeparateChaining<Key, Value> {
    private int N = 0;      //Number of elements
    private int M;          //Number of chains
    private Node[] st;

    public static class Node {
        public Object key;
        public Object val;
        public Node next;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SeparateChaining() {
        this(4);
    }

    public SeparateChaining(int M) {
        this.M = M;
        this.st = new Node[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        if (key == null) return null;
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key))
                return (Value) x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null || val == null) return;
        if (N >= 8 * M) resize(2 * M);

        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        N++;
        st[i] = new Node(key, val, st[i]);
    }

    public void delete(Key key) {
        if (key == null) return;

        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                st[i] = x.next;
                N--;
                return;
            }
        }
        if (N <= 2 * M) resize(M / 2);
    }

    private void resize(int newM) {
        SeparateChaining<Key, Value> tmp = new SeparateChaining<>(newM);
        for (int i = 0; i < M; i++) {
            for (Node x = st[i]; x != null; x = x.next) {
                tmp.put((Key) x.key, (Value) x.val);
            }
        }
        this.N = tmp.N;
        this.M = tmp.M;
        this.st = tmp.st;
    }

    public void print() {
        for (int i = 0; i < M; i++) {
            System.out.print(i + ": ");
            for (Node x = st[i]; x != null; x = x.next) {
                System.out.print(x.key + " ");
            }
            System.out.println();
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            for (Node x = st[i]; x != null; x = x.next)
                queue.enqueue((Key) x.key);
        }
        return queue;
    }
}
