package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node {
    public int val;

    public Node left;
    public Node right;
    public Node next;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public static List<String> generateNextNodesValues(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<String> printResult = new ArrayList<>();
        Queue<Node> result = new LinkedList<>();
        result.offer(root);

        while (!result.isEmpty()) {
            var size = result.size();
            var currentIndex = 0;
            while (currentIndex < size) {
                var currentNode = result.poll();
                if (currentNode != null) {
                    String currentValue = String.valueOf(currentNode.val);

                    if (!printResult.contains(currentValue)) {
                        printResult.add(currentValue);
                    }
                }

                if (currentNode == null || currentNode.next == null) {
                    printResult.add("#");
                } else {
                    printResult.add(String.valueOf(currentNode.next.val));
                }

                if (currentNode != null && currentNode.left != null) {
                    result.offer(currentNode.left);
                }

                if (currentNode != null && currentNode.right != null) {
                    result.offer(currentNode.right);
                }

                currentIndex++;
            }
        }

        return printResult;
    }
}
