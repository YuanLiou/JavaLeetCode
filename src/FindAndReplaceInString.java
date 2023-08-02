import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {
    public static void main(String[] args) {
        var sampleClass = new FindAndReplaceInString();

        // Example 01: expected: "eeebffff
        var s01 = "abcd";
        var indices = new int[]{0, 2};
        var sources = new String[]{"a", "cd"};
        var targets = new String[]{"eee", "ffff"};
        var result01 = sampleClass.findReplaceString(s01, indices, sources, targets);
        System.out.println("Result is " + result01);
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder stringBuilder = new StringBuilder(s);
        Map<Integer, String> sourceMap = new HashMap<>();
        Map<Integer, String> targetMap = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            sourceMap.put(indices[i], sources[i]);
            targetMap.put(indices[i], targets[i]);
        }

        Arrays.sort(indices);
        // After sorted, We can start replacing from the last one to start.
        for (int i = indices.length - 1; i >= 0; i--) {
            var currentIndex = indices[i];
            var currentSource = sourceMap.get(currentIndex);
            var currentTarget = targetMap.get(currentIndex);

            var sourceLength = currentSource.length();
            var slicedString = s.substring(currentIndex, currentIndex + sourceLength);
            if (slicedString.equals(currentSource)) {
                stringBuilder.replace(currentIndex, currentIndex + sourceLength, currentTarget);
            }
        }

        return stringBuilder.toString();
    }

    // This would fail
    public String findReplaceStringOld(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < indices.length; i++) {
            var source = sources[i];
            int index = s.indexOf(source);
            if (index == indices[i]) {
                int swappedIndex = stringBuilder.indexOf(source);
                stringBuilder.replace(swappedIndex, swappedIndex + source.length(), targets[i]);
            }
        }
        return stringBuilder.toString();
    }
}
