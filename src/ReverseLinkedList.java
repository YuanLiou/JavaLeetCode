import java.util.List;

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

		var nodes = sampleClass.reverseList02(sample01);
		ListNode.printListNode(nodes);

	}

	// Approach01: Iteratively
	public ListNode reverseList(ListNode head) {
        // Base case
		if (head == null) {
			return null;
		}

		ListNode originalHead = head;
		ListNode originalNextNode = head.next;

		while (originalNextNode != null) {
			// 1. ) Swap the list position
			ListNode nextNode = originalNextNode.next;
			originalHead.next = nextNode;
			originalNextNode.next = head;

			// 2. ) Update the head
			head = originalNextNode;

			// 3. ) Update the loop object
			originalNextNode = nextNode;
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
		// that why it is node.next.next
		head.next.next = head;
		head.next = null;
		return reversedListHead;
	}
}
