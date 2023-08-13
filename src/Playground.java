import java.util.Arrays;
import utils.ArrayUtils;
import utils.IntegerUtils;

public class Playground {

	public static void main(String[] args) {
		binarySearchPractice();
	}

	private static void binarySearchPractice() {
		int[] randomArray = ArrayUtils.generateDedupedArray(30, 10);
		Arrays.sort(randomArray);
		ArrayUtils.printArray(randomArray);
		int number = IntegerUtils.getRandomNumber(0, 30);
		System.out.println();
		System.out.println("Number is " + number);

		int pivot = findFirstInsertPosition(randomArray, number);
		System.out.println("Pivot Index is " + pivot);
	}

	private static int findFirstInsertPosition(int[] inputArray, int target) {
		int left = 0;
		int right = inputArray.length - 1;
		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (inputArray[middle] > target) {
				right = middle - 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
}
