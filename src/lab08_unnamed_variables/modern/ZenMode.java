package lab08_unnamed_variables.modern;

import java.util.List;

public class ZenMode {

    record Point(int x, int y) {}

    public static void main(String[] args) {
        var points = List.of(new Point(1, 2), new Point(3, 4), new Point(5, 6));
        new ZenMode().processPoints(points);
    }

    public void processPoints(List<Point> points) {
        int count = 0;

        // 1. UNNAMED IN LOOPS
        // There is an iteration, but the element itself is irrelevant
        for (Point _ : points) {
            count++;
            if (count > 2) break;
        }
        System.out.println("Counted: " + count);

        // 2. UNNAMED IN CATCH
        // The error is noted, but the stacktrace is not necessary
        try {
            int number = Integer.parseInt("NotANumber");
        } catch (NumberFormatException _) {
            System.out.println("Failed to parse number (error ignored)");
        }

        // 3. UNNAMED IN PATTERNS
        // The record Point is deconstructed, and only the x is relevant
        Point p = new Point(10, 20);
        if (p instanceof Point(int x, _)) {
            System.out.println("Modern X check: " + x);
            // The variable 'y' does not exist here. Cleaner scope.
        }
    }
}