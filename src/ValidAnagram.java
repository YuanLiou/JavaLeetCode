import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidAnagram {
    public static void main(String[] args) {
//        "anagram"
//        "nagaram"
//        "rat"
//        "car"
//        String input = "anagram";
//        String output = "nagaram";
        String input = "rat";
        String output = "car";
        boolean isAnagram = isAnagram(input, output);
        System.out.println("isAnagram? = " + isAnagram);
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
