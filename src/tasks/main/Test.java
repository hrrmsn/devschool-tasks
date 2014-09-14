package tasks.main;

import tasks.mindistance.MinimumDistanceFinder;
import tasks.mindistance.PointsRandomizer;
import tasks.weightsbalance.WeightBalancer;
import tasks.weightsbalance.MassRandomizer;

public class Test {
    private static void minimumDistanceTaskSolve() {
        PointsRandomizer.writeRandomPointsToFile();
        MinimumDistanceFinder.printResult();
    }
    
    private static void weightsBalanceTaskSolve() {
        MassRandomizer.writeRandomMassToFile();
        WeightBalancer.printResult();
    }
            
    public static void main(String[] args) {
        minimumDistanceTaskSolve();
        weightsBalanceTaskSolve();
    }
}
