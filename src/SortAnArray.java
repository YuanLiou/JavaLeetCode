import java.util.Arrays;
import utils.ArrayUtils;

public class SortAnArray {

	public static void main(String[] args) {
		var sampleClass = new SortAnArray();

		// expected: 1, 2, 3, 5
		var example = new int[]{5, 2, 3, 1};

		// expected: 0, 0, 1, 1, 2, 5
		var example02 = new int[]{5, 1, 1, 2, 0, 0};

		var result = sampleClass.sortArray(example02);
		ArrayUtils.printArray(result);
	}

	public int[] sortArray(int[] nums) {
		if (nums.length <= 1) {
			return nums;
		}

		int midpoint = nums.length / 2;
		var leftPart = sortArray(Arrays.copyOfRange(nums, 0, midpoint));
		var rightPart = sortArray(Arrays.copyOfRange(nums, midpoint, nums.length));
		return merge(leftPart, rightPart);
	}

	private int[] merge(int[] leftArray, int[] rightArray) {
		var mergedLength = leftArray.length + rightArray.length;
		var mergedArray = new int[mergedLength];

		var mergedIndex = 0;
		var leftIndex = 0;
		var rightIndex = 0;

		// compare size and add into the new array
		while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
			if (leftArray[leftIndex] < rightArray[rightIndex]) {
				mergedArray[mergedIndex] = leftArray[leftIndex];
				leftIndex++;
			} else {
				mergedArray[mergedIndex] = rightArray[rightIndex];
				rightIndex++;
			}
			mergedIndex++;
		}

		// add the remaining numbers
		while (leftIndex < leftArray.length) {
			mergedArray[mergedIndex] = leftArray[leftIndex];
			leftIndex++;
			mergedIndex++;
		}
		while (rightIndex < rightArray.length) {
			mergedArray[mergedIndex] = rightArray[rightIndex];
			rightIndex++;
			mergedIndex++;
		}
		return mergedArray;
	}
}
