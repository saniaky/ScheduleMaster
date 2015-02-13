package application.solver.generator.util;

import java.util.Random;


public class RandomUtil {

    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
