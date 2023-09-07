import utils.ArrayUtils;

public class RemoveDuplicatesFromSortedArrayTwo {
	public static void main(String[] args) {
		var sampleClass = new RemoveDuplicatesFromSortedArrayTwo();
		// expected = 5
		var sample01 = new int[] {1,1,1,2,2,3};
		var result01 = sampleClass.removeDuplicates(sample01);
		System.out.println();
		System.out.println("Result is " + result01);

		// expected = 7
		var sample02 = new int[]{0,0,1,1,1,1,2,3,3};
		var result02 = sampleClass.removeDuplicates(sample02);
		System.out.println();
		System.out.println("Result2 is " + result02);
	}
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int result = 1;
		int counts = 0;
		int previous = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			int current = nums[i];
			if (current == previous) {
				counts++;

				if (counts > 1) {
					swap(nums, i);
					counts--;
					result--;
				}
			} else {
				counts = 0;
			}
			result++;
			previous = current;
		}
		ArrayUtils.printArray(nums);
		return result;
	}

	private void swap(int[] nums, int target) {
		int start = target + 1;
		while (start < nums.length) {
			nums[target] = nums[start];
			target++;
			start++;
		}
	}
}
