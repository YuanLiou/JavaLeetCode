package utils;

import org.jetbrains.annotations.Nullable;

public class DoublyListNode {
	private int val;
	private DoublyListNode previous;
	private DoublyListNode next;

	public DoublyListNode(int value) {
		this.val = value;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	@Nullable
	public DoublyListNode getNext() {
		return next;
	}

	public void setNext(DoublyListNode next) {
		this.next = next;
	}

	@Nullable
	public DoublyListNode getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyListNode previous) {
		this.previous = previous;
	}
}
