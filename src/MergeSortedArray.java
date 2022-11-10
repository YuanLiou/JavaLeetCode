import java.util.Arrays;

import utils.ArrayUtils;

public class MergeSortedArray {
	public static void main(String[] args) {
		var sampleClass = new MergeSortedArray();

		// expected: [1, 2, 2, 3, 5, 6]
		var example01A = new int[]{1, 2, 3, 0, 0, 0};
		var example02B = new int[]{2, 5, 6};
		var examplem1 = 3;
		var examplem2 = 3;

		sampleClass.merge02(example01A, examplem1, example02B, examplem2);
		ArrayUtils.printArray(example01A);
	}

	// Brute force
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        // put the n array in position m
		var current = m;
		for (int number : nums2) {
			nums1[current] = number;
			current++;
		}
		Arrays.sort(nums1);
    }

	// Brute force
	public void merge02(int[] nums1, int m, int[] nums2, int n) {
		int insertedIndex = (m + n) - 1;
		int currentM = m - 1;
		int currentN = n - 1;
		while (currentM >= 0 && currentN >= 0) {
			if (nums1[currentM] > nums2[currentN]) {
				// M > N
				nums1[insertedIndex] = nums1[currentM];
				currentM--;
			} else {
				// M <= N
				nums1[insertedIndex] = nums2[currentN];
				currentN--;
			}

			insertedIndex--;
		}

		// We should make sure all numbers in nums2 has been iterated.
		while (currentN >= 0) {
			nums1[insertedIndex] = nums2[currentN];
			currentN--;
			insertedIndex--;
		}
	}
}
