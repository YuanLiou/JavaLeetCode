import java.util.HashMap;
import java.util.Map;

import utils.ArrayUtils;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int[] sample01 = new int[]{2, 7, 11, 15};
		// expected: 0, 1
		var result01 = twoSum.twoSum(sample01,9);

		int[] sample02 = new int[]{3, 2, 4};
		// expected: 1, 2
		var result02 = twoSum.twoSum(sample02,6);

		int[] sample03 = new int[]{3, 3};
		// expected: 0, 1
		var result03 = twoSum.twoSum(sample03,6);

		ArrayUtils.printArray(result03);
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> valueIndexes = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int number = nums[i];
			int diff = target - number;
			if (valueIndexes.containsKey(diff)) {
				int j = valueIndexes.get(diff);
				return new int[]{i, j};
			}
			valueIndexes.putIfAbsent(number, i);
		}
		return new int[2];
	}
}
