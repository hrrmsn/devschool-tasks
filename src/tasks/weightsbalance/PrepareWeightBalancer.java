package tasks.weightsbalance;

import java.util.Arrays;

public final class PrepareWeightBalancer {
    private final static int[] mass = MassLoader.getMass();
    private final static int sum = MassLoader.getMassSum();
    
    private static int standard;
    private static int minNumberOfWeights;
    private static int maxNumberOfWeights;
    private static boolean solveExists;
    
    public static void setStandard(int newStandard) {
        standard = newStandard;
        solveExists = setMinMaxNumberOfWeights();
    }

    public static boolean isSolveExists() {
        return solveExists;
    }
    
    public static int getSum() {
        return sum;
    }
    
    public static int[] getMass() {
        return mass;
    }
    
    public static int getMinNumberOfWeights() {
        return minNumberOfWeights;
    }
    
    public static int getMaxNumberOfWeights() {
        return maxNumberOfWeights;
    }
    
    private static boolean setMinMaxNumberOfWeights() {
        int[] copy = Arrays.copyOf(mass, mass.length);
        Arrays.sort(copy);
        minNumberOfWeights = getMinNumberOfWeights(copy);
        maxNumberOfWeights = getMaxNumberOfWeights(copy);
        return simpleCheck();
    }
    
    private static int getMinNumberOfWeights(int[] sortedMass) {
        int currentSum = 0;
        int index = sortedMass.length - 1;
        while (currentSum < standard && index >= 0) {
            currentSum += sortedMass[index--];
        }
        return sortedMass.length - 1 - index;
    }
    
    private static int getMaxNumberOfWeights(int[] sortedMass) {
        int currentSum = 0;
        int index = 0;
        while (currentSum < standard && index < sortedMass.length) {
            currentSum += sortedMass[index++];
        }
        if (currentSum == standard) {
            return index;
        }
        return index - 1;
    }
    
    private static boolean simpleCheck() {
        return sum % 2 == 0;
    }
}
