package utils;

import java.util.Random;

public class IntegerUtils {
    public static int getRandomNumber(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }
}
