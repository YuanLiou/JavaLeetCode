import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public static void main(String[] args) {
		// [1, 3], [2, 6], [8, 10], [15, 18], length = 4
		// result = [1, 6], [8, 10], [15, 18]
		//  CI = [15, 18], firE = 6
		//  interval = [15, 18], secSta = 15, secEnd = 18
	}

	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (array1, array2) -> Integer.compare(array1[0], array2[0]));
		List<int[]> result = new ArrayList<>();

		int[] currentInterval = intervals[0];
		result.add(currentInterval);

		for (int i = 1; i < intervals.length; i++) {
			int[] interval = intervals[i];

			int firstEnd = currentInterval[1];
			int secondStart = interval[0];
			int secondEnd = interval[1];

			if (secondStart <= firstEnd) {
				int endValue = Math.max(firstEnd, secondEnd);
				currentInterval[1] = endValue;
			} else {
				currentInterval = interval;
				result.add(interval);
			}
		}
		return result.toArray(new int[result.size()][]);
	}
}
