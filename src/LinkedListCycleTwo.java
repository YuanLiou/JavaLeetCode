import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

import utils.ListNode;
import utils.TreeNode;

public class LinkedListCycleTwo {
	public static void main(String[] args) {
	}

	// Approach 01: Hashset
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}

		Set<ListNode> hashSet = new HashSet<>();
		ListNode current = head;

		while (current != null) {
			if (hashSet.contains(current)) {
				return current;
			}
			hashSet.add(current);
			current = current.next;
		}
		return null;
    }

	// Approach 02: Same path length between start point and interactive point
	public ListNode detectCycle02(ListNode head) {
		// 1) Find the interactive pointer
		ListNode interactPointer = findInteractivePoint(head);
		if (interactPointer == null) {
			return null;
		}

		// 2) Find the starting point of the cycle
		ListNode startPointer = head;
		while (startPointer != interactPointer) {
			if (startPointer == null || interactPointer == null) {
				return null;
			}
			
			startPointer = startPointer.next;
			interactPointer = interactPointer.next;
		}

		return startPointer;
	}

	@Nullable
	private ListNode findInteractivePoint(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode slowPointer = head;
		ListNode fastPointer = head;

		while (slowPointer != null && fastPointer != null) {

			slowPointer = slowPointer.next;

			if (fastPointer.next != null) {
				fastPointer = fastPointer.next.next;
			}

			if (slowPointer == fastPointer) {
				return slowPointer;
			}
		}

		return null;
	}
}
