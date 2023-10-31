package LinkedList;

public class Hackerrank {
//    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
//        // Write your code here
//        int cnt = 0;
//        SinglyLinkedListNode p = llist;
//        while (cnt++ < position-1) p = p.next;
//        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
//        newNode.next = p.next;
//        p.next = newNode;
//        return llist;
//    }
//
//    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
//        // Write your code here
//        if (llist == null) return llist;
//        if (position == 0) return llist.next;
//
//        SinglyLinkedListNode p = llist;
//        while (position-- > 1) {
//            if (p.next == null) break;
//            p = p.next;
//        }
//        if (p.next != null) p.next = p.next.next;
//        return llist;
//    }
//
//    public static void reversePrint(SinglyLinkedListNode llist) {
//        // Write your code here
//        if (llist == null) return;
//        reversePrint(llist.next);
//        System.out.println(llist.data + " ");
//    }
//
//    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
//        // Write your code here
//        if (llist == null) return null;
//        if (llist.next == null) return llist;
//
//        SinglyLinkedListNode prevNode = null;
//        SinglyLinkedListNode currNode = llist;
//
//        while (currNode != null) {
//            SinglyLinkedListNode nextNode = currNode.next;
//            currNode.next = prevNode;
//            prevNode = currNode;
//            currNode = nextNode;
//        }
//
//        return prevNode;
//    }
//
//    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
//        if (head1 == null) return head2;
//        if (head2 == null) return head1;
//
//        SinglyLinkedListNode head3 = null;
//        if (head1.data < head2.data) {
//            head3 = head1;
//            head1 = head1.next;
//        } else {
//            head3 = head2;
//            head2 = head2.next;
//        }
//
//        SinglyLinkedListNode currentNode = head3;
//
//        while (head1 != null && head2 != null) {
//            if (head1.data < head2.data) {
//                currentNode.next = head1;
//                head1 = head1.next;
//            } else {
//                currentNode.next = head2;
//                head2 = head2.next;
//            }
//
//            currentNode = currentNode.next;
//        }
//
//        if (head1 == null) currentNode.next = head2;
//        else currentNode.next = head1;
//
//        return head3;
//    }
//
//    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
//        // Write your code here
//        if (llist == null) return null;
//
//        SinglyLinkedListNode currentNode = llist;
//        while (currentNode.next != null) {
//            if (currentNode.data == currentNode.next.data) {
//                currentNode.next = currentNode.next.next;
//            } else currentNode = currentNode.next;
//        }
//
//        return llist;
//    }
//
//    static boolean hasCycle(SinglyLinkedListNode head) {
//        SinglyLinkedListNode fast = head;
//        while (fast != null && fast.next != null) {
//            if (head.next == fast.next.next) return true;
//            head = head.next;
//            fast = fast.next.next;
//        }
//        return false;
//    }
//
//    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
//        SinglyLinkedListNode temp1=head1;
//        SinglyLinkedListNode temp2=head2;
//        List<SinglyLinkedListNode>list=new ArrayList<SinglyLinkedListNode>();
//        while(temp1!=null){
//            list.add(temp1);
//            temp1=temp1.next;
//        }
//        while(temp2!=null){
//            if(list.contains(temp2)){
//                break;
//            }
//            temp2=temp2.next;
//        }
//        return temp2.data;
//
//    }
//
//    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
//        // Write your code here
//        DoublyLinkedListNode node = new DoublyLinkedListNode(data);
//        if (llist == null) {
//            return node;
//        } else if (data <= llist.data) {
//            node.next = llist;
//            llist.prev = node;
//            return node;
//        } else {
//            DoublyLinkedListNode ptr = sortedInsert(llist.next, data);
//            llist.next = ptr;
//            ptr.prev = llist;
//            return llist;
//        }
//    }
//
//    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
//        // Write your code here
//        if (llist == null) return null;
//
//        DoublyLinkedListNode prevNode = null;
//        DoublyLinkedListNode currNode = llist;
//
//        while (currNode != null) {
//            DoublyLinkedListNode nextNode = currNode.next;
//            currNode.next = prevNode;
//            currNode.prev = nextNode;
//            prevNode = currNode;
//            currNode = currNode.prev;
//        }
//
//        return prevNode;
//    }
}
