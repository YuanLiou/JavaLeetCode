import utils.DoublyListNode;

public class DesignLinkedListTwo {
	private DoublyListNode head;
	private int length = 0;

	public static void main(String[] args) {
		var myLinkList = new DesignLinkedListTwo();
		myLinkList.addAtHead(1);
		myLinkList.addAtTail(3);
		myLinkList.addAtIndex(1, 2);
		int result01 = myLinkList.get(1);
		myLinkList.deleteAtIndex(0);
		int result02 = myLinkList.get(0);
		System.out.println("Result 01 is " + result01 + ", Result 02 is " + result02);
	}

	public int get(int index) {
		if (index >= length || index < 0) {
			return -1;
		}

		return findNode(index).getVal();
	}

	private DoublyListNode findNode(int index) {
		int currentIndex = 0;
		DoublyListNode node = head;
		while (currentIndex != index && node != null) {
			node = node.getNext();
			currentIndex++;
		}
		return node;
	}

	public void addAtHead(int val) {
		addAtIndex(0, val);
	}

	public void addAtTail(int val) {
		addAtIndex(length, val);
	}

	public void addAtIndex(int index, int val) {
		if (index > length || index < 0) {
			return;
		}

		DoublyListNode insertNode = new DoublyListNode(val);
		if (index < length) {
			DoublyListNode targetNode = findNode(index);

			if (targetNode == null) {
				head = insertNode;
				length++;
				return;
			}

			DoublyListNode previousNode = targetNode.getPrevious();

			insertNode.setPrevious(previousNode);
			insertNode.setNext(targetNode);

			targetNode.setPrevious(insertNode);
			// Insert Into head previous Node would be null
			if (previousNode != null) {
				previousNode.setNext(insertNode);
			} else {
				// Insert the new head should update head reference
				head = insertNode;
			}
		} else {
			// Insert Into tail
			DoublyListNode targetNode = findNode(index - 1);

			if (targetNode == null) {
				head = insertNode;
				length++;
				return;
			}

			targetNode.setNext(insertNode);
			insertNode.setPrevious(targetNode);
		}

		length++;
	}

	public void deleteAtIndex(int index) {
		if (index >= length || index < 0) {
			return;
		}

		DoublyListNode targetNode = findNode(index);
		DoublyListNode nextNode = targetNode.getNext();
		DoublyListNode previousNode = targetNode.getPrevious();

		if (previousNode != null) {
			previousNode.setNext(nextNode);
		} else {
			// Remove the head should update a new head
			head = nextNode;
		}

		if (nextNode != null) {
			nextNode.setPrevious(previousNode);
		}

		length--;
	}
}
