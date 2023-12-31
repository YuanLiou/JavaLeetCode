import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.ArrayUtils;

/**
 * Your LogAggregator object will be instantiated and called as such: LogAggregator obj = new
 * LogAggregator(machines, services); obj.pushLog(logId,machineId,serviceId,message); List<Integer>
 * param_2 = obj.getLogsFromMachine(machineId); List<Integer> param_3 =
 * obj.getLogsOfService(serviceId); List<String> param_4 = obj.search(serviceId,searchString);
 */
public class LogAggregator {

	public static void main(String[] args) {
		// There are 3 machines and 3 services
		LogAggregator logAggregator = new LogAggregator(3, 3);
		logAggregator.pushLog(2322, 1, 1, "Machine 1 Service 1 Log 1");
		logAggregator.pushLog(2312, 1, 1, "Machine 1 Service 1 Log 2");
		logAggregator.pushLog(2352, 1, 1, "Machine 1 Service 1 Log 3");
		logAggregator.pushLog(2298, 1, 1, "Machine 1 Service 1 Log 4");
		logAggregator.pushLog(23221, 1, 2, "Machine 1 Service 2 Log 1");
		logAggregator.pushLog(23121, 1, 2, "Machine 1 Service 2 Log 2");
		logAggregator.pushLog(23222, 2, 2, "Machine 2 Service 2 Log 1");
		logAggregator.pushLog(23122, 2, 2, "Machine 2 Service 2 Log 2");
		logAggregator.pushLog(23521, 1, 2, "Machine 1 Service 2 Log 3");
		logAggregator.pushLog(22981, 1, 2, "Machine 1 Service 2 Log 4");
		logAggregator.pushLog(23522, 2, 2, "Machine 2 Service 2 Log 3");
		logAggregator.pushLog(22982, 2, 2, "Machine 2 Service 2 Log 4");

		// return [23222, 23122, 23522, 22982]
		// Machine 2 added 4 logs, so we return them in the order
		// they were added.
		List<Integer> machines = logAggregator.getLogsFromMachine(2);
		System.out.println("getLogsFromMachine: [23222, 23122, 23522, 22982]");
		ArrayUtils.printIntList(machines);
		System.out.println();

		// return [23221, 23121, 23222, 23122, 23521, 22981, 23522, 22982]
		// 8 logs were added while running serviceId 2 on a machineId.
		List<Integer> services = logAggregator.getLogsOfService(2);
		System.out.println("getLogsOfService: [23221, 23121, 23222, 23122, 23521, 22981, 23522, 22982]");
		ArrayUtils.printIntList(services);
		System.out.println();

		// return ["Machine 1 Service 1 Log 1"]
		// There is only one log that was added while running serviceId 1
		// and contains "Log 1".
		List<String> logs01 = logAggregator.search(1, "Log 1");
		System.out.println("search(1, Log 1): [Machine 1 Service 1 Log 1]");
		ArrayUtils.printStringList(logs01);
		System.out.println();

		// return ["Machine 1 Service 2 Log 3", "Machine 2 Service 2 Log 3"]
		// 2 logs were added while running serviceId 2 that contain "Log 3".
		List<String> logs02 = logAggregator.search(2, "Log 3");
		System.out.println("search(2, Log 3): [Machine 1 Service 2 Log 3, Machine 2 Service 2 Log 3]");
		ArrayUtils.printStringList(logs02);
	}

	private final int machineCounts;
	private final int serviceCounts;

	private record Logs(int id, int machineId, int serviceId, String message) {}
	private final List<Logs> logs = new ArrayList<>();
	public LogAggregator(int machineCounts, int serviceCounts) {
		this.machineCounts = machineCounts;
		this.serviceCounts = serviceCounts;
	}

	public void pushLog(int logId, int machineId, int serviceId, String message) {
		if (machineId > machineCounts || serviceId > serviceCounts) {
			return;
		}
		if (machineId < 0 || serviceId < 0) {
			return;
		}
		logs.add(new Logs(logId, machineId, serviceId, message));
	}

	public List<Integer> getLogsFromMachine(int machineId) {
		if (machineId > machineCounts || machineId < 0) {
			return Collections.emptyList();
		}
		return logs.stream()
			.filter(logs -> logs.machineId() == machineId)
			.map(logs -> logs.id)
			.toList();
	}

	public List<Integer> getLogsOfService(int serviceId) {
		if (serviceId > serviceCounts || serviceId < 0) {
			return Collections.emptyList();
		}
		return logs.stream()
			.filter(logs -> logs.serviceId() == serviceId)
			.map(logs -> logs.id)
			.toList();
	}

	public List<String> search(int serviceId, String searchString) {
		if (serviceId > serviceCounts || serviceId < 0) {
			return Collections.emptyList();
		}

		return logs.stream()
			.filter(logs -> logs.serviceId() == serviceId)
			.map(Logs::message)
			.filter(message -> message.contains(searchString))
			.toList();
	}
}