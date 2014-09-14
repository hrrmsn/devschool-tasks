package tasks.mindistance;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public final class PointsLoader {
    private static final String FILE_NAME = "points.txt";
    private static final String SPACE_CHARACTER = " ";
    
    private PointsLoader() {}
    
    public static List<Point> getPointsList() {
        List<Point> result = new ArrayList<>();
        try (Scanner scanner = getScanner()) {
            while (scanner.hasNext()) {
                result.add(extractPointFromLine(scanner.nextLine()));
            }
        }
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
    
    private static Point extractPointFromLine(String line) {
        String[] coords = line.split(SPACE_CHARACTER);
        int x = Integer.parseInt(coords[0]);
        int y = Integer.parseInt(coords[1]);
        return new Point(x, y);
    }
}
