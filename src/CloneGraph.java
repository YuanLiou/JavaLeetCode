import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import utils.Node;

public class CloneGraph {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.addAll(Arrays.asList(node2, node4));
        node2.neighbors.addAll(Arrays.asList(node3, node1));
        node3.neighbors.addAll(Arrays.asList(node2, node4));
        node4.neighbors.addAll(Arrays.asList(node1, node3));

        Node resultNode = cloneGraph(node1);
        System.out.println("Finished.");
    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> clonedNodes = new HashMap<>();
        return clone(node, clonedNodes);
    }

    private static Node clone(Node node, Map<Node, Node> clonedNodes) {
        if (clonedNodes.containsKey(node)) {
            // Already copied
            return clonedNodes.get(node);
        }

        // Doing deep copy
        Node copiedNode = new Node(node.val);
        clonedNodes.putIfAbsent(node, copiedNode);

        // Traverse its neighbors and put into the copied nodes
        for (Node neighbor : node.neighbors) {
            // Doing DFS
            copiedNode.neighbors.add(clone(neighbor, clonedNodes));
        }
        return copiedNode;
    }
}
