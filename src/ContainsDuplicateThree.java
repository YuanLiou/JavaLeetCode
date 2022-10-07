import java.util.TreeSet;

public class ContainsDuplicateThree {
	public static void main(String[] args) {
	}

	// solution01: Brute Force
	public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
		int currentIndex = 0;
		while (currentIndex < nums.length) {
			int exploreIndex = currentIndex + 1;

			while (exploreIndex < nums.length && Math.abs(currentIndex - exploreIndex) <= indexDiff) {
				if (Math.abs(nums[currentIndex] - nums[exploreIndex]) <= valueDiff) {
					return true;
				}
				exploreIndex++;
			}

			currentIndex++;
		}
		return false;
	}

	// solution02: TreeSet
	// Time complexity = O(nLogn). It is because TreeSet is a data structure based on Binary Search Tree
	//                   time complexity would be O(h) = height, aka. O(logn). We do n times (in for loop)
	// Space complexity = O(indexDiff)
	public boolean containsNearbyAlmostDuplicate02(int[] nums, int indexDiff, int valueDiff) {
		// to prevent leak, we use long
		// e.g. 1. INTEGER.MAX_VALUE, 2. -INTEGER.MAX_VALUE, when 1. - (-2.) it will leak.
		TreeSet<Long> numberSet = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {
			Long currentNumber = (long) nums[i];
			// 1.) Find the one who is slightly larger than current number (the smallest on the right tree)
			Long candidateNumber01 = numberSet.ceiling(currentNumber);
			if (candidateNumber01 != null && Math.abs(currentNumber - candidateNumber01) <= valueDiff) {
				return true;
			}

			// 2.) Find the one who is slightly smaller than current number (the largest on the left tree)
			Long candidateNumber02 = numberSet.floor(currentNumber);
			if (candidateNumber02 != null && Math.abs(currentNumber - candidateNumber02) <= valueDiff) {
				return true;
			}

			// 3.) Put value into the collection
			numberSet.add(currentNumber);

			// 4.) Modify the collection size to fit indexDiff
			if (numberSet.size() > indexDiff) {
				// 5.) Remove the first item of the collection
				numberSet.remove((long) nums[i - indexDiff]);
			}
		}

		return false;
	}
}
