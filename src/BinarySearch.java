public class BinarySearch {

	public static void main(String[] args) {
		// expected: 2
		var sample01 = new int[]{7, 11, 25, 38, 39, 54, 61, 86};
		var target = 25;
		// var resultIndex = binarySearchIndex(sample01, target);
		// System.out.println("Target index is " + resultIndex);

		var sampleClass = new BinarySearch();
		var result = sampleClass.searchV2(sample01, target);
		System.out.println("Result index is " + result);
	}

	public static int binarySearchIndex(int[] inputs, int targets) {
		if (inputs == null || inputs.length == 0) {
			return -1;
		}

		int leftBound = 0;
		int rightBound = inputs.length - 1;

		while (leftBound <= rightBound) {
			int middleIndex = leftBound + (rightBound - leftBound) / 2;
			int currentNumber = inputs[middleIndex];
			if (currentNumber == targets) {
				return middleIndex;
			} else if (currentNumber > targets) {
				// It is too big, shrink the right bounds
				rightBound = middleIndex - 1;
			} else {
				// currentNumber < targets
				// It is too small, expand the left bounds
				leftBound = middleIndex + 1;
			}
		}

		return -1;
	}

	public int search(int[] nums, int target) {
		int result = -1;

		int leftBound = 0;
		int rightBound = nums.length - 1;
		int middleIndex = (leftBound + rightBound) / 2;
		while (leftBound <= rightBound) {
			if (nums[middleIndex] == target) {
				return middleIndex;
			}

			if (nums[middleIndex] > target) {
				rightBound = middleIndex - 1;
			} else {
				leftBound = middleIndex + 1;
			}
			middleIndex = (leftBound + rightBound) / 2;
		}

		return result;
	}

	private int searchV2(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int middle = left + (right - left) / 2;
			// Change our condition here to fit various questions
			if (nums[middle] >= target) { // 無限逼近
				right = middle;
			} else {
				left = middle + 1;
			}
		}
		return left;
	}
}
