import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        var testcase01 = "{[]}";
        var result = isValid(testcase01);
        System.out.println("Result is " + result);
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
