import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	public static void main(String[] args) {
		var sampleClass = new IsomorphicStrings();
		var sample01 = "foo";
		var sample02 = "bar";
		var result = sampleClass.isIsomorphic(sample01, sample02);
		System.out.println("Result is " + result);

	}

	public boolean isIsomorphic(String s, String t) {
		String convertedS = convertToNumber(s);
		String convertedT = convertToNumber(t);
		return convertedS.equals(convertedT);
	}

	private String convertToNumber(String input) {
		Map<Character, Integer> mapper = new HashMap<>();
		StringBuilder stringBuilder = new StringBuilder();
		char[] chars = input.toCharArray();
		int i = 0;
		int j = 1;
		while (i < chars.length) {
			char current = chars[i];
			if (mapper.containsKey(current)) {
				int value = mapper.get(current);
				stringBuilder.append(value);
			} else {
				int value = ++j;
				mapper.put(current, value);
				stringBuilder.append(value);
			}
			i++;
		}
		return stringBuilder.toString();
	}
}
