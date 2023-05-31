import java.util.HashMap;
import java.util.Map;

public class MaximumScoreFromPerformingMultiplicationOperations {
	public static void main(String[] args) {
	}


	private Map<String, Integer> memo = new HashMap<>();
	public int maximumScore(int[] nums, int[] multipliers) {
		return calculate(0, nums, multipliers, 0);
	}

	private int calculate(
			int mIndex,
			int[] nums,
			int[] multipliers,
			int startIndex
	) {
		// base case
		if (mIndex == multipliers.length) {
			return 0;
		}

		int endIndex = nums.length - (mIndex - startIndex) - 1;

		String key = generateKey(mIndex, startIndex);
		if (memo.containsKey(key)) {
			return memo.get(key);
		} else {
			int maxLeft = nums[startIndex] * multipliers[mIndex] + calculate(mIndex + 1, nums, multipliers, startIndex + 1);
			int maxRight = nums[endIndex] * multipliers[mIndex] + calculate(mIndex + 1, nums, multipliers, startIndex);
			int answer = Math.max(maxLeft, maxRight);
			memo.put(key, answer);
			return answer;
		}
	}

	private String generateKey(int mIndex, int startIndex) {
		return String.valueOf(mIndex) + "," + String.valueOf(startIndex);
	}
}
