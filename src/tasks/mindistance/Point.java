package tasks.mindistance;

public class Point {
    private final int x;
    private final int y;
    
    public Point(int newX, int newY) {
        x = newX;
        y = newY;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public long getSquareOfTheDistance(Point point) {
        long result = 0;
        result = (x - point.getX()) * (x - point.getX()) 
                + (y - point.getY()) * (y - point.getY());
        return result;
    }
    
    @Override
    public String toString() {
        return (x + " " + y);
    }
}
