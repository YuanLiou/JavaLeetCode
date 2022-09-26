import java.util.ArrayDeque;

import utils.ListNode;
import utils.TreeNode;

public class BinarySearchTreeIterator {
	public static void main(String[] args) {
		//region Sample
		TreeNode node01 = new TreeNode(7);
		TreeNode node02 = new TreeNode(3);
		TreeNode node03 = new TreeNode(15);
		TreeNode node04 = new TreeNode(9);
		TreeNode node05 = new TreeNode(20);
		node01.left = node02;
		node01.right = node03;
		node03.left = node04;
		node03.right = node05;
		//endregion

		var sampleClass = new BinarySearchTreeIterator(node01);
		int result01 = sampleClass.next();
		System.out.println("Next 01 = " + result01);

		int result02 = sampleClass.next();
		System.out.println("Next 02 = " + result02);

		boolean result03 = sampleClass.hasNext();
		System.out.println("HasNext 01 = " + result03);

		int result04 = sampleClass.next();
		System.out.println("Next 03 = " + result04);

		boolean result05 = sampleClass.hasNext();
		System.out.println("HasNext 02 = " + result05);

		int result06 = sampleClass.next();
		System.out.println("Next 04 = " + result06);

		boolean result07 = sampleClass.hasNext();
		System.out.println("HasNext 03 = " + result07);

		int result08 = sampleClass.next();
		System.out.println("Next 05 = " + result08);

		boolean result09 = sampleClass.hasNext();
		System.out.println("HasNext 04 = " + result09);

		int result10 = sampleClass.next();
		System.out.println("Next 06 = " + result10);

		int result11 = sampleClass.next();
		System.out.println("Next 07 = " + result11);
	}

	private ArrayDeque<TreeNode> stack = new ArrayDeque<>();
	private TreeNode current = null;
	private TreeNode previous = null;
	public BinarySearchTreeIterator(TreeNode root) {
		current = root;
	}

	public int next() {
		while (current != null) {
			stack.push(current);
			current = current.left;
		}

		var node = stack.pollFirst();
		if (node != null) {
			previous = node;
		} else {
			node = previous;
		}

		current = node.right;
		return node.val;
	}

	public boolean hasNext() {
		return !stack.isEmpty() || current != null;
	}
}
