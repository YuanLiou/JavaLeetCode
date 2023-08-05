import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
	public static void main(String[] args) {
	}

	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> wordCounts = new HashMap<>();
		for (int number : arr) {
			if (wordCounts.containsKey(number)) {
				int current = wordCounts.get(number);
				wordCounts.put(number, current + 1);
			} else {
				wordCounts.put(number, 1);
			}
		}

		Set<Integer> finalNums = new HashSet<>(wordCounts.values());
		return finalNums.size() == wordCounts.values().size();
	}
}
