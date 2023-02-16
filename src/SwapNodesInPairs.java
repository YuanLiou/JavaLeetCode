import utils.ListNode;

public class SwapNodesInPairs {

	public static void main(String[] args) {
		var sampleClass = new SwapNodesInPairs();

		// expected: 2, 1, 4, 3
		var example01 = new int[]{1, 2, 3, 4};
		var nodes = new ListNode(example01);
		ListNode.printListNode(nodes);
		System.out.println("");
		var result01 = sampleClass.swapPairs(nodes);
		ListNode.printListNode(result01);
	}

	public ListNode swapPairs(ListNode head) {
		// base case
		if (head == null) {
			return null;
		}

		var result = swapNodes(head);
		if (result.next != null && result.next.next != null) {
			result.next.next = swapPairs(result.next.next);
		}
		return result;
	}

	private ListNode swapNodes(ListNode head) {
		var temp = head.next;
		if (temp == null) {
			return head;
		}

		head.next = temp.next;
		temp.next = head;
		return temp;
	}
}
