package Stack_Queue;

public class MyLinkedListStack<Item> {
    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Item pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        Item item = first.item;
        first = first.next;
        return item;
    }
}
