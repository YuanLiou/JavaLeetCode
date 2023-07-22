import utils.ArrayUtils;

public class InsertionSort {
	public static void main(String[] args) {
		final int bound = 50;
		final int size = 8;
		int[] array = ArrayUtils.generateArray(bound,size);
		System.out.println("Before Sorted:");
		ArrayUtils.printArray(array);

		insertionSort(array);

		System.out.println();
		System.out.println("After Sorted:");
		ArrayUtils.printArray(array);
	}
	public static void insertionSort(int[] input) {
		// why we start at 1? That's because position 0 is already sorted
		for (int i = 1; i < input.length; i++) {
			int current = input[i];
			int j = i - 1; // compare the previous number
			while (j >= 0 && input[j] > current) {
				input[j + 1] = input[j]; // swap the larger one to the right
				j--;
			}
			// set the current number from position i to the exit position of j + 1 (It might be -1)
			input[j + 1] = current;
		}
	}
}
