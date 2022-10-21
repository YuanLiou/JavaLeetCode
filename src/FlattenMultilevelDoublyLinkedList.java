import java.util.ArrayDeque;

public class FlattenMultilevelDoublyLinkedList {
	private class Node {
		int val;
		Node prev;
		Node next;
		Node child;
	}

	public Node flatten(Node head) {
		// 1.) if Node's child is not null, set the next to child, set child to null
		// (and child's prev to its parent)
		// 2.) Save the original leaving point (in a Stack?) (leavingPoint = current.next)
		// 3.) When we running the end of a Doubly LinkedList, pop an Node from the stack
		// 4.) set popped node's prev to the end of a Doubly LinkedList
		// (and update the end of the Doubly LinkedList's next to popped node)

		ArrayDeque<Node> nodeStack = new ArrayDeque<Node>();
		Node previous = head;
		Node current = head;

		while (current != null || !nodeStack.isEmpty()) {
			if (current == null) {
				Node popped = nodeStack.pop();

				previous.next = popped;
				popped.prev = previous;

				current = popped;
				continue;
			}

			if (current.child != null) {
				if (current.next != null) {
					nodeStack.push(current.next);
				}

				current.next = current.child;
				current.child.prev = current;

				previous = current;
				current = current.child;

				previous.child = null;
				continue;
			}

			previous = current;
			current = current.next;
		}
		return head;
	}
}
