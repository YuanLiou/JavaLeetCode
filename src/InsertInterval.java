import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public static void main(String[] args) {
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();

		for (int i = 0; i < intervals.length; i++) {
			int[] currentInterval = intervals[i];
			// 1.) The new interval is at the start of the result
			if (newInterval[1] < currentInterval[0]) {
				result.add(newInterval);
				for (int j = i; j < intervals.length; j++) {
					result.add(intervals[j]);
				}
				return result.toArray(new int[result.size()][]);
			} else if (currentInterval[1] < newInterval[0]) {
				// 2.) The new interval is at the end of the result
				//  we basically build it normally then add it to the list
				//  after we leave the loop
				result.add(currentInterval);
			} else {
				// 3.) There is an overlap, we can stretch the newInterval everytime
				//   update the smaller left bound to the new interval
				//   update the larger right bound to the new interval
				newInterval[0] = Math.min(newInterval[0], currentInterval[0]);
				newInterval[1] = Math.max(newInterval[1], currentInterval[1]);
			}
		}

		result.add(newInterval); // we add it after we leave the loop
		return result.toArray(new int[result.size()][]);
	}
}
