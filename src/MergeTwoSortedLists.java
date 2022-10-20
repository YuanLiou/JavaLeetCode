import utils.ListNode;

public class MergeTwoSortedLists {
	public static void main(String[] args) {
		var list03a = new ListNode(4);
		var list02a = new ListNode(2, list03a);
		var list01a = new ListNode(1, list02a);

		var list03b = new ListNode(4);
		var list02b = new ListNode(3, list03b);
		var list01b = new ListNode(1, list02b);

		var sampleClass = new MergeTwoSortedLists();
		var result = sampleClass.mergeTwoLists(list01a, list01b);
		ListNode.printListNode(result);

	}

	private record ListResult(ListNode head, ListNode current) {}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// If both nodes are null, we're done
		if (list1 == null && list2 == null) {
			return null;
		}

		ListNode resultHead = null;
		ListNode resultList = null;

		ListNode currentA = list1;
		ListNode currentB = list2;
		while (currentA != null || currentB != null) {
			// If a node is null, return another one
			if (currentA != null && currentB == null) {
				var result = updateResult(resultHead, resultList, currentA);
				resultHead = result.head;
				resultList = result.current;

				currentA = currentA.next;
				continue;
			}

			// If a node is null, return another one
			if (currentA == null) {
				var result = updateResult(resultHead, resultList, currentB);
				resultHead = result.head;
				resultList = result.current;

				currentB = currentB.next;
				continue;
			}

			// Select two nodes from two link, Pick the one who is smaller.
			// Add this value to a new LinkedList, update the chosen one to its next node
			if (currentA.val > currentB.val) {
				var result = updateResult(resultHead, resultList, currentB);
				resultHead = result.head;
				resultList = result.current;

				currentB = currentB.next;
			} else {
				var result = updateResult(resultHead, resultList, currentA);
				resultHead = result.head;
				resultList = result.current;

				currentA = currentA.next;
			}
		}
		return resultHead;
	}

	private ListResult updateResult(ListNode resultHead, ListNode resultList, ListNode addedNode) {
		if (resultList == null) {
			resultList = addedNode;
			resultHead = resultList;
			return new ListResult(resultHead, resultList);
		}
		
		resultList.next = addedNode;
		return new ListResult(resultHead, resultList.next);
	}
}
