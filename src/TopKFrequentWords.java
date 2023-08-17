import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import utils.ArrayUtils;

public class TopKFrequentWords {
	public static void main(String[] args) {
		var sampleClass = new TopKFrequentWords();
		// expected: ["i", "love"]
		String[] input01 = new String[]{"I", "love", "leetcode", "I", "love", "coding"};
		int samplek = 2;
		var result = sampleClass.topKFrequent(input01, samplek);
		ArrayUtils.printStringList(result);
		System.out.println();

		// expected: ["the", "is", "sunny", "day]
		String[] input02 = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
		int samplek02 = 4;
		var result02 = sampleClass.topKFrequent(input02, samplek02);
		ArrayUtils.printStringList(result02);
	}

	// Time: O(n * logN)
	// Space: O(n)
	public List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> wordMap = new HashMap<>();
		for (String word : words) {
			var counts = wordMap.getOrDefault(word, 0);
			wordMap.put(word, counts + 1);
		}

		PriorityQueue<String> priorityQueue = new PriorityQueue<>(
				(s1, s2) -> {
					var frequency01 = wordMap.get(s1);
					var frequency02 = wordMap.get(s2);

					if (frequency02.equals(frequency01)) {
						return s1.compareTo(s2); // 字典順序
					}
					return frequency02 - frequency01; // 大到小
				}
		);

		// PriorityQueue (Heap) add. Time would be O(log n)
		//  And we loop all words from wordMap which cause O(n)
		//  This part will cause the time complexity to O(n * log(N))
		for (var entry : wordMap.entrySet()) {
			priorityQueue.add(entry.getKey());
		}

		List<String> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			var word = priorityQueue.poll();
			if (word != null) {
				result.add(word);
			}
		}
		return result;
	}


	// Time: O(n * log K)
	public List<String> topKFrequentMinHeap(String[] words, int k) {
		// 1.) build up a map which contains the frequency of each words
		Map<String, Integer> wordMaps = new HashMap<>();
		for (String word : words) {
			var counts = wordMaps.getOrDefault(word, 0);
			wordMaps.put(word, counts + 1);
		}

		// 2.) build a MinHeap (PriorityQueue)
		//  2-1) compare the frequency
		//  2-2) if the frequency is the same, compare String itself in anti-lexicographical order
		PriorityQueue<String> minHeap = new PriorityQueue<>(
			(string1, string2) -> {
				var frequency01 = wordMaps.get(string1);
				var frequency02 = wordMaps.get(string2);

				if (Objects.equals(frequency01, frequency02)) {
					return string2.compareTo(string1);
				}
				// small to large
				return frequency01 - frequency02;
			}
		);

		// Put word into the minHeap
		//  here make the time complexity O(n * log K)
		for (var entrySet : wordMaps.entrySet()) {
			minHeap.offer(entrySet.getKey());
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		List<String> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			result.add(minHeap.poll());
		}
		Collections.reverse(result);
		return result;
	}
}
