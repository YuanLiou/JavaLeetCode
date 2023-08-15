import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
	public int rob(int[] nums) {
		return robHouse(nums, nums.length - 1);
	}

	Map<Integer, Integer> memoization = new HashMap<>();
	private int robHouse(int[] nums, int index) {
		// Base case
		if (index == 0) {
			return nums[0];
		}

		if (index == 1) {
			return Math.max(nums[0], nums[1]);
		}

		// rob it (current money + previous robbed money) or not rob it (only previous robbed money).
		//  this -2 means we can't rob house which between each other.
		if (!memoization.containsKey(index)) {
			int maxValue = Math.max(nums[index] + robHouse(nums, index - 2), robHouse(nums, index - 1));
			memoization.put(index, maxValue);
			return maxValue;
		} else {
			return memoization.get(index);
		}
	}

	private int robHouse02(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] sums = new int[nums.length];
		Arrays.fill(sums, 0);

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				sums[i] = nums[i];
			} else if (i == 1) {
				var secondNum = Math.max(nums[i], sums[i - 1]);
				sums[i] = secondNum;
			} else {
				var current = Math.max(nums[i] + sums[i - 2], sums[i - 1]);
				sums[i] = current;
			}
		}
		return sums[sums.length - 1];
	}
}
