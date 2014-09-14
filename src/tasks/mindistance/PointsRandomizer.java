package tasks.mindistance;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public final class PointsRandomizer {
    private static final double POSITIVE_PROBABILITY = 0.6;
    private static final int COORDS_VALUE_RANGE = 5000;
    private static final int NUMBER_VALUE_RANGE = 1000;
    private static final int NUMBER_MIN_VALUE = 2;
    
    private static final String FILE_NAME = "points.txt";
    private static final Random random = new Random();
    
    public static void writeRandomPointsToFile() {
        try (PrintWriter writer = getPrintWriter()) {
            List<Point> points = getRandomPointsList();
            for (Point point: points) {
                writer.println(point);
            }
        }
    }
    
    private static Point getRandomPoint() {
        return new Point(getRandomCoord(), getRandomCoord());
    }
    
    private static int getRandomSign() {
        return (Math.random() > POSITIVE_PROBABILITY)?(1):(-1);
    }
    
    private static int getRandomCoord() {
        return (random.nextInt(COORDS_VALUE_RANGE) * getRandomSign());
    }
    
    private static int getRandomPointsNumber() {
        return random.nextInt(NUMBER_VALUE_RANGE) + NUMBER_MIN_VALUE;
    }
    
    private static List<Point> getRandomPointsList() {
        List<Point> result = new ArrayList<>();
        int pointsNumber = getRandomPointsNumber();
        for (int i = 0; i < pointsNumber; ++i) {
            result.add(getRandomPoint());
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
