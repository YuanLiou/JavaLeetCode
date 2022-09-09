import java.security.Signature;

import utils.SinglyListNode;

public class DesignLinkedList {

	private SinglyListNode head;

	public static void main(String[] args) {
		var myLinkList = new DesignLinkedList();
		myLinkList.addAtHead(1);
		myLinkList.addAtTail(3);
		myLinkList.addAtIndex(1, 2);
		var result01 = myLinkList.get(1);
		myLinkList.deleteAtIndex(1);
		var result02 = myLinkList.get(1);
		var result03 = myLinkList.get(3);
		myLinkList.deleteAtIndex(3);
		myLinkList.deleteAtIndex(0);
		var result04 = myLinkList.get(0);
		myLinkList.deleteAtIndex(0);
		var result05 = myLinkList.get(0);
		System.out.println(result01 + ", " + result02 + ", " + result03 + ", " + result04 + ", " + result05);
	}

	public int get(int index) {
		if (head == null) {
			return -1;
		}

		int currentIndex = 0;
		SinglyListNode current = head;
		while (currentIndex <= index) {
			if (currentIndex == index) {
				return current.getVal();
			}

			if (current.getNext() == null) {
				break;
			}

			currentIndex++;
			current = current.getNext();
		}

		return -1;
	}

	public void addAtHead(int val) {
		SinglyListNode newHead = new SinglyListNode(val);
		if (head != null) {
			newHead.setNext(head);
		}
		head = newHead;
	}

	public void addAtTail(int val) {
		if (head == null) {
			head = new SinglyListNode(val);;
			return;
		}

		SinglyListNode previous = head;
		SinglyListNode current = head.getNext();
		while (current != null) {
			previous = current;
			current = current.getNext();
		}

		SinglyListNode newTail = new SinglyListNode(val);
		previous.setNext(newTail);
	}

	public void addAtIndex(int index, int val) {
		if (head == null) {
			if (index == 0) {
				addAtHead(val);
			} else {
				return;
			}
		}

		SinglyListNode temp = new SinglyListNode(val);
		int currentIndex = 0;

		SinglyListNode previousNode = head;
		SinglyListNode currentNode = head;
		while (currentIndex < index && currentNode != null) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
			currentIndex++;
		}

		if (currentIndex != index) {
			return;
		}

		if (previousNode == currentNode) {
			addAtHead(val);
		} else {
			temp.setNext(currentNode);
			previousNode.setNext(temp);
		}
	}

	public void deleteAtIndex(int index) {
		if (head == null) {
			return;
		}
		int currentIndex = 0;

		SinglyListNode previousNode = head;
		SinglyListNode currentNode = head;
		while (currentIndex < index && currentNode != null) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
			currentIndex++;
		}

		if (currentIndex != index) {
			return;
		}

		if (previousNode == currentNode) {
			head = head.getNext();
		} else if (currentNode != null) {
			SinglyListNode temp = currentNode.getNext();
			previousNode.setNext(temp);
		}
	}
}
