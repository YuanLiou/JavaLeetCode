import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
	public static void main(String[] args) {
		var sampleClass = new ClimbingStairs();
		var result = sampleClass.climbStairs(5);
		System.out.println("Result is " + result);
	}

	Map<Integer, Integer> cached = new HashMap<>();
	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}

		if (cached.containsKey(n)) {
			return cached.get(n);
		}

		var result = climbStairs(n - 1) + climbStairs(n - 2);
		cached.putIfAbsent(n, result);
		return result;
	}

	public int climbStairsIterative(int n) {
		int i = 0;
		int firstNumber = 0;
		int secondNumber = 1;

		while (i < n) {
			int nextNumber = firstNumber + secondNumber;
			firstNumber = secondNumber;
			secondNumber = nextNumber;

			i++;
		}
		return secondNumber;
	}
}
