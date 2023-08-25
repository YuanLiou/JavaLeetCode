public class HouseRobberTwo {
	public static void main(String[] args) {
	}

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		// main logic: either choosing the first one and getting rid of the last one
		//             or getting rid of first one and choosing the last one.
		int num1 = performRob(nums, 1, nums.length);
		int num2 = performRob(nums, 0, nums.length - 1);
		return Math.max(num1, num2);
	}

	/*
	                               *
	example => A = [6, 2, 3, 7, 9, 2]
	               [6, 6, 9, 13, 18, 18]
	c = 18
	rs01 = 18
	rs02 = 18
	 */
	// Space O(1) 的作法。 Space O(N) 的作法請參考 House Robber 1
	private int performRob(
			int[] nums,
			int start, // included
			int end // excluded
	) {
		int robState01 = 0;
		int robState02 = 0;

		for (int i = start; i < end; i++) {
			int current = Math.max(robState01 + nums[i], robState02);
			robState01 = robState02;
			robState02 = current;
		}
		return robState02;
	}
}
