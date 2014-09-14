package tasks.weightsbalance;

import java.util.List;
import java.util.ArrayList;

public final class WeightBalancer {
    private final static String FAIL_MESSAGE = "can not balance this weights";
    private final static int ONE_HUNDRED = 100;
    
    private final static int[] mass = PrepareWeightBalancer.getMass();
    private final static int sum = PrepareWeightBalancer.getSum();
    private final static int halfSum = sum / 2;
    
    private static int minNumberOfWeights;
    private static int maxNumberOfWeights;
    
    private static List<Integer> result;
    private static boolean exitFlag = false;
    
    public static void printResult() {
        solveProblem();
        if (result != null) outputAnswer();
        doOneHundredCheck();
    }
    
    private static void solveProblem() {
        setNewStandard(halfSum);
        if (PrepareWeightBalancer.isSolveExists() == false) {
            System.out.println(FAIL_MESSAGE);
        } else {
            balance(halfSum);
            if (result == null) System.out.println(FAIL_MESSAGE);
        }
    }
    
    private static void doOneHundredCheck() {
        setNewStandard(ONE_HUNDRED);
        balance(ONE_HUNDRED);
        System.out.println( (result == null)?("no"):("yes") );
    }
    
    private static void outputAnswer() {
        List<Integer> copyMass = new ArrayList<>();
        for (int i: mass) copyMass.add(i);
        for (Integer weight: result) {
            if (copyMass.contains(weight)) copyMass.remove(weight);
        }        
        System.out.println(result + " - " + copyMass);
    }
    
    private static void setNewStandard(int newStandard) {
        PrepareWeightBalancer.setStandard(newStandard);
        minNumberOfWeights = PrepareWeightBalancer.getMinNumberOfWeights();
        maxNumberOfWeights = PrepareWeightBalancer.getMaxNumberOfWeights();
        result = null;
        exitFlag = false;
    }
        
    private static void balance(int standard) {
        List<Integer> balancedScale = null;
        for (int maxDeep = minNumberOfWeights; maxDeep <= maxNumberOfWeights; 
                ++maxDeep) {
            for (int start = 0; start < mass.length - maxDeep + 1; ++start) {
                balancedScale = new ArrayList<>();
                balancedScale.add(mass[start]);
                dive(start, mass[start], balancedScale, 1, maxDeep, standard);
                if (exitFlag) return;
            }
        }
    }
    
    private static void dive(int start, int weight, List<Integer> weights, 
            int deep, int maxDeep, int standard) {
        if (deep < maxDeep && exitFlag == false) {
            for (int i = start + 1; i < mass.length; ++i) {
                List<Integer> expandWeights = new ArrayList<>(weights);
                expandWeights.add(mass[i]);
                dive(i, weight + mass[i], expandWeights, deep + 1, maxDeep, 
                        standard);
            }
        }
        if (deep == maxDeep && weight == standard) {
            result = weights;
            exitFlag = true;
        }
    }
}
