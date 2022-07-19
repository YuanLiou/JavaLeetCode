public class LongestCommonPrefix {
    public static void main(String[] args) {
        var sample01 = new String[]{"flower", "flow", "flight"};
        var sample02 = new String[]{"dog","racecar","car"};
        var sample03 = new String[]{"aaa", "aa", "aaa"};
        var result = longestCommonPrefix(sample03);
        System.out.println("Result is " + result);
    }

    public static String longestCommonPrefix(String[] strs) {

        StringBuilder stringBuilder = new StringBuilder();
        int maxInnerLength = 200;
        for (int i = 0; i <= maxInnerLength; i++) {

            char currentCharacter = 0;
            for (int j = 0; j < strs.length; j++) {
                String innerString = strs[j];
                if (i >= innerString.length()) {
                    return stringBuilder.toString();
                } else if (i == 0) {
                    if (j == 0) {
                        maxInnerLength = innerString.length();
                    } else {
                        maxInnerLength = Math.max(innerString.length(), maxInnerLength);
                    }
                }

                if (j == 0) {
                    currentCharacter = innerString.charAt(i);
                } else {
                    if (innerString.charAt(i) != currentCharacter) {
                        return stringBuilder.toString();
                    }
                }

                if (j == strs.length - 1) {
                    stringBuilder.append(currentCharacter);
                }
            }
        }
        return stringBuilder.toString();
    }
}
