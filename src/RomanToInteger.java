import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public static void main(String[] args) {
		var sampleClass = new RomanToInteger();
		var sampleInput01 = "MXXIIII";
		// Expect
		var result01 = sampleClass.romanToInt(sampleInput01);
		System.out.println("Result is " + result01);
	}

	public int romanToInt(String s) {
		Map<String, Integer> numberMap = new HashMap<>();
		numberMap.put("I", 1);
		numberMap.put("V", 5);
		numberMap.put("X", 10);
		numberMap.put("L", 50);
		numberMap.put("C", 100);
		numberMap.put("D", 500);
		numberMap.put("M", 1000);

		var result = 0;
		for (int i = 0; i < s.length(); i++) {
			String charcter = String.valueOf(s.charAt(i));
			int currentValue = numberMap.get(charcter);
			int nextIndex = i + 1;
			if (nextIndex < s.length()) {
				String nextCharcter = String.valueOf(s.charAt(nextIndex));
				int nextValue = numberMap.get(nextCharcter);
				if (currentValue < nextValue) {
					currentValue *= -1;
				}
			}
			result += currentValue;
		}
		return result;
	}
}
