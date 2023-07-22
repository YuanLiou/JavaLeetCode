import static utils.ArrayUtils.printArray;

import java.util.Random;
import utils.ArrayUtils;

public class MergeSort {

	public static void main(String[] args) {
		int[] sampleArray = ArrayUtils.generateArray(100, 10);
		System.out.print("Original: ");
		printArray(sampleArray);

		mergeSort(sampleArray);
		System.out.println("");
		System.out.print("Sorted: ");
		printArray(sampleArray);
	}

	private static void mergeSort(int[] numberArray) {
		// Divide and concur
		// 1. divide each element to the smallest size: 1
		//   1-a: find the mid, and gen two array: leftArray, rightArray
		//   1-b: leftArray.length -> 0..mid, rightArray.length -> mid + 1..original.length
		//   1-c: (code) use loop to fill the array
		// 2. merge them
		//   2-a: compare two array, start from the left pointer of each of them.
		//   2-b: which is smaller? pick the smaller one into the merged array.
		//   2-c: the array which has been picked number should update its pointer into
		//        next position
		//   2-(looping-above until leftIndex > left.length or rightIndex > right.length)
		//     (So the while loop logic would be AND)
		//   2-d: integrate the remaining array and added numbers into the merged array
		//        (it has been sorted, so it can be put into merged one directly.)
		// recursion, find the base case as the stop condition

		if (numberArray.length <= 1) {
			// if an array length is 1, it means we find the smallest sample.
			return;
		}

		// divide into left and right
		int originalSize = numberArray.length;
		int middle = originalSize / 2;

		int[] leftArray = new int[middle];
		// it might be odds, it would be more accurate to counts by originalSize - middle
		int[] rightArray = new int[originalSize - middle];

		// fill leftArray and rightArray
		for (int i = 0; i < middle; i++) {
			leftArray[i] = numberArray[i];
		}

		for (int i = middle; i < originalSize; i++) {
			rightArray[i - middle] = numberArray[i];
		}

		// divide it recursively
		mergeSort(leftArray);
		mergeSort(rightArray);

		merge(numberArray, leftArray, rightArray);
	}

	private static void merge(int[] numberArray, int[] leftArray, int[] rightArray) {
		// 1. Compare leftArray and rightArray, pick the first position of each.
		// 2. Pick the smaller one (use can use <= here)
		// 3. Added it into k position of numberArray.
		// 4. Move the pointer to the next from the array which has been picked number.
		// (looping above, until i >= left.length or j >= right.length)(So the while loop logic would be AND)
		// 5. Add numbers from the remaining array. (use a while loop:(array.length > 0) to looping)

		int leftSize = leftArray.length;
		int rightSize = rightArray.length;

		int leftIndex = 0;
		int rightIndex = 0;
		int mergedIndex = 0;

		while (leftIndex < leftSize && rightIndex < rightSize) {
			// Pick the small one (A <= B -> pick A)
			if (leftArray[leftIndex] <= rightArray[rightIndex]) {
				numberArray[mergedIndex] = leftArray[leftIndex];
				leftIndex++;
			} else {
				numberArray[mergedIndex] = rightArray[rightIndex];
				rightIndex++;
			}
			mergedIndex++;
		}

		// Add numbers from remaining array
		// Either this loop
		while (leftIndex < leftSize) {
			numberArray[mergedIndex] = leftArray[leftIndex];
			leftIndex++;
			mergedIndex++;
		}

		// or this loop
		while (rightIndex < rightSize) {
			numberArray[mergedIndex] = rightArray[rightIndex];
			rightIndex++;
			mergedIndex++;
		}
	}
}
