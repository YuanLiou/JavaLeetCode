import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		var testcase01 = "{[]}";
		var result = isValid(testcase01);
		System.out.println("Result is " + result);
	}


	public static boolean isValid02(String s) {
		if (s.length() == 1) {
			return false;
		}
		var textMap = new HashMap<String, String>();
		textMap.put("(", ")");
		textMap.put("{", "}");
		textMap.put("[", "]");

		Stack<String> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			String current = String.valueOf(s.charAt(i));
			if (textMap.values().contains(current)) {
				if (!stack.isEmpty()) {
					String topText = stack.peek();
					if (textMap.containsKey(topText)) {
						String parenntheses = textMap.get(topText);
						if (current.equals(parenntheses)) {
							stack.pop();
							continue;
						}
					}
				}
			}
			stack.push(current);
		}
		return stack.isEmpty();
	}

	public static boolean isValid(String s) {
		// base case
		if (s == null || s.length() == 0 || s.length() % 2 != 0) {
			return false;
		}

		Map<Character, Character> matchedMap = new HashMap<>();
		matchedMap.put(')', '(');
		matchedMap.put(']', '[');
		matchedMap.put('}', '{');

		Stack<Character> selectedChars = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (selectedChars.size() == 0) {
				selectedChars.push(currentChar);
				continue;
			}

			char currentInStackChar = selectedChars.peek();
			Character parentheses = matchedMap.get(currentChar);
			if (parentheses != null && currentInStackChar == parentheses) {
				selectedChars.pop();
			} else {
				selectedChars.push(currentChar);
			}
		}
		return selectedChars.isEmpty();
	}
}
