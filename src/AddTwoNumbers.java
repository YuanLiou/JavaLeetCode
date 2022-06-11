import utils.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode nodeC = new ListNode(3);
        ListNode nodeB = new ListNode(4, nodeC);
        ListNode nodeA = new ListNode(2, nodeB);

        ListNode nodeZ = new ListNode(4);
        ListNode nodeY = new ListNode(6, nodeZ);
        ListNode nodeX = new ListNode(5, nodeY);

        ListNode nodeA2 = new ListNode(0);
        ListNode nodeB2 = new ListNode(0);

        ListNode nodeG3 = new ListNode(9);
        ListNode nodeF3 = new ListNode(9, nodeG3);
        ListNode nodeE3 = new ListNode(9, nodeF3);
        ListNode nodeD3 = new ListNode(9, nodeE3);
        ListNode nodeC3 = new ListNode(9, nodeD3);
        ListNode nodeB3 = new ListNode(9, nodeC3);
        ListNode nodeA3 = new ListNode(9, nodeB3);

        ListNode nodeD4 = new ListNode(9);
        ListNode nodeC4 = new ListNode(9, nodeD4);
        ListNode nodeB4 = new ListNode(9, nodeC4);
        ListNode nodeA4 = new ListNode(9, nodeB4);


        addTwoNumbers(nodeA3, nodeA4);
    }

    private static void addTwoNumbers(ListNode l1, ListNode l2) {
        // Pick numbers from each ListNodes
        // Calculate the carry: n/10
        // (Recursive looping): base case is l1 is null and l2 is null and carry is 0
        //   loop: send listNode.next to next run.
        // Return a new ListNode
        ListNode node = addTwoNumbers(l1, l2, 0);
        ListNode.printListNode(node);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        // base case as stop condition
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        // add the value from treeNodes
        int l1Value = 0;
        if (l1 != null) {
            l1Value = l1.val;
        }

        int l2Value = 0;
        if (l2 != null) {
            l2Value = l2.val;
        }

        int nodeValue = l1Value + l2Value + carry;

        // Recursive: Pick the next one
        ListNode l1Next = null;
        if (l1 != null) {
            l1Next = l1.next;
        }

        ListNode l2Next = null;
        if (l2 != null) {
            l2Next = l2.next;
        }

        return new ListNode(nodeValue % 10, addTwoNumbers(l1Next, l2Next, nodeValue / 10));
    }
}
