package PriorityQueue;

class PQ2ary<Key extends Comparable<Key>> implements PQ<Key> {
    private Key[] pq;
    private int currSize;

    public PQ2ary(int size){
        pq = (Key[]) new Comparable[size + 1];
        currSize = 0;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    private void resize(int size) {
        Key[] temp = (Key[]) new Comparable[size];
        for (int i = 1; i <= currSize; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(Key key) {
        if (currSize == pq.length - 1) resize(2 * pq.length);

        pq[++currSize] = key;
        swim(currSize);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, currSize--);
        pq[currSize + 1] = null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= currSize) {
            int j = 2*k;
            if (j < currSize && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public Key peek() {
        return pq[1];
    }

    public int size() {
        return currSize;
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
}
