import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.ArrayUtils;
import utils.Node;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        //region generate sample data
        Node node07 = new Node(7);
        Node node06 = new Node(6);
        Node node05 = new Node(5);
        Node node04 = new Node(4);
        Node node03 = new Node(3);
        Node node02 = new Node(2);
        Node node = new Node(1);

        node02.left = node04;
        node02.right = node05;

        node03.left = node06;
        node03.right = node07;

        node.left = node02;
        node.right = node03;
        //endregion

        var sampleClass = new PopulatingNextRightPointersInEachNode();
        Node result = sampleClass.connect(node);

        var printResult = sampleClass.generateNextNodesValues(result);
        ArrayUtils.printStringList(printResult);
    }

    private List<String> generateNextNodesValues(Node root) {
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
                String currentValue = String.valueOf(currentNode.val);
                if (!printResult.contains(currentValue)) {
                    printResult.add(currentValue);
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

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // Doing BFS
        ArrayDeque<Node> nodes = new ArrayDeque<>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            var size = nodes.size();
            var currentIndex = 0;
            Node tempCurrentNode = null;
            while (currentIndex < size) {
                var currentNode = nodes.poll();
                if (currentNode != null) {
                    if (tempCurrentNode != null) {
                        tempCurrentNode.next = currentNode;
                    }

                    tempCurrentNode = currentNode;
                }

                if (currentNode != null && currentNode.left != null) {
                    nodes.offer(currentNode.left);
                }

                if (currentNode != null && currentNode.right != null) {
                    nodes.offer(currentNode.right);
                }

                currentIndex++;
            }
        }

        return root;
    }
}
