package tasks.weightsbalance;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public final class MassRandomizer {
    private static final int MASS_VALUE_RANGE = 100;
    private static final int NUMBER_VALUE_RANGE = 30;
    private static final int NUMBER_MIN_VALUE = 2;
    
    private static final String FILE_NAME = "mass.txt";
    private static final Random random = new Random();
    
    public static void writeRandomMassToFile() {
        try (PrintWriter writer = getPrintWriter()) {
            List<Integer> weights = getRandomMassList();
            for (Integer weight: weights) {
                writer.print(weight + " ");
            }
        }
    }
    
    private static int getRandomWeight() {
        return random.nextInt(MASS_VALUE_RANGE);
    }
    
    private static int getRandomWeightsNumber() {
        return random.nextInt(NUMBER_VALUE_RANGE) + NUMBER_MIN_VALUE;
    }
    
    private static List<Integer> getRandomMassList() {
        List<Integer> result = new ArrayList<>();
        int weightsNumber = getRandomWeightsNumber();
        for (int i = 0; i < weightsNumber; ++i) {
            result.add(getRandomWeight());
        }
        return result;
    }
    
    private static PrintWriter getPrintWriter() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(FILE_NAME);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return writer;
    }
}
