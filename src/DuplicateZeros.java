import java.lang.reflect.Array;
import utils.ArrayUtils;

public class DuplicateZeros {
	public static void main(String[] args) {
		var sampleClass = new DuplicateZeros();
		// Expected: 1,0,0,2,3,0,0,4
		var example01 = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
		sampleClass.duplicateZeros(example01);
		ArrayUtils.printArray(example01);
	}

	public void duplicateZeros(int[] arr) {
		// 1.) Counts Zeros
		int zeroCounts = 0;
		for (int number : arr) {
			if (number == 0) {
				zeroCounts++;
			}
		}

		// 2.) Two pointer: i and j. i = arrayLength - 1, j = arrayLength - 1 + ZeroCounts
		int i = arr.length - 1;
		int j = (arr.length - 1) + zeroCounts;

		j--;

		// 3.) Until i meets j or i <= 0 (i must > 0)
		while (i > 0 && j >= i) {
			// 4.) if meet 0, copy twice
			if (arr[i] == 0) {
				if (j < arr.length) {
					arr[j] = arr[i];

					j--;
					arr[j] = arr[i];
				}
				j--;
				i--;

				continue;
			}

			// 5.) copy the value from i position to j position, if j is out of bound ignore and j--
			if (j < arr.length) {
				arr[j] = arr[i];
			}
			j--;
			i--;
		}
	}

}
