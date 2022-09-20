import utils.ListNode;

public class OddEvenLinkedList {
	public static void main(String[] args) {
		var sampleClass = new OddEvenLinkedList();

		//region sample01
		var sample01 = new ListNode(1);
		var sample02 = new ListNode(2);
		var sample03 = new ListNode(3);
		var sample04 = new ListNode(4);
		var sample05 = new ListNode(5);
		var sample06 = new ListNode(6);
//		var sample07 = new ListNode(7);
//		var sample08 = new ListNode(8);

		sample01.next = sample02;
		sample02.next = sample03;
		sample03.next = sample04;
		sample04.next = sample05;
		sample05.next = sample06;
//		sample06.next = sample07;
//		sample07.next = sample08;
		//endregion

		var nodes = sampleClass.oddEvenList(sample01);
		ListNode.printListNode(nodes);
	}

	public ListNode oddEvenList(ListNode head) {
		// base case
		if (head == null) {
			return null;
		}

		// 1. ) Two Pointer: Odd node and Even node
		// 1-1) Save the head of even node
		ListNode oddNode = head;
		ListNode evenNode = head.next;
		ListNode evenHead = head.next;

		// 2.) Even list will short or equal to odd list
		//     we use length of even list as stop condition.
		while (evenNode != null && evenNode.next != null) {
			// oddNode.next wouldn't be null because even linkedList is shorter.
			// Even linkedList will enter null first and break the loop.
			oddNode.next = oddNode.next.next;
			evenNode.next = evenNode.next.next;

			// 3.) Moving to next node
			oddNode = oddNode.next;
			evenNode = evenNode.next;
		}

		// 4.) Odd node will be the final position to connect with even linkedList.
		oddNode.next = evenHead;
		return head;
    }
}
