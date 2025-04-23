package file_submision;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class TreeOperations {
    Node root;

    int sumOfNodes(Node node) {
        if (node == null)
            return 0;
        return node.data + sumOfNodes(node.left) + sumOfNodes(node.right);
    }

    void printNodesAtLevel(Node node, int level) {
        if (node == null)
            return;
        if (level == 1)
            System.out.print(node.data + " ");
        else {
            printNodesAtLevel(node.left, level - 1);
            printNodesAtLevel(node.right, level - 1);
        }
    }

    Node insertNode(Node node, int value) {
        if (node == null)
            return new Node(value);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left == null) {
                temp.left = new Node(value);
                break;
            } else {
                queue.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = new Node(value);
                break;
            } else {
                queue.add(temp.right);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        TreeOperations tree = new TreeOperations();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Sum of all nodes: " + tree.sumOfNodes(tree.root));
        System.out.print("Nodes at level 3: ");
        tree.printNodesAtLevel(tree.root, 3);

        tree.insertNode(tree.root, 6);
        System.out.println("\nNode 6 inserted.");
        System.out.print("Nodes at level 3 after insertion: ");
        tree.printNodesAtLevel(tree.root, 3);
    }
}

