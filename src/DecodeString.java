import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String sample01 = "3[a]2[bc]";
        // Expected: "aaabcbc"
        String result = decodeString(sample01);
        System.out.println("Result is " + result);
    }

    public static String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> words = new Stack<>();

        int currentCount = 0;
        StringBuilder currentResult = new StringBuilder();

        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                // to prevent multiple digits, e.g. 2135[abc]
                //  e.g. 15, (1) 1, (2) 10 + 5 == 15
                currentCount = (currentCount * 10) + (c - '0');
            } else if (Character.isAlphabetic(c)) {
                currentResult.append(c);
            } else if (c == '[') {
                // Put current saved count and text into Stacks
                counts.push(currentCount);
                words.push(currentResult.toString());

                currentCount = 0;
                currentResult = new StringBuilder();
            } else {
                // c == ']'
                int savedCounts = counts.pop();
                String savedWords = words.pop();
                StringBuilder stringBuilder = new StringBuilder(savedWords);

                int j = 0;
                while (j < savedCounts) {
                    stringBuilder.append(currentResult);
                    j++;
                }
                currentResult = stringBuilder;
            }

            index++;
        }

        return currentResult.toString();
    }
}
