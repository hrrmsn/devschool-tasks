package tasks.mindistance;

import java.util.List;
import java.util.Locale;

public final class MinimumDistanceFinder {
    private static final List<Point> points = PointsLoader.getPointsList();
    private static final int POINTS_SIZE = points.size();
    
    private static long minSquareOfTheDistance = getSquareOfTheDistance(0, 1);
    private static long currentSquareOfTheDistance;
    
    public static void printResult() {
        System.out.format(Locale.US, "%.3f%n", getMinimumDistance());
    }
    
    private static double getMinimumDistance() {
        for (int i = 0; i < POINTS_SIZE; ++i) {
            for (int j = (i == 0)?(i + 2):(i + 1); j < POINTS_SIZE; ++j) {
                currentSquareOfTheDistance = getSquareOfTheDistance(i, j);
                if (currentSquareOfTheDistance < minSquareOfTheDistance) {
                    minSquareOfTheDistance = currentSquareOfTheDistance;
                }
            }
        }
        if (minSquareOfTheDistance > 0) {
            return Math.sqrt(minSquareOfTheDistance);
        }
        return -1;
    }
    
    private static long getSquareOfTheDistance(int indexI, int indexJ) {
        if (POINTS_SIZE < 2) {
            return -1;
        }
        return points.get(indexI).getSquareOfTheDistance(points.get(indexJ));
    }
}
