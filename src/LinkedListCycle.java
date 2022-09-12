import utils.ListNode;

public class LinkedListCycle {
	public static void main(String[] args) {
	}

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}

		var slowPointer = head;
		var fastPointer = head.next;

		while (fastPointer != null) {
			if (fastPointer == slowPointer) {
				return true;
			}

			// Move to the next round
			slowPointer = slowPointer.next;
			
			if (fastPointer.next == null) {
				return false;
			}
			fastPointer = fastPointer.next.next;
		}
		return false;
	}
}
