import utils.ListNode;

public class RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		//region sample01
		ListNode sample01 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);

		sample01.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		//endregion

		ListNode sample02 = new ListNode(1);
//		ListNode listNode002 = new ListNode(2);
//		sample02.next = listNode002;

		var sampleClass = new RemoveNthNodeFromEndOfList();
		var result = sampleClass.removeNthFromEnd(sample02, 1);
		ListNode.printListNode(result);
	}

	// Approach 01: Dual Loop
    public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}

		// 1.) Find the size
		int size = 0;
		ListNode current = head;
		while (current != null) {
			size++;
			current = current.next;
	    }

		if (n > size) {
			return head;
		}

		// 2.) Delete the target
	    ListNode previousNode = head;
		ListNode currentNode = head.next;
		int position = size - n;
		int currentIndex = 1;
		while (currentIndex < position && currentNode != null) {
			previousNode = previousNode.next;
			currentNode = currentNode.next;
			currentIndex++;
		}

		// 3.) Link the target node's next node to its previous node
	    if (currentIndex > position) {
			// Remove the head
		    return currentNode;
	    }

	    if (currentNode != null) {
		    previousNode.next = currentNode.next;
	    }

		return head;
	}


	// Approach 02: DummyNode time: O(n)
	public ListNode removeNthFromEnd02(ListNode head, int n) {
		// Base case
		if (head == null) {
			return null;
		}

		// 1. Add a new dummy node for slow pointer to start
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;

		ListNode slowPointer = dummyNode;

		// 2. Add a fast pointer starts from original head, and moves n steps.
		ListNode fastPointer = head;
		for (int i = 0; i < n; i++) {
			fastPointer = fastPointer.next;
		}

		// 3. Move fast and slow pointer every one step until fast pointer
		//    point to null
		while (fastPointer != null) {
			fastPointer = fastPointer.next;
			slowPointer = slowPointer.next;
		}

		// 4. Point the next node of slow pointer to the next and next node
		//    in order to remove it.
		slowPointer.next = slowPointer.next.next;

		return dummyNode.next; // return original head
	}
}
