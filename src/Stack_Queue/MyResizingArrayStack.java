package Stack_Queue;

public class MyResizingArrayStack<Item> {
    private Item[] arr = (Item[]) new Object[1];
    private int len = 0;

    public void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < len; i++)
            copy[i] = arr[i];
        arr = copy;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public void push(Item item) {
        if (len == arr.length)
            resize(2 * len);
        arr[len++] = item;
    }

    public Item pop() {
        if (len <= 0) {
            System.out.println("Stack is empty");
            return null;
        }

        Item item = arr[--len];
        arr[len] = null;
        if (len > 0 && len == arr.length / 4)
            resize(arr.length / 2);
        return item;
    }
}
