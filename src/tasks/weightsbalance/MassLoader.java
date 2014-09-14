package tasks.weightsbalance;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public final class MassLoader {
    private static final String FILE_NAME = "mass.txt";
    
    private static int sum;
    
    public static int getMassSum() {
        return sum;
    }
    
    public static int[] getMass() {
        Scanner scanner = getScanner();
        return extractIntsFromStrings(scanner.nextLine().split(" "));
    }
    
    private static int[] extractIntsFromStrings(String[] massArray) {
        int[] result = new int[massArray.length];
        int commonMass = 0;
        for (int i = 0; i < result.length; ++i) {
            result[i] = Integer.parseInt(massArray[i]);
            commonMass += result[i];
        }
        sum = commonMass;
        return result;
    }
    
    private static Scanner getScanner() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(FILE_NAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return scanner;
    }
}
