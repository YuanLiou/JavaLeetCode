public class MinimumSizeSubarraySum {
	public static void main(String[] args) {
		var sampleClass = new MinimumSizeSubarraySum();
		// expected: 2
		var sample01 = new int[]{2, 3, 1, 2, 4, 3};
		var target01 = 7;
		// expected: 1
		var sample02 = new int[]{1, 4, 4};
		var target02 = 4;
		// expected: 0
		var sample03 = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
		var target03 = 11;
		// expected: 3
		var sample04 = new int[]{1, 2, 3, 4, 5};
		var target04 = 11;
		// expected: 2
		var sample05 = new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
		var target05 = 15;
		var result = sampleClass.minSubArrayLenPractice(target04, sample04);
		System.out.println("Result is " + result);
	}
	public int minSubArrayLenPractice(int target, int[] nums) {
		if (nums.length == 1) {
			if (nums[0] == target) {
				return 1;
			} else {
				return 0;
			}
		}

		int minLength = 0;
		int i = 0;
		int j = 1;
		int currentSum = nums[i] + nums[j];
		while (j < nums.length && i <= j) {
			if (currentSum < target) {
				j++;
				if (j < nums.length) {
					currentSum += nums[j];
				}
			} else {
				int length = j - i + 1;
				if (minLength == 0) {
					minLength = length;
				} else {
					minLength = Math.min(length, minLength);
				}

				currentSum -= nums[i];
				i++;
			}
		}
		return minLength;
	}

	// Brute Force
	public int minSubArrayLen(int target, int[] nums) {
		// base case
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int totalSize = nums.length;
		int startPoint = 0;
		int j = 0;

		int minSize = nums.length + 1;
		int sum = 0;
		while (startPoint < totalSize && j < totalSize) {
			sum += nums[j];

			while (sum >= target) {
				minSize = Math.min(minSize, j - startPoint + 1);

				// Shrink the left boundary to check if there is a tiny subarray
				// meets our requirement. Check if we remove the very first item
				// in the sub array, would it fit requirement? or break the inner while loop.
				sum = sum - nums[startPoint];
				startPoint++; // Keep move left to break the loop
			}

			j++;
		}

		if (minSize == nums.length + 1) {
			return 0;
		}
		return minSize;
	}

	public int minSubArrayLenFailed(int target, int[] nums) {
		// base case
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int sum = 0;
		for (int number : nums) {
			sum += number;
		}

		if (target > sum) {
			return 0;
		}

		int left = 0;
		int minSize = 10001; // max size of num[i]
		for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
			left = left + nums[currentIndex];
			int right = sum - left;

			if (left >= target) {
				minSize = Math.min(minSize, currentIndex + 1);
			}

			if (right >= target) {
				minSize = Math.min(minSize, (nums.length - (currentIndex + 1)));
			}
		}

		if (minSize == 10001) {
			return 0;
		}
		return minSize;
	}
}
