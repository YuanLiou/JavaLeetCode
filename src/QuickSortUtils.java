import utils.ArrayUtils;
import utils.IntegerUtils;

public class QuickSortUtils {
	public static void main(String[] args) {
		var sample = ArrayUtils.generateArray(100, 10);
		ArrayUtils.printArray(sample);
		quickSort(sample);
		System.out.println("\nAfter:");
		ArrayUtils.printArray(sample);
	}

	public static void quickSort(int[] inputArray) {
		quickSort(inputArray, 0, inputArray.length - 1);
	}

	private static void quickSort(int[] inputArray, int leftBound, int rightBound) {
		// base case
		if (leftBound >= rightBound) {
			return;
		}

		// 1. Pick a number
		int pivotIndex = IntegerUtils.getRandomNumber(leftBound, rightBound);
		int pivot = inputArray[pivotIndex];
		ArrayUtils.swap(inputArray, pivotIndex, rightBound);

		// 2. Rearrange
		int leftPointer = leftBound;
		int rightPointer = rightBound;
		while (leftPointer < rightPointer) {
			// Find left one who is larger then pivot
			while (inputArray[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}

			// Find right one who is smaller then pivot
			while (inputArray[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}

			// Swap the two number who has been pointed
			ArrayUtils.swap(inputArray, leftPointer, rightPointer);
		}

		// Swap the pivot and the met pointer (we use left pointer here)
		//  rightBound is the PivotIndex, because we've swapped it with the picked one.
		ArrayUtils.swap(inputArray, leftPointer, rightBound);

		// 3. Recursion
		//  left pointer is the new PivotIndex, because we've swapped it with the original one.
		quickSort(inputArray, leftBound, leftPointer - 1);
		quickSort(inputArray, leftPointer + 1, rightBound);
	}
}
