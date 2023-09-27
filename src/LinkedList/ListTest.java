package LinkedList;

public class ListTest {
    public static void main(String[] args) {
        SinglyLinkedLists myList = new SinglyLinkedLists();
        myList.addFirst("One");
        myList.addFirst("Two");
        myList.addFirst("Zero");

        myList.append("Three");

        System.out.print(myList);
    }


}
