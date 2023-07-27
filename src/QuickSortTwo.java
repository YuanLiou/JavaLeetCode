import java.util.Random;
import utils.ArrayUtils;

public class QuickSortTwo {

	public static void main(String[] args) {
		var testArray = ArrayUtils.generateDedupedArray(100, 8);
//		var testArray = new int[]{1, 2, 3, 4, 5};
		System.out.print("original array: ");
		ArrayUtils.printArray(testArray);

		System.out.println("");

		quickSort(testArray);
		System.out.print("Sorted array: ");
		ArrayUtils.printArray(testArray);
	}

	private static void quickSort(int[] numberArray) {
		quickSort(numberArray, 0, numberArray.length - 1);
	}

	private static void quickSort(int[] numberArray, int leftBound, int rightBound) {
		// base case
		if (numberArray.length <= 1 || leftBound >= rightBound) {
			return;
		}

		// Random pick from leftBound..rightBound, and put it to the right
		final int pickedIndex = new Random().nextInt(rightBound - leftBound) + leftBound;
		final int pivotIndex = rightBound;
		swap(numberArray,pickedIndex,pivotIndex);

		int leftIndex = leftBound;
		int rightIndex = rightBound;

		while (leftIndex < rightIndex) {
			while (leftIndex < rightIndex && numberArray[leftIndex] <= numberArray[pivotIndex]) {
				leftIndex++;
			}

			while (leftIndex < rightIndex && numberArray[rightIndex] >= numberArray[pivotIndex]) {
				rightIndex--;
			}

			if (leftIndex < rightIndex) {
				swap(numberArray, leftIndex, rightIndex);
			}
		}
		swap(numberArray, leftIndex, pivotIndex);

		// The left index and right index will point to the same position
		quickSort(numberArray, leftBound, leftIndex - 1);
		quickSort(numberArray, leftIndex + 1, rightBound);
	}

	private static void swap(int[] array, int leftIndex, int rightIndex) {
		int temp = array[leftIndex];
		array[leftIndex] = array[rightIndex];
		array[rightIndex] = temp;
	}
}
