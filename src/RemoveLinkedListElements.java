import utils.ListNode;

public class RemoveLinkedListElements {
	public static void main(String[] args) {
		var sampleClass = new RemoveLinkedListElements();
		//region sample01
		var node01 = new ListNode(1);
		var node02 = new ListNode(2);
		var node03 = new ListNode(2);
		var node04 = new ListNode(1);
//		var node05 = new ListNode(4);
//		var node06 = new ListNode(5);
//		var node07 = new ListNode(6);
		node01.next = node02;
		node02.next = node03;
		node03.next = node04;
//		node04.next = node05;
//		node05.next = node06;
//		node06.next = node07;
		//endregion

		var result = sampleClass.removeElements(node01, 2);
		ListNode.printListNode(result);
	}

	public ListNode removeElements(ListNode head, int val) {
		var node = head;
		while (node != null) {

			// 1.) Check myself
			if (node.val == val) {
				// Head only
				head = head.next;

				// Moving right
				node = node.next;

				continue;
			}

			// 2.) My neighbor is the target
			while (node.next != null && node.next.val == val) {
				// Remove the next one
				node.next = node.next.next;
			}

			// Moving right
			node = node.next;
		}

        return head;
    }
}
