import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidAnagram {
    public static void main(String[] args) {
//        "anagram"
//        "nagaram"
//        "rat"
//        "car"
        String input01 = "anagram";
        String output01 = "nagaram";
        String input02 = "rat";
        String output02 = "car";

        boolean isAnagram = isAnagram02(input02, output02);
        System.out.println("isAnagram? = " + isAnagram);
    }

    private static boolean isAnagram02(String input01, String input02) {
        // Edge case
        if (input01.length() != input02.length()) {
            return false;
        }

        // Change to Java's charArray: char[]
        // Basically char is a representation of ASCII code (it's int)
        // Sort both with Arrays.sort

        char[] chars01 = input01.toCharArray();
        char[] chars02 = input02.toCharArray();
        Arrays.sort(chars01);
        Arrays.sort(chars02);
        return Arrays.equals(chars01, chars02);
    }

    public static boolean isAnagram(String s, String t) {
        // early return 長度不同，ㄧ定不是
        // early return 長度一樣，是否一樣？
        // 取出字母
        // 將字母塞到 List 裡頭
        // 依序刪除另一個 List 內的字
        // 最後長度是零即為 true
        if (s.length() != t.length()) {
            return false;
        }

        if (s.length() == 1 && t.length() == 1) {
            return s.equals(t);
        }

        var sChars = extractedCharacters(s);
        var tChars = extractedCharacters(t);
        for (String character : sChars) {
            tChars.remove(character);
        }
        return tChars.isEmpty();
    }

    private static List<String> extractedCharacters(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(String.valueOf(s.charAt(i)));
        }
        return result;
    }
}
