//package SearchTree.Hackerrank;
//
//public class Solution {
//    //https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
//    public static int height(Node root) {
//        // Write your code here.
//        if (root == null) return -1;
//        return 1 + Math.max(height(root.left), height(root.right));
//    }
//
//    //https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
//    public static Node insert(Node root, int data) {
//        if (root == null)
//            return new Node(data);
//
//        if (data > root.data) {
//            root.right = insert(root.right, data);
//        } else {
//            root.left = insert(root.left, data);
//        }
//        return root;
//    }
//
//    //https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem
//    public static Node lca(Node root, int v1, int v2) {
//        // Write your code here.
//        if (root == null) return null;
//
//        if (root.data > v1 && root.data > v2)
//            return lca(root.left, v1, v2);
//        if (root.data < v1 && root.data < v2)
//            return lca(root.right, v1, v2);
//        return root;
//    }
//
//    //https://www.hackerrank.com/challenges/is-binary-search-tree/problem
//    boolean checkBST(Node root) {
//        return checkBST(root, null, null);
//    }
//
//    boolean checkBST(Node root, Integer min, Integer max) {
//        if (root == null)
//            return true;
//        if ((min != null && root.data <= min) || (max != null && root.data >= max))
//            return false;
//        return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
//    }
//
//    //https://www.hackerrank.com/challenges/self-balancing-tree/problem
//    static Node rotateWithRight(Node x) {
//        Node h = x.right;
//        x.right = h.left;
//        h.left = x;
//        updateHeight(x);
//        updateHeight(h);
//        return h;
//    }
//
//    static Node rotateWithLeft(Node x) {
//        Node h = x.left;
//        x.left = h.right;
//        h.right = x;
//        updateHeight(x);
//        updateHeight(h);
//        return h;
//    }
//
//    static int getHeight(Node x) {
//        if (x == null) return -1;
//        return x.ht;
//    }
//
//    static void updateHeight(Node x) {
//        x.ht = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
//    }
//
//    static Node insert(Node root, int val) {
//        if (root == null) {
//            root = new Node();
//            root.val = val;
//            root.ht = 0;
//            root.left = null;
//            root.right = null;
//        }
//        if (val < root.val) {
//            root.left = insert(root.left, val);
//            if (getHeight(root.left) - getHeight(root.right) == 2) {
//                if (val > root.left.val) {
//                    root.left = rotateWithRight(root.left);
//                }
//                root = rotateWithLeft(root);
//            }
//        } else if (val > root.val) {
//            root.right = insert(root.right, val);
//            if (getHeight(root.right) - getHeight(root.left) == 2) {
//                if (val > root.left.val) {
//                    root.right = rotateWithLeft(root.right);
//                }
//                root = rotateWithRight(root);
//            }
//        }
//        return root;
//    }
//}
//
//class Node {
//    Node left;
//    Node right;
//    int data;
//
//    Node(int data) {
//        this.data = data;
//        left = null;
//        right = null;
//    }
//}
