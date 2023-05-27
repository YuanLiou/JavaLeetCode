import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteAndEarn {
	public static void main(String[] args) {
	}

	public int deleteAndEarn(int[] nums) {
		//region generate sorted deduped List
		Map<Integer, Integer> countMap = new HashMap<>();
		for (Integer number : nums) {
			if (countMap.containsKey(number)) {
				countMap.put(number, countMap.get(number) + 1);
			} else {
				countMap.put(number, 1);
			}
		}
		List<Integer> dedupedNums = new ArrayList<>(countMap.keySet());
		Collections.sort(dedupedNums);
		//endregion

		int earn01 = 0;
		int earn02 = 0;
		for (int i = 0; i < dedupedNums.size(); i++) {
			if (i > 0 && dedupedNums.get(i) == dedupedNums.get(i - 1) + 1) {
				// Condition: current number will be same if previous number + 1
				//  we can only pick one of them. [current + previous and previous one] OR [previous one]
				int pickedSelf = dedupedNums.get(i) * countMap.get(dedupedNums.get(i)) + earn01;
				int current = Math.max(pickedSelf, earn02);
				earn01 = earn02;
				earn02 = current;
			} else {
				// Condition: current number will NOT be same if previous number + 1
				//  we can pick current and previous one
				int current = dedupedNums.get(i) * countMap.get(dedupedNums.get(i)) + earn02;
				earn01 = earn02;
				earn02 = current;
			}
		}
		return earn02;
	}
}
