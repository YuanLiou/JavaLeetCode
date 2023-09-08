import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public static void main(String[] args) {
	}

	public int majorityElement(int[] nums) {
		int n = nums.length / 2;
		Map<Integer, Integer> counts = new HashMap<>();
		for (int number : nums) {
			int currentCount = counts.getOrDefault(number, 0);
			if (currentCount + 1 > n) {
				return number;
			}
			counts.put(number, currentCount + 1);
		}
		return 0;
	}
}
