import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
	public static void main(String[] args) {
	}

	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		// space complexity: O(n)
		if (schedule.size() == 1) {
			return Collections.emptyList();
		}

		List<Interval> workTimes = new ArrayList<>();
		for (int i = 0; i < schedule.size(); i++) {
			List<Interval> current = schedule.get(i);
			for (Interval interval : current) {
				workTimes.add(interval);
			}
		}
		// time complexity: n log (n)
		Collections.sort(workTimes, (l1, l2) -> l1.start - l2.start);

		List<Interval> merged = new ArrayList<>();
		var leftBoundInterval = workTimes.get(0);
		merged.add(leftBoundInterval);
		for (int i = 1; i < workTimes.size(); i++) {
			var currentInterval = workTimes.get(i);
			var leftBoundEnd = leftBoundInterval.end;
			var currentStart = currentInterval.start;
			var currentEnd = currentInterval.end;
			if (leftBoundEnd >= currentStart) {
				var newEnd = Math.max(leftBoundEnd, currentEnd);
				leftBoundInterval.end = newEnd;
			} else {
				leftBoundInterval = currentInterval;
				merged.add(leftBoundInterval);
			}
		}

		List<Interval> result = new ArrayList<>();
		int i = 0;
		int j = i + 1;
		while (j < merged.size()) {
			var firstInterval = merged.get(i);
			var firstEnd = firstInterval.end;
			var secondInterval = merged.get(j);
			var secondStart = secondInterval.start;
			result.add(new Interval(firstEnd, secondStart));
			i++;
			j++;
		}

		return result;
	}
}

class Interval {
	public int start;
	public int end;

	public Interval() {}

	public Interval(int _start, int _end) {
		start = _start;
		end = _end;
	}
};
