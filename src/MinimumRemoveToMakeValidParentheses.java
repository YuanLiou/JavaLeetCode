public class MinimumRemoveToMakeValidParentheses {
	public static void main(String[] args) {
		var sampleClass = new MinimumRemoveToMakeValidParentheses();
		var result = sampleClass.minRemoveToMakeValid("))((");
		System.out.println("Result is " + result);

		var result02 = sampleClass.minRemoveToMakeValid("a)b(c)d");
		System.out.println("Result is " + result02);
	}

	public String minRemoveToMakeValid(String s) {
		StringBuilder removeUnexpectedRightOne = filterParentheses(s, '(', ')');
		StringBuilder removeUnexpectedLeftOne = filterParentheses(
				removeUnexpectedRightOne.reverse().toString(),
				')',
				'('
		);
		return removeUnexpectedLeftOne.reverse().toString();
	}

	private StringBuilder filterParentheses(String text, char open, char closed) {
		StringBuilder stringBuilder = new StringBuilder();
		int matched = 0;
		for (int i = 0; i < text.length(); i++) {
			char current = text.charAt(i);
			if (current == open) {
				matched++;
			} else if (current == closed) {
				if (matched == 0) {
					// no pair
					continue;
				}

				matched--;
			}
			stringBuilder.append(current);
		}
		return stringBuilder;
	}
}
