package Stack_Queue;

public class MyQueue<Item> {
    private Item[] arr = (Item[]) new Object[1];
    private int head = 0, n = 0;

    public MyQueue() {}

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Cannot add null item");
        if (n == arr.length) resize(2 * arr.length);
        arr[rankToIndex(n)] = item;
        n++;
    }

    private int rankToIndex(int rank) {
        return (head + rank) % arr.length;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++)
            copy[i] = arr[rankToIndex(i)];
        arr = copy;
        head = 0;
    }

    public Item dequeue() {
        if (n == 0) throw new IllegalArgumentException("Queue underflow");
        Item item = arr[n];
        arr[n] = null;
        n--;
        if (n > 0 && n == arr.length / 4)
            resize(arr.length / 2);
        return item;
    }

    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("Hello");
        queue.enqueue("Cat");
        queue.enqueue("Dog");
        queue.enqueue("Bird");

    }
}
