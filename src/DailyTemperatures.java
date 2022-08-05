import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

import utils.ArrayUtils;

public class DailyTemperatures {

    public static void main(String[] args) {
        // Expected: [1,1,4,2,1,1,0,0]
        var sample01 = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        // Expected: [1,1,1,0]
        var sample02 = new int[]{30, 40, 50, 60};

        // Expected: [1,1,0]
        var sample03 = new int[]{30, 60, 90};

        // Expected: [3,1,1,2,1,1,0,1,1,0]
        var sample04 = new int[] {55, 38, 53, 81, 61, 93, 97, 32, 43, 78};

        // Expected: [8,1,5,4,3,2,1,1,0,0]
        var sample05 = new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70};

        var result = dailyTemperaturesStack(sample05);
        ArrayUtils.printArray(result);
    }

    public static int[] dailyTemperaturesBruteForce(int[] temperatures) {
        if (temperatures.length == 1) {
            return new int[]{0};
        }

        int[] answer = new int[temperatures.length];
        Arrays.fill(answer, 0);

        int i = 0;
        int j = 1;
        int counter = 0;
        while (i < temperatures.length) {
            while (j < temperatures.length) {
                counter++;

                System.out.println("i = " + i + ": " + temperatures[i] + ", j = " + j + ": " + temperatures[j]);
                if (temperatures[j] > temperatures[i]) {
                    System.out.println("counter = " + counter);
                    answer[i] = counter;
                    counter = 0;
                    j = i + 2;
                    break;
                }

                j++;
            }

            i++;

            counter = 0;
            j = i + 1;
        }
        return answer;
    }


    private record Temperature(int index, int temp) {};
    public static int[] dailyTemperaturesStack(int[] temperatures) {
        int[] answers = new int[temperatures.length];
        Arrays.fill(answers, 0);

        // Create a new stack
        Stack<Temperature> stacks = new Stack<>();

        // Traverse reversely
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int currentTemperature = temperatures[i];
            while (!stacks.isEmpty()) {
                Temperature poppedTemperature = stacks.peek();
                if (poppedTemperature.temp <= currentTemperature) {
                    // Tomorrow is cooler or same as today
                    stacks.pop(); // ignore
                } else {
                    // [target] Tomorrow is warmer than today
                    int days = poppedTemperature.index - i;
                    answers[i] = days;
                    break;
                }
            }

            // Add temp into the stack every step
            stacks.push(new Temperature(i, currentTemperature));
        }
        return answers;
    }
}
