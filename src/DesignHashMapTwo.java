public class DesignHashMapTwo {

	private final static int SIZE = 503; // Any prime number

	private class Node {
		int key;
		int value;
		Node next;

		public Node(int key, int value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	private Node[] contents = new Node[SIZE];

	public static void main(String[] args) {
		var sampleClass = new DesignHashMapTwo();
		sampleClass.put(1, 1);
		sampleClass.put(2, 2);
		var result01 = sampleClass.get(1);
		var result02 = sampleClass.get(3);
		sampleClass.put(2, 1);
		var result03 = sampleClass.get(2);
		sampleClass.remove(2);
		var result04 = sampleClass.get(2);
		System.out.println(result01 + " " + result02 + " " + result03 + " " + result04);
	}

	public DesignHashMapTwo() {
	}

	private int getHash(int key) {
		return key % SIZE;
	}

	public void put(int key, int value) {
		remove(key);

		int index = getHash(key);
		Node current = contents[index];

		if (current == null) {
			var temp = new Node(key, value, null);
			contents[index] = new Node(key, value, null);
			return;
		}

		Node previous = current;
		Node node = current;
		while (node != null) {
			previous = node;
			node = node.next;
		}
		previous.next = new Node(key, value, null);
	}

	public int get(int key) {
		int index = getHash(key);
		Node current = contents[index];
		while (current != null) {
			if (current.key == key) {
				return current.value;
			}
			current = current.next;
		}
		return -1;
	}

	public void remove(int key) {
		int index = getHash(key);
		Node node = contents[index];
		if (node == null) {
			// Nothing to remove
			return;
		}

		if (node.key == key) {
			contents[index] = node.next;
		}

		Node previous = node;
		Node current = node;
		while (current != null) {
			if (current.key == key) {
				previous.next = current.next;
				return;
			}
			previous = current;
			current = current.next;
		}
	}
}
