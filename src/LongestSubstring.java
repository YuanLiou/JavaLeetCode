public class LongestSubstring {
    public static void main(String[] args) {
        var sample01 = "abcabcbb";
        var sample02 = "bbbbb";
        var sample03 = "pwwkew";

        // 00. Edge case? corner case?
        //  a. 最後一個不重要
        //  b. " " and ""
        // SlidingWindows, two pointer
        var size = lengthOfLongestSubstring(sample03);
        System.out.println("result is " + size);
    }

    // brute force
    public static int lengthOfLongestSubstring(String s) {
        Integer[] charIndexs = new Integer[128];

        int leftBound = 0;
        int rightBound = 0;

        int result = 0;

        while (rightBound < s.length()) {
            char currentChar = s.charAt(rightBound);
            Integer index = charIndexs[currentChar];
            // index != null means it has previous value
            if (index != null && index >= leftBound && index < rightBound) {
                leftBound = index + 1;
            }

            result = Math.max(result, rightBound - leftBound + 1);

            charIndexs[currentChar] = rightBound;
            rightBound++;
        }
        return result;
    }

    public static int lengthOfLongestSubstring2(String s) {
        Integer[] charIndexs = new Integer[128];

        int leftBound = 0;
        int rightBound = 0;

        int res = 0;
        while (rightBound < s.length()) {
            char r = s.charAt(rightBound);

            Integer index = charIndexs[r];
            if (index != null && index >= leftBound && index < rightBound) {
                leftBound = index + 1;
            }

            res = Math.max(res, rightBound - leftBound + 1);

            charIndexs[r] = rightBound;
            rightBound++;
        }

        return res;
    }
}
