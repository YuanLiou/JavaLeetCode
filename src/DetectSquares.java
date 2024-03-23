import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {

	public static void main(String[] args) {
	}

	/**
	 * Your DetectSquares object will be instantiated and called as such: DetectSquares obj = new
	 * DetectSquares(); obj.add(point); int param_2 = obj.count(point);
	 */

	private final Map<String, Integer> counts = new HashMap<>();
	private final List<int[]> points = new ArrayList<>();
	public DetectSquares() {}

	public void add(int[] point) {
		String key = point[0] + ":" + point[1];
		points.add(point);
		counts.put(key, counts.getOrDefault(key, 0) + 1);
	}

	// 找到對角線的點
	//  1. 找到對角線
	//  2. 找到剩下兩個點
	//  3. 檢查他的次數
	public int count(int[] point) {
		int result = 0;
		int inputX = point[0];
		int inputY = point[1];

		for (int[] currentPoint : points) {
			int currentX = currentPoint[0];
			int currentY = currentPoint[1];

			// 找對角線 && 不能是同一點
			if (Math.abs(inputX - currentX) != Math.abs(inputY - currentY) || (inputX == currentX && inputY == currentY)) {
				continue;
			}

			// 找剩下的那兩個點
			String topLeftPoint = currentX + ":" + inputY;
			String bottomRightPoint = inputX + ":" + currentY;
			result +=
				counts.getOrDefault(topLeftPoint, 0) * counts.getOrDefault(bottomRightPoint, 0);
		}
		return result;
	}
}
