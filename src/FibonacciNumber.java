import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
	public static void main(String[] args) {
		var sampleClass = new FibonacciNumber();
		var result = sampleClass.fibInterrative(9);
		System.out.println("Result is " + result);
	}

	// Recursive
	Map<Integer, Integer> cahced = new HashMap<Integer, Integer>();
	public int fib(int n) {
		if (n <= 1) {
			return n;
		}

		if (cahced.containsKey(n)) {
			return cahced.get(n);
		}
		
		int result = fib(n - 1) + fib(n - 2);
		cahced.putIfAbsent(n, result);
		return result;
	}

	public int fibInterrative(int n) {
		if (n <= 1) {
			return n;
		}

		int i = 1;
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
