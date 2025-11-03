package problems;

public class Rastrigin extends Problem {

    private static final double A = 10.0;

    public Rastrigin(int d) {
        super(d, "Rastrigin");
        for (int i = 0; i < d; i++) {
            lowerBound[i] = -5.12;
            upperBound[i] = 5.12;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double sum = A * d;
        for (int i = 0; i < d; i++) {
            double xi = x[i];
            sum += (xi * xi) - A * Math.cos(2.0 * Math.PI * xi);
        }
        return sum; // global min 0 at x = 0
    }
}
