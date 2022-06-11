import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s1 = "ab#c";
        String t1 = "ad#c";
        String s2 = "ab##";
        String t2 = "c#d#";
        String s3 = "a#c";
        String t3 = "b";
        String s4 = "y#fo##f";
        String t4 = "y#f#o##f";
        var result = backspaceCompare(s4, t4);
        System.out.println("Result is " + result);
    }

    public static boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        
        // 建立兩個新變數 sChars 和 tChars
        // 遍歷 s 和 t
        // 利用 StringBuffer 來控制加入讀取出來的字串，或是刪除
        String sChar = extractStringsStack(s);
        String tChar = extractStringsStack(t);
        return sChar.equals(tChar);
    }

    private static String extractStrings(String s) {
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '#') {
                if (stringbuffer.length() > 0) {
                    stringbuffer.deleteCharAt(stringbuffer.length() - 1);
                }
            } else {
                stringbuffer.append(character);
            }
        }
        return stringbuffer.toString();
    }
    private static String extractStringsStack(String s) {
        // 如果不是 #，就放到 Stack 裡頭
        // 如果是，就 Pop up 掉

        Stack<Character> resultStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '#') {
                if (resultStack.size() > 0) {
                    resultStack.pop();
                }
            } else {
                resultStack.add(character);
            }
        }
        return String.valueOf(resultStack);
    }
}
