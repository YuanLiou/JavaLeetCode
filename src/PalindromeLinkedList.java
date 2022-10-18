import org.jetbrains.annotations.Nullable;

import utils.ListNode;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		ListNode node01 = new ListNode(1);
		ListNode node02 = new ListNode(1);
		ListNode node03 = new ListNode(2);
		ListNode node04 = new ListNode(1);
		node01.next = node02;
		node02.next = node03;
		node03.next = node04;

		var sampleClass = new PalindromeLinkedList();
		sampleClass.reverseList(node01);

		var isSame = sampleClass.isSameListNode(node01, sampleClass.getReversedHead());
		
		ListNode.printListNode(node01);
		System.out.println("");
		ListNode.printListNode(sampleClass.getReversedHead());
		System.out.println("");
		System.out.println("is same? " + isSame);
	}

	public boolean isPalindrome01(ListNode head) {
		// 1.) Introduce Fast, Slow and Previous Pointer
		ListNode fastNode = head;
		ListNode slowNode = head;
		ListNode previousNode = head;

		// 2.) Find the center of the LinkedList (Slow Pointer)
		while (fastNode != null && slowNode != null) {
			if (fastNode.next != null) {
				fastNode = fastNode.next.next;
			} else {
				fastNode = null;
			}

			previousNode = slowNode;
			slowNode = slowNode.next;
		}

		// 3.) Reverse the center to the end of the LinkedList
		previousNode.next = null;
		if (slowNode != null) {
			reverseList(slowNode);
		} else {
			// Reverse the whole list
			ListNode reversedListNode = head;
			reverseList(reversedListNode);
			reversedHead = getReversedHead();
		}
		return isSameListNode(head, getReversedHead());
	}

	public boolean isPalindrome02(ListNode head) {
		ListNode reversedListNode = head;

		reverseList(reversedListNode);
		reversedHead = getReversedHead();

		var isSame = isSameListNode(head, reversedHead);
		return isSame;
	}

	private ListNode reversedHead = null;
	private ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		var originalNextNode = reverseList(head.next);
		ListNode copiedNode = new ListNode(head.val);
		if (originalNextNode != null) {
			originalNextNode.next = copiedNode;
		} else {
			reversedHead = copiedNode;
		}
		return copiedNode;
	}

	@Nullable
	public ListNode getReversedHead() {
		return reversedHead;
	}

	private boolean isSameListNode(ListNode head01, ListNode head02) {
		ListNode node01 = head01;
		ListNode node02 = head02;
		while (node01 != null && node02 != null) {
			if (node01.val != node02.val) {
				return false;
			}
			node01 = node01.next;
			node02 = node02.next;
		}
		return true;
	}
}
