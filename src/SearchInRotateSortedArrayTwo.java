public class SearchInRotateSortedArrayTwo {
	public static void main(String[] args) {
		var sampleClass = new SearchInRotateSortedArrayTwo();
		// expect: 1
		var sampleInput01 = new int[]{1, 3};
		var sampleTarget01 = 3;
		var result = sampleClass.search(sampleInput01, sampleTarget01);
		System.out.println("Result is " + result);

		// expect: 1
		var sampleInput02 = new int[]{8, 9, 2, 3, 4};
		var sampleTarget02 = 9;
		var result02 = sampleClass.search(sampleInput02, sampleTarget02);
		System.out.println("Result is " + result02);
	}

	public int search(int[] nums, int target) {
		// Find pivot pointer (the smallest number)
		int leftPointer = 0;
		int rightPointer = nums.length - 1;
		while (leftPointer < rightPointer) {
			int middlePointer = leftPointer + (rightPointer - leftPointer) / 2;
			// 照理來說一個排好的 Array，右邊都要大於左邊
			if (nums[middlePointer] > nums[rightPointer]) {
				leftPointer = middlePointer + 1;
			} else {
				rightPointer = middlePointer;
			}
		}

		int pivotPointer = leftPointer;
		if (nums[pivotPointer] == target) {
			return pivotPointer;
		}

		// Find the number of index
		int left = 0;
		int right = nums.length - 1;

		if (target > nums[right]) {
			right = pivotPointer - 1;
		} else {
			left = pivotPointer;
		}

		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (nums[middle] > target) {
				right = middle - 1;
			} else if (nums[middle] < target) {
				left = middle + 1;
			} else {
				return middle;
			}
		}

		return -1;
	}
}
