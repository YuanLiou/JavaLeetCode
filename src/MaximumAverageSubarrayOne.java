public class MaximumAverageSubarrayOne {
	public static void main(String[] args) {
	}

	public double findMaxAverage(int[] nums, int k) {
		var sum = 0;
		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}

		var result = sum;
		// if the nums length is the same as k, it won't enter this loop.
		for (int right = k; right < nums.length; right++) {
			// Fixed sliding window
			sum -= nums[right - k]; // remove previous one
			sum += nums[right]; // add current one

			result = Math.max(result, sum);
		}
		return result / (double) k;
	}
}
