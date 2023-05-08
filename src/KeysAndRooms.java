import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		// [[1,3],[3,0,1],[2],[0]]
		List<Integer> visited = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(0);
		visited.add(0);
		while (!queue.isEmpty()) {
			var roomKey = queue.poll();
			for (Integer key : rooms.get(roomKey)) {
				if (!visited.contains(key)) {
					queue.offer(key);
					visited.add(key);
				}
			}
		}

		return visited.size() == rooms.size();
	}
}
