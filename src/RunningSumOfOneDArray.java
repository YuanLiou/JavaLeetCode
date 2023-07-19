public class RunningSumOfOneDArray {
	public static void main(String[] args) {
	}

	public int[] runningSum(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i - 1] + nums[i];
		}
		return nums;
	}
}
