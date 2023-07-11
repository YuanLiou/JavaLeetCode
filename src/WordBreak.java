import java.util.List;

public class WordBreak {
	public static void main(String[] args) {
		var sampleClass = new WordBreak();

		var input01 = "LeetCode";
		var input01WordDict = List.of("Code", "Neet");
		var result01 = sampleClass.wordBreak(input01, input01WordDict);
		System.out.println("Result01 is " + result01);
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[s.length()] = true; // base case, boundary 到了就該停下

		for (int i = s.length() - 1; i >= 0; i--) {
			for (String word : wordDict) {
				// s.startsWith(word, i) 寫法 == s.substring(i,i + word.length()).equals(word)
				if (i + word.length() <= s.length() && s.startsWith(word, i)) {
					// 代表還有空間可以塞字
					dp[i] = dp[i + word.length()];
				}

				if (dp[i]) {
					break;
				}
			}
		}
		return dp[0];
	}
}
