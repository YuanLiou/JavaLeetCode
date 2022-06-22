import java.util.Arrays;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        var sample01 = "babad";
        var sample02 = "cbbd";
        String result = longestPalindrome(sample02);
        System.out.println("Result is " + result);
    }

    public static String longestPalindrome(String s) {
        // Use a memo to store if there is a palindrome in the substring.
        // base case is:
        //  1. a character is a palindrome.
        //  2. two character should be compared, if they are the same, it's a palindrome.
        // otherwise:
        // [a][palindrome][b] ==> means we found a palindrome. the center of the [palindrome] section,
        // we can check the memo to see the previous check.
        // memo[startPoint][endPoint]

        // edge case
        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLength = 0;
        String result = "";
        boolean[][] memo = new boolean[s.length()][s.length()];

        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            for (int startIndex = 0; startIndex <= endIndex; startIndex++) {

                boolean isPalindrome = s.charAt(startIndex) == s.charAt(endIndex);

                // Base case is:
                //  1. A single character is a palindrome.
                //  2. Two character should be compared, if they are the same, it's a palindrome.
                // Otherwise: above three characters-- length > 2
                // [A][Palindrome][B] ==> means we found a palindrome. The center of the [Palindrome] section,

                memo[startIndex][endIndex] = endIndex - startIndex > 2 ?
                        (memo[startIndex + 1][endIndex - 1] && isPalindrome) : isPalindrome;

                // Update the max value
                if (memo[startIndex][endIndex] && endIndex - startIndex + 1 > maxLength) {
                    maxLength = endIndex - startIndex + 1;
                    result = s.substring(startIndex, endIndex + 1);
                }
            }
        }

        return result;
    }
}
