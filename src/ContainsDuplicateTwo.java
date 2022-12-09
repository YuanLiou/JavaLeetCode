import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateTwo {

	public static void main(String[] args) {
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> indexMapping = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int currentNumber = nums[i];
			if (indexMapping.containsKey(currentNumber)) {
				int previousIndex = indexMapping.get(currentNumber);
				if (Math.abs(i - previousIndex) <= k) {
					return true;
				} else {
					indexMapping.put(currentNumber, i);
				}
			} else {
				indexMapping.put(currentNumber, i);
			}
		}
		return false;
	}
}
