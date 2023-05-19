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
}
