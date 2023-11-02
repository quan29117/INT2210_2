package MapVaDuyetCay;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    //Write only 3 methods for 3 exercises
    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node x = queue.poll();
            System.out.print(x.data + " ");
            if (x.left != null)
                queue.add(x.left);
            if (x.right != null)
                queue.add(x.right);
        }
    }

    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
