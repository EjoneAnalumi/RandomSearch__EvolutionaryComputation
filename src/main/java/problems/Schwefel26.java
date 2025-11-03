package problems;

public class Schwefel26 extends Problem {

    private static final double C = 418.9828872724338;

    public Schwefel26(int d) {
        super(d, "Schwefel26");
        for (int i = 0; i < d; i++) {
            lowerBound[i] = -500.0;
            upperBound[i] = 500.0;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double sum = 0.0;
        for (int i = 0; i < d; i++) {
            double xi = x[i];
            sum += xi * Math.sin(Math.sqrt(Math.abs(xi)));
        }
        return C * d - sum;
    }
}
