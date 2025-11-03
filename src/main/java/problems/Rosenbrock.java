package problems;

public class Rosenbrock extends Problem {

    public Rosenbrock(int d) {
        super(d, "Rosenbrock");
        for (int i = 0; i < d; i++) {
            lowerBound[i] = -5.0;
            upperBound[i] = 10.0;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double sum = 0.0;
        for (int i = 0; i < d - 1; i++) {
            double xi = x[i];
            double xnext = x[i + 1];
            double t1 = xnext - xi * xi;
            double t2 = 1.0 - xi;
            sum += 100.0 * t1 * t1 + t2 * t2;
        }
        return sum;
    }
}
