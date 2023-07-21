import utils.ArrayUtils;

public class BubbleSort {
	public static void main(String[] args) {
		final int bound = 50;
		final int size = 6;
		int[] array = ArrayUtils.generateArray(bound,size);
		System.out.println("Before Sorted:");
		ArrayUtils.printArray(array);

		bubbleSort(array);

		System.out.println();
		System.out.println("After Sorted:");
		ArrayUtils.printArray(array);
	}

	public static void bubbleSort(int[] input) {
		boolean shouldKeepSwapping = true;
		while (shouldKeepSwapping) {
			shouldKeepSwapping = false;
			// -1 to prevent out of bounds when accessing the last one
			for (int i = 0; i < input.length - 1; i++) {
				if (input[i] > input[i + 1]) {
					shouldKeepSwapping = true;
					// swapping
					int temp = input[i];
					input[i] = input[i + 1];
					input[i + 1] = temp;
				}
			}
		}
	}
}
