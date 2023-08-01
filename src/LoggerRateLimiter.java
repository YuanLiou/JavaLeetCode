import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
	class Logger {
		Map<String, Integer> inputMap = new HashMap<>();

		public Logger() {
		}

		public boolean shouldPrintMessage(int timestamp, String message) {
			if (!inputMap.containsKey(message)) {
				inputMap.put(message, timestamp + 10);
				return true;
			}

			int previousSaveTime = inputMap.get(message);
			if (timestamp >= previousSaveTime) {
				inputMap.put(message, timestamp + 10);
				return true;
			}
			return false;
		}
	}
}
