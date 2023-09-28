package LinkedList;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;

public class ListTest {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }


        public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException, IOException {
            while (node != null) {
                bufferedWriter.write(String.valueOf(node.data));

                node = node.next;

                if (node != null) {
                    bufferedWriter.write(sep);
                }
            }
        }
    }

    static boolean hasCycle(SinglyLinkedListNode head) {
        HashSet<SinglyLinkedListNode> newSet = new HashSet<SinglyLinkedListNode>();
        SinglyLinkedListNode p = head;
        while (p != null) {
            if (newSet.contains(p.next)) return true;
            newSet.add(p);
            p = p.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedLists myList = new SinglyLinkedLists();
        myList.addFirst("One");
        myList.addFirst("Two");
        myList.addFirst("Zero");

        myList.append("Three");

        System.out.print(myList);
    }
}
