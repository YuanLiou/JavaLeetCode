import utils.ArrayUtils;

public class TwoSumTwo {

	public static void main(String[] args) {
		var sampleClass = new TwoSumTwo();
		var sample01 = new int[]{2, 7, 11, 15};
		var target01 = 9;

		var sample02 = new int[]{2, 3, 4};
		var target02 = 6;

		var sample03 = new int[]{-1, 0};
		var target03 = -1;

		var sample04 = new int[]{-1, 0, 3, 5, 6, 9, 14};
		var target04 = 12;

		// expected = [4, 5]
		var sample05 = new int[]{1,2,3,4,4,9,56,90};
		var target05 = 8;

		var result = sampleClass.twoSum02(sample01, target01);
		ArrayUtils.printArray(result);
	}

	/*
							        O,       O       -> 3, 6
		sample04 = new int[]{-1, 0, 3, 5, 6, 9, 14};
		                     0,  1, 2, 3, 4, 5, 6
		target04 = 12;
		i = 2, 3
		r = 9 (target)
		s = 4, e = 6
		m = 4 + (6 - 4) / 2 ==> 5
		num[m] = 9
		[3, 6]
	 */

	// Second Practice
	public int[] twoSum02(int[] numbers, int target) {
		// start from index 1
		if (numbers.length == 2) {
			return new int[] {1, 2};
		}

		// Time: n * Log(n)
		// Space: O(1)
		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			int remainder = target - number;
			int remainderIndex = findTarget(
					numbers,
					remainder,
					i + 1,
					numbers.length - 1
			);
			
			if (remainderIndex != -1) {
				return new int[] { i + 1, remainderIndex + 1};
			}
		}
		return new int[]{};
	}

	private int findTarget(
			int[] nums,
			int target,
			int start,
			int end
	) {
		while (start <= end) {
			int middle = start + (end - start) / 2;
			if (nums[middle] == target) {
				return middle;
			} else if (nums[middle] > target) {
				end = middle - 1;
			} else {
				// nums[middle] < target
				start = middle + 1;
			}
		}
		return -1;
	}

	public static int[] twoSum(int[] numbers, int target) {
		// base case
		if (numbers == null) {
			return new int[]{};
		}

		// Doing Two Pointer Technique
		int leftBound = 0;
		int rightBound = numbers.length - 1;
		while (leftBound < rightBound) {
			int currentSum = numbers[leftBound] + numbers[rightBound];
			if (currentSum > target) {
				rightBound = rightBound - 1; // shrink the bound to be a smaller number
			} else if (currentSum < target) {
				leftBound = leftBound + 1; // expand the bound to be a larger number
			} else {
				return new int[]{(leftBound + 1), (rightBound + 1)};
			}
		}
		return new int[]{};
	}
}
