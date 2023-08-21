import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsThree {
	public static void main(String[] args) {
	}

	private record MeetingEnd(int endTime, int roomIndex) {}
	public int mostBooked(int n, int[][] meetings) {
		int[] counts = new int[n];
		Arrays.fill(counts, 0);

		PriorityQueue<Integer> meetingRooms = new PriorityQueue<>(); // small to large
		PriorityQueue<MeetingEnd> runningMeetings = new PriorityQueue<>(
				(meetingEnd1, meetingEnd2) -> {
					// 如果結束時間一樣
					if (meetingEnd1.endTime == meetingEnd2.endTime) {
						// 照會議室的順序排列
						return meetingEnd1.roomIndex - meetingEnd2.roomIndex;
					}
					// 照結束時間排列
					return meetingEnd1.endTime - meetingEnd2.endTime;
				}
		);

		// Sort the meeting small to large by its start time
		Arrays.sort(meetings, (nums01, nums02) -> Integer.compare(nums01[0], nums02[0]));

		// Fill up the meeting room
		for (int i = 0; i < n; i++) {
			meetingRooms.offer(i);
		}

		// Walkthrough all meetings
		for (int[] meeting : meetings) {
			// 檢查目前 Running Meeting 的結束時間，是否已經比目前 Meeting 的開始時間還要早。
			while (!runningMeetings.isEmpty() && runningMeetings.peek().endTime <= meeting[0]) {
				// 前一場會議已經結束
				MeetingEnd meetingEnd = runningMeetings.poll();
				// 歸還會議室
				meetingRooms.offer(meetingEnd.roomIndex);
			}

			int initialTime = meeting[0]; // 目前 meeting 的 startTime

			// 可能沒會議，或是有會議但目前的 Meeting 還沒結束
			if (meetingRooms.isEmpty()) {
				// 沒有會議室了
				MeetingEnd runningMeeting = runningMeetings.poll();
				if (runningMeeting != null) {
					initialTime = runningMeeting.endTime; // StartTime 會變成最近一個會議結束時間
					meetingRooms.offer(runningMeeting.roomIndex); // 未來歸還？
				}
			}

			Integer roomIndex = meetingRooms.poll(); // 佔用一個會議室
			if (roomIndex != null) {
				runningMeetings.offer(new MeetingEnd(
						initialTime + (meeting[1] - meeting[0]),
						roomIndex
				));
				counts[roomIndex] += 1;
			}
		}

		// 回傳用的最多次的會議室的 Index。如果最多次的會議室很多個，則回傳 Index 最小的那個
		int mostUsedIndex = 0;
		for (int i = 0; i < n; i++) {
			int current = counts[i];
			int mostOne = counts[mostUsedIndex];
			if (current > mostOne) {
				mostUsedIndex = i;
			}
		}
		return mostUsedIndex;
	}
}
