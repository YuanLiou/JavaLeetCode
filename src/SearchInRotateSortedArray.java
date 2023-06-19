public class SearchInRotateSortedArray {
	public static void main(String[] args) {
		var sampleClass = new SearchInRotateSortedArray();
		// expect: 1
//		var sampleInput01 = new int[]{1, 3};
//		var sampleTarget01 = 3;
//		var result = sampleClass.search(sampleInput01, sampleTarget01);
//		System.out.println("Result is " + result);

		// expect: 1
		var sampleInput02 = new int[]{8, 9, 2, 3, 4};
		var sampleTarget02 = 9;
		var result02 = sampleClass.search(sampleInput02, sampleTarget02);
		System.out.println("Result is " + result02);
	}

	public int search(int[] nums, int target) {
		// step 1: find the pivot point
		int leftBound = 0;
		int rightBound = nums.length - 1;
		int endIndex = nums.length - 1; // to prevent right bound keep changing
		while (leftBound < rightBound) {
			int middle = leftBound + ((rightBound - leftBound) / 2);
			if (nums[endIndex] > nums[middle]) {
				rightBound = middle - 1;
			} else {
				leftBound = middle + 1;
			}
		}
		int pivot = leftBound;

		// step 2: choose we should use the left part of the right part of the pivot point
		//         do a binary search to find target
		if (nums[pivot] == target) {
			return pivot;
		}

		int leftBound01 = 0;
		int rightBound01 = nums.length - 1;
		if (pivot != 0) {
			// make sure it is a shifted array
			if (target < nums[0]) {
				// target is in the right side of a pivot
				leftBound01 = pivot;
			} else {
				// target is in the left side of a pivot
				rightBound01 = pivot - 1;
			}
		}

		while (leftBound01 <= rightBound01) {
			int middle01 = leftBound01 + ((rightBound01 - leftBound01) / 2);
			if (nums[middle01] > target) {
				rightBound01 = middle01 - 1;
			} else if (nums[middle01] < target) {
				leftBound01 = middle01 + 1;
			} else {
				return middle01;
			}
		}

		return -1;
	}
}
