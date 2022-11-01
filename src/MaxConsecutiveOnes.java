public class MaxConsecutiveOnes {
	public static void main(String[] args) {
		var sampleClass = new MaxConsecutiveOnes();
		// expected: 3
		var sample01 = new int[]{1, 1, 0, 1, 1, 1};
		// expected: 2
		var sample02 = new int[]{1, 0, 1, 1, 0, 1};
		// expected: 0
		var sample03 = new int[]{0};
		// expected: 1
		var sample04 = new int[]{1, 0};
		// expected: 1
		var sample05 = new int[]{1};
		var result = sampleClass.findMaxConsecutiveOnes02(sample05);
		System.out.println("Result is " + result);
	}

	// Pick Number
	private int findMaxConsecutiveOnes(int[] nums) {
		if (nums == null) {
			return 0;
		}

		// Pick number one by one, counts the max counts ONE BY ONE
		int counts = 0;
		int maxCounts = 0;

		for (int number: nums) {
			if (number == 1) {
				counts++;
				maxCounts = Math.max(maxCounts, counts);
			} else {
				counts = 0;
			}
		}
		return maxCounts;
	}

	// Two Pointer
	private int findMaxConsecutiveOnes02(int[] nums) {
		int maxConsecutive = 0;

		int i = 0;
		int j = 0;
		while (i < nums.length) {
			// 1.) if there is 0, count the size
			if (nums[i] == 0) {
				int length = i - j;
				maxConsecutive = Math.max(maxConsecutive, length);

				// 2.) j point to the next number which next to 0
				j = i;
				while (j < nums.length && nums[j] == 0) {
					j++; // find the next one
				}

				// 3.) i point to next one which number is NOT 0
				i = j;
			} else {
				i++;
			}
		}

		// 3.) count nums.length - j, After we leave the loop
		 int length = i - j;
		 maxConsecutive = Math.max(maxConsecutive, length);
		return maxConsecutive;
	}
}
