import java.util.*;

public class MinimumIndexSumOfTwoLists {
	public static void main(String[] args) {
	}

	private record ResultPair(String value, int indexSum) {}

	public String[] findRestaurant(String[] list1, String[] list2) {
		String[] largerArray;
		String[] smallerArray;
		if (list1.length > list2.length) {
			smallerArray = list2;
			largerArray = list1;
		} else {
			smallerArray = list1;
			largerArray = list2;
		}

		List<ResultPair> results = new ArrayList<>();
		List<String> wordsPool = Arrays.stream(largerArray).toList();
		for (int i = 0; i < smallerArray.length; i++) {
			String current = smallerArray[i];
			int index = wordsPool.indexOf(current);
			if (index != -1) {
				int sumOfIndex = index + i;

				if (results.isEmpty()) {
					results.add(new ResultPair(current, sumOfIndex));
				} else {
					var previous = results.get(0);
					if (previous.indexSum > sumOfIndex) {
						results.clear();
						results.add(new ResultPair(current, sumOfIndex));
					} else if (previous.indexSum == sumOfIndex) {
						results.add(new ResultPair(current, sumOfIndex));
					}
				}
			}
		}

		String[] resultArray = new String[results.size()];
		for (int i = 0; i < results.size(); i++) {
			resultArray[i] = results.get(i).value;
		}
		return resultArray;
	}
}
