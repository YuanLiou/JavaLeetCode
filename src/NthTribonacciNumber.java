import java.util.HashMap;
import java.util.Map;

public class NthTribonacciNumber {
	Map<Integer, Integer> memo = new HashMap<>();
	public int tribonacci(int n) {
		if (n <= 0) {
			return 0;
		} else if (n <= 2) {
			return 1;
		}

		if (memo.containsKey(n)) {
			return memo.get(n);
		} else {
			var answer = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
			memo.put(n, answer);
			return answer;
		}
	}
}
