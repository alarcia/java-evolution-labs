package lab08_unnamed_variables.legacy;

import java.util.List;

public class NoiseMaker {

    record Point(int x, int y) {}

    public static void main(String[] args) {
        var points = List.of(new Point(1, 2), new Point(3, 4), new Point(5, 6));
        var parser = new NoiseMaker();
        parser.processPoints(points);
    }

    public void processPoints(List<Point> points) {
        int count = 0;

        // LEGACY 1: Unused iteration variable
        // 'p' is declared but not used. Loop is just for counting.
        // IDE warns 'p' is never used.
        for (Point p : points) {
            count++;
            if (count > 2) break;
        }

        // LEGACY 2: Unused Exception variable
        // 'number' is declared but not used. Code is expected to raise an exception
        // IDE warns 'number' is never used.
        try {
            int number = Integer.parseInt("NotANumber");
        } catch (NumberFormatException e) {
            System.out.println("Failed to parse number");
        }

        // LEGACY 3: Unnecessary Pattern variable
        // Only the 'x' is needed, but 'y' must be declared.
        Point p = new Point(10, 20);
        if (p instanceof Point(int x, int y)) {
            System.out.println("Only checking X: " + x);
            // 'y' is polluting the scope.
        }
    }
}