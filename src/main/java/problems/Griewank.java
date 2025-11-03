package problems;

public class Griewank extends Problem {

    public Griewank(int d) {
        super(d, "Griewank");
        for (int i = 0; i < d; i++) {
            lowerBound[i] = -600.0;
            upperBound[i] = 600.0;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double sum = 0.0;
        double prod = 1.0;
        for (int i = 0; i < d; i++) {
            double xi = x[i];
            sum += (xi * xi) / 4000.0;
            // i is 0-based; Griewank uses sqrt(i+1)
            prod *= Math.cos(xi / Math.sqrt(i + 1.0));
        }
        return sum - prod + 1.0; // global minimum is 0 at x = 0
    }
}
