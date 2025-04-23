package file_submision;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class SearchTree {
    Node root;

    boolean search(Node node, int key) {
        if (node == null)
            return false;
        if (node.data == key)
            return true;
        return search(node.left, key) || search(node.right, key);
    }

    public static void main(String[] args) {
        SearchTree tree = new SearchTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        int key = 4;
        if (tree.search(tree.root, key))
            System.out.println("Value " + key + " found in the tree.");
        else
            System.out.println("Value " + key + " not found in the tree.");
    }
}
