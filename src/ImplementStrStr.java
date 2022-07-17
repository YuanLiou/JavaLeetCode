public class ImplementStrStr {
    public static void main(String[] args) {
        var sample01 = "hello";
        var answer01 = "ll";
        var sample02 = "aaaaa";
        var answer02 = "bba";
        // expected: 4
        var sample03 = "mississippi";
        var answer03 = "issip";
        var result = strStr(sample02, answer02);
        System.out.println("This is the result " + result);
    }

    public static int strStr(String haystack, String needle) {
        // base case
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        // is needle in the haystack?
        var haystackArray = haystack.toCharArray();
        var needleArray = needle.toCharArray();

        int leftBounds = 0;
        int rightBounds = needleArray.length - 1;
        int needleIndex = 0;

        while (rightBounds < haystackArray.length) {
            for (int i = leftBounds; i <= rightBounds; i++) {
                if (haystackArray[i] != needleArray[needleIndex]) {
                    needleIndex = 0;
                    break;
                }
                needleIndex++;
            }

            if (needleIndex == needleArray.length) {
                return leftBounds;
            }

            leftBounds++;
            rightBounds++;
        }
        
        return -1;
    }

    // 這種作法經不起考驗，例如："mississippi", find: "issip"
    public static int strStrFailed(String haystack, String needle) {
        // base case
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        // is needle in the haystack?
        var haystackArray = haystack.toCharArray();
        var needleArray = needle.toCharArray();

        int startedIndex = -1;
        int matchedIndex = 0;
        for (int i = 0; i < haystackArray.length; i++) {
            if (haystackArray[i] == needleArray[matchedIndex]) {
                matchedIndex++;

                if (startedIndex == -1) {
                    startedIndex = i;
                }
            } else {
                startedIndex = -1;
                matchedIndex = 0;
            }

            if (matchedIndex == needleArray.length) {
                break;
            }
        }

        return startedIndex;
    }
}
