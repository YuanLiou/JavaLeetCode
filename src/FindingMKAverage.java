import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class FindingMKAverage {

	public static void main(String[] args) {
		var sampleClass = new MKAverage(3, 1);
		sampleClass.addElement(3);
		sampleClass.addElement(1);
		var result01 = sampleClass.calculateMKAverage();
		sampleClass.addElement(10);
		var result02 = sampleClass.calculateMKAverage();
		sampleClass.addElement(5);
		sampleClass.addElement(5);
		sampleClass.addElement(5);
		var result03 = sampleClass.calculateMKAverage();
		// expected = -1
		System.out.println("Result 01 is " + result01);
		// expected = 3
		System.out.println("Result 02 is " + result02);
		// expected = 5
		System.out.println("Result 03 is " + result03);
	}

	private static class MKAverage {
		private final int m;
		private final int k;
		private final Deque<Integer> numbers = new LinkedList<>();
		private final TreeMap<Integer, Integer> numberToFrequency = new TreeMap<>();
		private long sum = 0L;
		public MKAverage(int m, int k) {
			this.m = m;
			this.k = k;
		}

		public void addElement(int num) {
			addNumberFromTracking(num);
			if (numbers.size() > m) {
				removeFirstNumberFromTracking();
			}
		}

		private void addNumberFromTracking(int num) {
			sum += num;
			numbers.add(num);
			var frequency = numberToFrequency.getOrDefault(num, 0);
			numberToFrequency.put(num, frequency + 1);
		}

		private void removeFirstNumberFromTracking() {
			var removedNumber = numbers.removeFirst();
			sum -= removedNumber;
			numberToFrequency.put(removedNumber, numberToFrequency.get(removedNumber) - 1);
			var removedNumberFrequency = numberToFrequency.get(removedNumber);
			if (removedNumberFrequency <= 0) {
				numberToFrequency.remove(removedNumber);
			}
		}

		public int calculateMKAverage() {
			if (numbers.size() < m) {
				return -1;
			}

			var goingToReduce = 0;
			var totalNumber = m - (k * 2);

			// Remove smallest
			var kSmallTimes = k;
			var smallestNumber = numberToFrequency.firstKey();
			while (kSmallTimes > 0) {
				var frequency = numberToFrequency.get(smallestNumber);
				var toDelete = Math.min(frequency, kSmallTimes);
				goingToReduce += toDelete * smallestNumber;
				kSmallTimes -= toDelete;

				if (kSmallTimes > 0) {
					smallestNumber = numberToFrequency.higherKey(smallestNumber);
				}
			}

			// Remove largest
			var kLargeTimes = k;
			var largestNumber = numberToFrequency.lastKey();
			while (kLargeTimes > 0) {
				var frequency = numberToFrequency.get(largestNumber);
				var toDelete = Math.min(frequency, kLargeTimes);
				goingToReduce += toDelete * largestNumber;
				kLargeTimes -= toDelete;

				if (kLargeTimes > 0) {
					largestNumber = numberToFrequency.lowerKey(largestNumber);
				}
			}
			return (int) (sum - goingToReduce) / totalNumber;
		}
	}
}
