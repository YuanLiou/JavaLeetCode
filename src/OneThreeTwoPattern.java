import java.util.Stack;

public class OneThreeTwoPattern {

	public static void main(String[] args) {
		// expected: true
		var sample01 = new int[]{3, 1, 4, 2};
		// expected: false
		var sample02 = new int[]{1, 2, 3, 4};
		var sampleClass = new OneThreeTwoPattern();
		var result01 = sampleClass.find132pattern(sample01);
		System.out.println("Result 01 is " + result01);

		var result02 = sampleClass.find132pattern(sample02);
		System.out.println("Result 02 is " + result02);
	}
	public boolean find132pattern(int[] nums) {
		if (nums.length < 3) {
			return false;
		}

		// 小 < 大 < 中
		// i < j < k
		// nums[i] < nums[k] < nums[j]
		Stack<NumPair> stack = new Stack<>(); // decreasing monotonic
		int currentMinimum = nums[0];

		// This loop is a process to find the largest one,
		// which is j, it might be the top one of the stack
		for (int i = 1; i < nums.length; i++) {
			int n = nums[i];
			while (!stack.isEmpty() && n >= stack.peek().number) {
				stack.pop(); // decreasing monotonic
			}

			if (!stack.isEmpty() && n > stack.peek().previousMin) {
				return true;
			}

			stack.push(new NumPair(n, currentMinimum));
			currentMinimum = Math.min(n, currentMinimum);
		}
		return false;
	}

	private record NumPair(int number, int previousMin) {}
}
