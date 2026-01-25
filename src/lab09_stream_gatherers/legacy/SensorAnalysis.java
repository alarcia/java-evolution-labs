package lab09_stream_gatherers.legacy;

import java.util.ArrayList;
import java.util.List;

public class SensorAnalysis {

    public static void main(String[] args) {
        // Temperature readings
        List<Double> temps = List.of(20.0, 21.0, 22.0, 25.0, 30.0, 29.0);

        System.out.println("Raw Data: " + temps);

        // LEGACY PROBLEM:
        // Java 8 Streams are bad at "Sliding Windows" (grouping [0,1,2], [1,2,3]...).
        // The programmer is forced to use an imperative Loop with index math.

        List<Double> movingAverages = new ArrayList<>();
        int windowSize = 3;

        // Visual noise + Risk of "Off-by-one" errors (i < size - windowSize + 1)
        for (int i = 0; i <= temps.size() - windowSize; i++) {
            double sum = 0;
            // Inner loop to sum the window
            for (int j = 0; j < windowSize; j++) {
                sum += temps.get(i + j);
            }
            movingAverages.add(sum / windowSize);
        }

        System.out.println("Legacy Moving Average: " + movingAverages);
    }
}