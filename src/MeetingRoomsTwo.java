import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRoomsTwo {

	public static void main(String[] args) {
	}

	public int minMeetingRooms(int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}

		List<Integer> startTimes = new ArrayList<>();
		List<Integer> endTimes = new ArrayList<>();

		for (int[] interval : intervals) {
			startTimes.add(interval[0]);
			endTimes.add(interval[1]);
		}
		Collections.sort(startTimes, (n1, n2) -> n1 - n2);
		Collections.sort(endTimes, (n1, n2) -> n1 - n2);

		int needRooms = 0;
		int maxRooms = 0;

		int start = 0;
		int end = 0;

		while (start < startTimes.size() && end < endTimes.size()) {
			int startTime = startTimes.get(start);
			int endTime = endTimes.get(end);
			if (startTime < endTime) {
				needRooms++;
				start++;
			} else {
				needRooms--;
				end++;
			}
			maxRooms = Math.max(maxRooms, needRooms);
		}
		return maxRooms;
	}

}
