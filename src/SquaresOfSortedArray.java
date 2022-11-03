import java.util.Arrays;

import utils.ArrayUtils;

public class SquaresOfSortedArray {
	public static void main(String[] args) {
		var sampleClass = new SquaresOfSortedArray();
		// Expect: [0, 1, 9, 16, 100]
		var example01 = new int[]{-4, -1, 0, 3, 10};
		// Expect: [4, 9, 9, 49, 121]
		var example02 = new int[]{-7, -3, 2, 3, 11};
		var result = sampleClass.sortedSquares02(example01);
		ArrayUtils.printArray(result);
	}

	// brute force
	public int[] sortedSquares(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * nums[i];
		}
		Arrays.sort(nums);
		return nums;
    }

	// Two Pointer
	public int[] sortedSquares02(int[] nums) {
		int[] resultArray = new int[nums.length];
		int leftPointer = 0;
		int rightPointer = resultArray.length - 1;
		for (int i = resultArray.length - 1; i >= 0; i--) {
			if (leftPointer > rightPointer) {
				break;
			}

			int left = nums[leftPointer] * nums[leftPointer];
			int right = nums[rightPointer] * nums[rightPointer];

			if (left > right) {
				resultArray[i] = left;
				leftPointer++;
			} else {
				resultArray[i] = right;
				rightPointer--;
			}
		}
		return resultArray;
	}
}
