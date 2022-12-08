import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysTwo {
	public static void main(String[] args) {
		var sampleClass = new IntersectionOfTwoArraysTwo();
		var sample01 = new int[]{1, 2, 2, 1};
		var sample01_1 = new int[]{2, 2};
		// Expect: [2, 2]
		var result = sampleClass.intersect(sample01, sample01_1);
		ArrayUtils.printArray(result);
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> result = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0; // index for nums1
		int j = 0; // index for nums2
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] > nums2[j]) {
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				// they are equal
				result.add(nums1[i]);
				i++;
				j++;
			}
		}

		int[] resultArray = new int[result.size()];
		for (int index = 0; index < result.size(); index++) {
			resultArray[index] = result.get(index);
		}
		return resultArray;
	}
}
