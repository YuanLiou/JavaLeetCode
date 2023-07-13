import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		var sampleClass = new LongestIncreasingSubsequence();
		// expected: 4
		int[] sampleInput = {10,9,2,5,3,7,101,18};
		var result01 = sampleClass.lengthOfLIS(sampleInput);
		System.out.println("Result is " + result01);

		// expected: 1
		int[] sampleInput02 = {7,7,7,7,7,7,7};
		var result02 = sampleClass.lengthOfLIS(sampleInput02);
		System.out.println("Result02 is " + result02);

		// expected: 3
		int[] sampleInput03 = {4,10,4,3,8,9};
		var result03 = sampleClass.lengthOfLIS(sampleInput03);
		System.out.println("Result03 is " + result03);
	}

	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);

		int maxLength = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					// 自身 + 任意後面的位置，都有可能組成最大的 Subsequence
					dp[i] = Math.max(dp[i], 1 + dp[j]);
					maxLength = Math.max(maxLength, dp[i]);
				}
			}
		}

		// 不一定最前面的那個位置的是最長的
		return maxLength;
	}
}
