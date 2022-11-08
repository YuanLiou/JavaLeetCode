import java.util.Arrays;

public class MergeSortedArray {
	public static void main(String[] args) {
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
}
