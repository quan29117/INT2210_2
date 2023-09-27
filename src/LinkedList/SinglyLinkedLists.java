package LinkedList;

public class SinglyLinkedLists {
    public class NodeLinkedList {
        String data;
        NodeLinkedList next;

        public NodeLinkedList(String data, NodeLinkedList next) {
            this.data = data;
            this.next = next;
        }
    }

    NodeLinkedList headNode;

    public SinglyLinkedLists() {
        headNode = null;
    }

    public void addFirst(String data) {
        headNode = new NodeLinkedList(data, headNode);
    }

    public void oldAppend(String data) {
        if (headNode == null) {
            this.addFirst(data);
            return;
        }

        NodeLinkedList p = headNode;
        while (p.next != null) p = p.next;
        p.next = new NodeLinkedList(data, null);
    }

    public void append(String data) {
        headNode = append(data, headNode);
    }

    private NodeLinkedList append(String data, NodeLinkedList node) {
        if (node == null) return new NodeLinkedList(data, null);
        node.next = append(data, node.next);
        return node;
    }

    public String toString() {
        return "[" + toString(headNode) + "]";
    }

    public String toString(NodeLinkedList node) {
        if (node == null) return "";
        return node.data + " " + toString(node.next);
    }

    public void removeLast() {
        if (headNode != null)
            headNode = removeLast(headNode);
    }

    public NodeLinkedList removeLast(NodeLinkedList node) {
        if (node.next == null) return null;
        node.next = removeLast(node.next);
        return node;
    }

    //Remove the node appears first with the given data by recursion
    public void removeFirst(String data) {
        if (headNode != null)
            headNode = removeFirst(headNode, data);
    }

    public NodeLinkedList removeFirst(NodeLinkedList node, String data) {
        if (node == null) return null;
        if (node.data.equals(data)) return node.next;
        node.next = removeFirst(node.next, data);
        return node;
    }

    public void removeAllData(String data) {
        headNode = removeAllData(headNode, data);
    }

    public NodeLinkedList removeAllData(NodeLinkedList node, String data) {
        if (node == null) return null;
        if (node.data.equals(data)) return removeAllData(node.next, data);
        node.next = removeAllData(node.next, data);
        return node;
    }

    public static void main(String[] args) {
        SinglyLinkedLists myList = new SinglyLinkedLists();
        myList.addFirst("One");
        myList.addFirst("Two");
        myList.addFirst("Zero");

        myList.append("Three");
        myList.append("One");
        myList.addFirst("One");

        myList.removeAllData("One");

        System.out.print(myList);
    }
}
