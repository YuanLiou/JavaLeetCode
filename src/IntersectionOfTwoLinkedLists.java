import java.util.HashSet;
import java.util.Set;

import utils.ListNode;

public class IntersectionOfTwoLinkedLists {
	public static void main(String[] args) {
	}

	// Approach01: Brute Force
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> container = new HashSet<>();

		ListNode currentA = headA;
		ListNode currentB = headB;
		while (currentA != null || currentB != null) {
			if (currentA != null) {
				if (!container.contains(currentA)) {
					container.add(currentA);
				} else {
					return currentA;
				}

				// Move to the next one
				currentA = currentA.next;
			}

			if (currentB != null) {
				if (!container.contains(currentB)) {
					container.add(currentB);
				} else {
					return currentB;
				}

				// Move to the next one
				currentB = currentB.next;
			}
		}

		return null;
    }

	// Approach02: Crossover way
	public ListNode getIntersectionNode02(ListNode headA, ListNode headB) {
		boolean isASwitchToB = false;
		boolean isBSwitchToA = false;

		ListNode currentA = headA;
		ListNode currentB = headB;
		// Tips we can perform while (currentA != currentB), then we can get rid of two booleans
		while (currentA != null && currentB != null) {
			// 1) Check whether they are same
			if (currentA == currentB) {
				return currentA;
			}

			currentA = currentA.next;
			if (currentA == null && !isASwitchToB) {
				isASwitchToB = true;
				currentA = headB;
			}

			currentB = currentB.next;
			if (currentB == null && !isBSwitchToA) {
				isBSwitchToA = true;
				currentB = headA;
			}
		}
		return null;
	}
}
