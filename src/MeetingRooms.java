import java.util.Arrays;

public class MeetingRooms {
	public static void main(String[] args) {
	}

	public boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(
			intervals,
			(num1, num2) -> num1[0] - num2[0]
		);

		for (int i = 0; i < intervals.length - 1; i++) {
			var firstTail = intervals[i][1];
			var secondHead = intervals[i + 1][0];
			if (firstTail > secondHead) {
				return false;
			}
		}
		return true;
	}
}
