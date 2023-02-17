import utils.ListNode;

public class ReverseLinkedList {
	public static void main(String[] args) {
		var sampleClass = new ReverseLinkedList();

		//region sample01
		var sample01 = new ListNode(1);
		var sample02 = new ListNode(2);
		var sample03 = new ListNode(3);
		var sample04 = new ListNode(4);
		var sample05 = new ListNode(5);

		sample01.next = sample02;
		sample02.next = sample03;
		sample03.next = sample04;
		sample04.next = sample05;
		//endregion

		var nodes = sampleClass.reverseList03(sample01);
		ListNode.printListNode(nodes);

	}

	// Third practice
	public ListNode reverseList03(ListNode head) {
		// base case
		if (head == null || head.next == null) {
			// The last node should return itself, so return head.
			return head;
		}

		ListNode reversedList = reverseList03(head.next); // Will bring the last node back

		// Swapping
		head.next.next = head; // Point the next node's node to head itself

		// clean up the next node.
		// If we didn't go through all nodes in path, this value would be fix. Otherwise,
		// the first node of our answer should point to null.
		head.next = null;
		
		return reversedList;
	}

	// Approach01: Iteratively
	public ListNode reverseList(ListNode head) {
        // Base case
		if (head == null) {
			return null;
		}

		ListNode originalHead = head;
		ListNode currentNode = head.next;

		while (currentNode != null) {
			// 1. ) Swap the list position
			// Push the original head to the other side, keep pushing right ->
			ListNode nextNode = currentNode.next;
			originalHead.next = nextNode;
			currentNode.next = head;

			// 2. ) Update the head
			head = currentNode;

			// 3. ) Update the loop object
			currentNode = nextNode;
		}

		return head;
    }

	// Approach02: Recursively
	public ListNode reverseList02(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		var reversedListHead = reverseList02(head.next);
		// Reverse direction to current node
		// e.g. reverse: 1 -> 2, we want to reverse the next node of 2
		// 1's next is 2, we make 2 back to 1, so it's 2's next object
		// that's why it is node.next.next
		head.next.next = head;
		head.next = null;
		return reversedListHead;
	}
}
