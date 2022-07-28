public class ReverseWordsInString {
    public static void main(String[] args) {
        var sample01 = "the sky is blue";
        var sample02 = "  hello world  ";
        var sample03 = "a good   example";
        String result = reverseWords(sample03);
        System.out.println("Result is " + result);
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        // Trim the leading or trailing spaces, replace all multiple space in a string
        s = s.trim().replaceAll(" +", " ");

        // Reverse the whole strings
        char[] charArray = s.toCharArray();
        reverse(charArray, 0, s.length() - 1);

        // Reverse each Strings
        int j = -1;
        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];
            if (currentChar != ' ') {
                if (j == -1) {
                    j = i;
                }
            } else {
                if (j != -1) {
                    reverse(charArray, j, i - 1);
                    j = -1;
                }
            }

            if (i == charArray.length - 1 && currentChar != ' ') {
                reverse(charArray, j, charArray.length - 1);
            }
        }

        return String.valueOf(charArray);
    }

    private static void reverse(char[] charArray, int startPoint, int endPoint) {
        while (startPoint < endPoint) {

            swap(charArray, startPoint, endPoint);

            startPoint++;
            endPoint--;
        }
    }

    private static void swap(char[] chars, int startPosition, int endPosition) {
        char temp = chars[startPosition];
        chars[startPosition] = chars[endPosition];
        chars[endPosition] = temp;
    }
}
