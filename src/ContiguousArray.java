import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public static void main(String[] args) {
		var sampleClass = new ContiguousArray();
		// expected: 6
		var sampleInput = new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1};
		var result01 = sampleClass.findMaxLength(sampleInput);
		System.out.println("Result 01 is " + result01);
	}

	public int findMaxLength(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}

		Map<Integer, Integer> counterToIndexMap = new HashMap<>();
		counterToIndexMap.put(0, -1);
		int counter = 0;
		int maxLength = 0;

		for (int i = 0; i < nums.length; i++) {
			int current = nums[i];
			if (current == 0) {
				counter++;
			} else {
				counter--;
			}

			if (counterToIndexMap.containsKey(counter)) {
				int previousRecordIndex = counterToIndexMap.get(counter);
				// currentIndex - previousRecordIndex == length
				maxLength = Math.max(maxLength, i - previousRecordIndex);
			} else {
				counterToIndexMap.put(counter, i);
			}
		}
		return maxLength;
	}
}
