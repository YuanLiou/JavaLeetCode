public class MinimumValuetoGetPositiveStepByStepSum {
	public static void main(String[] args) {
	}

	public int minStartValue(int[] nums) {
		int smallestSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			var current = nums[i - 1] + nums[i];
			smallestSum = Math.min(current, smallestSum);
			nums[i] = current;
		}

		if (smallestSum > 0) {
			return 1;
		}
		return 1 + (smallestSum * -1); // +1 for positive number
	}
}
