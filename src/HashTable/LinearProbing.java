package HashTable;

import java.util.List;

public class LinearProbing<Key, Value> {
    private int N = 0;      //Number of elements
    private int M;          //Number of chains
    private Key[] keys;
    private Value[] values;

    public LinearProbing() {
        this(4);
    }

    public LinearProbing(int M) {
        this.M = M;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        if (key == null) return null;
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null || val == null) return;
        if (N >= M / 2) resize(2 * M);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i]))
                break;
        }
        keys[i] = key;
        values[i] = val;
        N++;
    }

    public void delete(Key key) {
        if (key == null) return;

        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }

        keys[i] = null;
        values[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRehash = keys[i];
            Value valToRehash = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % M;
        }

        N--;
        if (N > 0 && N <= M / 8) resize(M / 2);
    }

    private void resize(int newM) {
        LinearProbing<Key, Value> tmp = new LinearProbing<>(newM);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                tmp.put(keys[i], values[i]);
            }
        }
        this.keys = tmp.keys;
        this.values = tmp.values;
        this.M = tmp.M;
    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int cnt = 0;
        for (int i = 0; i < q.size(); i++) {
            if (q.get(i) - i <= 0) continue;
            if (q.get(i) - i > 2) {
                System.out.println("Too chaotic");
                return;
            }
            else cnt += q.get(i) - i;
        }
        System.out.println(cnt);
    }
}
