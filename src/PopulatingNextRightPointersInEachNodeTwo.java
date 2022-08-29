import java.util.ArrayDeque;

import utils.ArrayUtils;
import utils.Node;

public class PopulatingNextRightPointersInEachNodeTwo {
    public static void main(String[] args) {
        //region generate sample data
        Node node07 = new Node(7);
        Node node05 = new Node(5);
        Node node04 = new Node(4);
        Node node03 = new Node(3);
        Node node02 = new Node(2);
        Node node = new Node(1);

        node02.left = node04;
        node02.right = node05;

        node03.right = node07;

        node.left = node02;
        node.right = node03;
        //endregion

        var sampleClass = new PopulatingNextRightPointersInEachNodeTwo();
        var result = sampleClass.connect(node);

        var printList = Node.generateNextNodesValues(result);
        ArrayUtils.printStringList(printList);
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        ArrayDeque<Node> nodes = new ArrayDeque<>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            var size = nodes.size();
            var currentIndex = 0;

            Node tempNode = null;

            while (currentIndex < size) {
                var currentNode = nodes.poll();

                if (tempNode != null) {
                    tempNode.next = currentNode;
                }
                tempNode = currentNode;

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
