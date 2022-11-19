import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoArrays {
	public static void main(String[] args) {
	}

	// Time: worst O(m + n)
	// Space: O(m + contains)
	public int[] intersection(int[] nums1, int[] nums2) {
		int[] largerArray;
		int[] smallerArray;
		if (nums1.length > nums2.length) {
			largerArray = nums1;
			smallerArray = nums2;
		} else {
			largerArray = nums2;
			smallerArray = nums1;
		}

		Set<Integer> largerSet = new HashSet<Integer>();
		for (int number : largerArray) {
			largerSet.add(number);
		}

		Set<Integer> resultSet = new HashSet<Integer>();
		for (int number : smallerArray) {
			if (largerSet.contains(number)) {
				resultSet.add(number);
			}
		}

		int[] result = new int[resultSet.size()];
		int i = 0;
		for (int number : resultSet) {
			result[i] = number;
			i++;
		}
		return result;
	}
}
