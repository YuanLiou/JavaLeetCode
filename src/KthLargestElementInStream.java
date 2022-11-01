import java.util.PriorityQueue;

public class KthLargestElementInStream {
	public static void main(String[] args) {
		var samples = new int[] {4, 5, 8, 2};
		var sampleClass = new KthLargestElementInStream(3, samples);
		var ans01 = sampleClass.add(3);
		var ans02 = sampleClass.add(5);
		var ans03 = sampleClass.add(10);
		var ans04 = sampleClass.add(9);
		var ans05 = sampleClass.add(4);

		System.out.println(ans01 + ", " + ans02 + ", " + + ans03 + ", " + ans04 + ", " + ans05);
	}

	private PriorityQueue<Integer> queue = new PriorityQueue();
	private int kthLargest;

    public KthLargestElementInStream(int k, int[] nums) {
		this.kthLargest = k;
		for (int number : nums) {
			add(number);
		}
    }

    public int add(int val) {
		queue.offer(val);
	    if (queue.size() > kthLargest) {
			queue.poll();
	    }

		Integer result = queue.peek();
		if (result != null) {
			return result;
		}
		return -1;
    }
}
