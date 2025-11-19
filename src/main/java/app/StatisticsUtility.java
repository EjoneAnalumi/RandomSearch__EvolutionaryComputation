package app;

public class StatisticsUtility {

    public static double getMin(double[] values) {
        double m = values[0];
        for (double v : values) if (v < m) m = v;
        return m;
    }

    public static double getAverage(double[] values) {
        double sum = 0;
        for (double v : values) sum += v;
        return sum / values.length;
    }

    public static double getStd(double[] values) {
        double avg = getAverage(values);
        double sumSq = 0;
        for (double v : values) sumSq += (v - avg) * (v - avg);
        return Math.sqrt(sumSq / values.length);
    }
}
