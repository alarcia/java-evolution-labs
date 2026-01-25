package lab09_stream_gatherers.modern;

import java.util.List;
import java.util.stream.Gatherers;

public class SmartSensors {

    public static void main(String[] args) {
        List<Double> temps = List.of(20.0, 21.0, 22.0, 25.0, 30.0, 29.0);

        // MODERN APPROACH: Stream Gatherers
        // No loops. No index math. No "Off-by-one" bugs.

        List<Double> movingAverages = temps.stream()
                // 1. GATHER: Transform the stream into sliding windows of 3
                // [20, 21, 22] -> [21, 22, 25] -> [22, 25, 30]...
                .gather(Gatherers.windowSliding(3))

                // 2. MAP: Calculate average for each window
                .map(window -> calculateAverage(window))

                .toList();

        System.out.println("Modern Moving Average: " + movingAverages);
    }

    // Helper method to keep the stream clean
    private static double calculateAverage(List<Double> window) {
        return window.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }
}