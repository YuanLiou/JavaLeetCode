import java.util.Arrays;

public class KRadiusSubarrayAverages {
	public static void main(String[] args) {
	}

	public int[] getAverages(int[] nums, int k) {
		var prefixSum = new long[nums.length];
		prefixSum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i];
		}

		var answer = new int[nums.length];
		Arrays.fill(answer,-1);
		for (int i = 0; i < nums.length; i++) {
			if ((i - k) < 0 || (i + k) > (nums.length - 1)) {
				continue;
			}

			var sum = prefixSum[i + k] - prefixSum[i - k] + nums[i - k];
			// Here is the tricks, we need to calculate the result by two long value
			// then cast it to int to prevent overflow.
			answer[i] = (int) (sum / (1 + k * 2));
			// answer[i] = (int) sum / (1 + k * 2); will overflow
		}
		return answer;
	}
}
