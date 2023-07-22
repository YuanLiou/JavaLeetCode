import utils.ArrayUtils;

public class MergeSortTwo {
	public static void main(String[] args) {
		final int bound = 50;
		final int size = 8;
		int[] array = ArrayUtils.generateDedupedArray(bound,size);
		System.out.println("Before Sorted:");
		ArrayUtils.printArray(array);

		mergeSort(array);

		System.out.println();
		System.out.println("After Sorted:");
		ArrayUtils.printArray(array);
	}

	private static void mergeSort(int[] inputArray) {
		if (inputArray.length <= 1) {
			return;
		}

		var endPosition = inputArray.length - 1;
		var midPosition = 0 + (endPosition - 0) / 2;
		// left: 0..midPosition
		var leftArray = new int[midPosition + 1];
		for (int i = 0; i <= midPosition; i++) {
			leftArray[i] = inputArray[i];
		}

		// right: midPosition + 1..endPosition
		var rightArray = new int[endPosition - midPosition];
		var rightPosition = 0;
		for (int i = (midPosition + 1); i <= endPosition; i++) {
			rightArray[rightPosition] = inputArray[i];
			rightPosition++;
		}

		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(inputArray, leftArray, rightArray);
	}

	private static void merge(int[] originArray, int[] leftArray, int[] rightArray) {
		int leftPointer = 0;
		int rightPointer = 0;
		int mergedPointer = 0;
		while (leftPointer < leftArray.length && rightPointer < rightArray.length) {
			if (leftArray[leftPointer] >= rightArray[rightPointer]) {
				originArray[mergedPointer] = rightArray[rightPointer];
				rightPointer++;
			} else {
				originArray[mergedPointer] = leftArray[leftPointer];
				leftPointer++;
			}
			mergedPointer++;
		}

		while (leftPointer < leftArray.length) {
			originArray[mergedPointer] = leftArray[leftPointer];
			leftPointer++;
			mergedPointer++;
		}

		while (rightPointer < rightArray.length) {
			originArray[mergedPointer] = rightArray[rightPointer];
			rightPointer++;
			mergedPointer++;
		}
	}
}
