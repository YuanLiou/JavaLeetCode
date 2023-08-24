import java.util.Stack;

public class RemoveKDigits {
	public static void main(String[] args) {
	}

	public String removeKdigits(String num, int k) {
		if (num.length() == k) {
			return "0";
		}

		Stack<Character> numberStack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < num.length(); i++) {
			// Main Logic for this question.
			while (k > 0 && !numberStack.isEmpty() && numberStack.peek() > num.charAt(i)) {
				numberStack.pop();
				k--;
			}
			
			char current = num.charAt(i);
			numberStack.push(current);
		}

		while (k > 0) {
			numberStack.pop();
			k--;
		}

		// 注意這個 while，不能用 for
		while (!numberStack.isEmpty()) {
			sb.append(numberStack.pop());
		}
		sb.reverse();

		// if there are leading zeros: e.g. "000321"
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}

		String result = sb.toString();
		if (result.isEmpty()) {
			return "0";
		}
		return result;
	}
}
