import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeModule {
	public static void main(String[] args) {
		var rangeModule = new RangeModule();
		rangeModule.addRange(10, 20);
		rangeModule.removeRange(14, 16);
		var result01 = rangeModule.queryRange(10, 14);
		var result02 = rangeModule.queryRange(13, 15);
		var result03 = rangeModule.queryRange(16, 17);
		System.out.println("Result 01: " + result01); // true
		System.out.println("Result 02: " + result02); // false
		System.out.println("Result 03: " + result03); // true
	}

	// range left..<right
	List<int[]> intervals = new ArrayList<>();
	public RangeModule() {}

	public void addRange(int left, int right) {
		List<int[]> result = new ArrayList<>();
		int[] newIntervals = new int[]{left, right};

		for (int i = 0; i < intervals.size(); i++) {
			int[] currentInterval = intervals.get(i);
			if (newIntervals[1] < currentInterval[0]) {
				result.add(newIntervals);
				for (int j = i; j < intervals.size(); j++) {
					result.add(intervals.get(j));
				}
				this.intervals = result;
				return;
			} else if (newIntervals[0] > currentInterval[1]) {
				result.add(currentInterval);
			} else {
				// overlap
				newIntervals[0] = Math.min(newIntervals[0], currentInterval[0]);
				newIntervals[1] = Math.max(newIntervals[1], currentInterval[1]);
			}
		}
		result.add(newIntervals);
		this.intervals = result;
	}

	public boolean queryRange(int left, int right) {
		if (intervals.isEmpty()) {
			return false;
		}

		// find left index of insertion
		int insertionIndex = Collections.binarySearch(
				intervals,
				new int[]{left, Integer.MAX_VALUE},
				(array1, array2) -> Integer.compare(array1[0], array2[0])
		);

		// Restore the insertion point if the value didn't exist
		if (insertionIndex < 0) {
			insertionIndex = -(insertionIndex + 1); // right index
			if (insertionIndex == 0) {
				return false; // we have no position for it
			} else {
				insertionIndex -= 1; // to left index
			}
		}
		return intervals.get(insertionIndex)[1] >= right;
	}

	public void removeRange(int left, int right) {
		List<int[]> result = new ArrayList<>();
		int[] removeIntervals = new int[]{left, right};
		for (int[] currentInterval : intervals) {
			if (removeIntervals[0] <= currentInterval[0] &&
					removeIntervals[1] >= currentInterval[1]) {
				// 1.) [Remove interval] if the range contains the entire intervals
				// Range > interval
				continue;
			} else if (removeIntervals[0] >= currentInterval[1] ||
					removeIntervals[1] <= currentInterval[0]) {
				// 2.) [Ignore interval]
				// No overlap
				//  the input value is out of bound. Add original value back to the list
				//  because the excluded of the right value we can add 'equals' to compare.
				result.add(currentInterval);

				// 3.) [Modify interval] the input value is overlap the left OR right
			} else if (removeIntervals[0] < currentInterval[0]) {
				// overlap on the left
				result.add(new int[]{removeIntervals[1], currentInterval[1]});
			} else if (removeIntervals[1] > currentInterval[1]) {
				// overlap on the right
				result.add(new int[]{currentInterval[0], removeIntervals[0]});
			} else {
				// 4.) [Split interval]
				// the input value is inside a large interval. The interval should be split.
				result.add(new int[]{currentInterval[0], removeIntervals[0]});
				result.add(new int[]{removeIntervals[1], currentInterval[1]});
			}
		}

		this.intervals = result;
	}
}
