package utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
        this.val = 0;
        this.next = null;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printListNode(ListNode node) {
        ListNode currentNode = node;
        System.out.print("Nodes: ");
        while (currentNode != null) {
            System.out.print(currentNode.val + " -> ");
            currentNode = currentNode.next;
        }
        System.out.print("null");
    }
}