package problems;

public class Michalewicz extends Problem {

    private final int m; // steepness parameter, standard is 10

    public Michalewicz(int d) {
        this(d, 10);
    }

    public Michalewicz(int d, int m) {
        super(d, "Michalewicz");
        this.m = m;
        for (int i = 0; i < d; i++) {
            lowerBound[i] = 0.0;
            upperBound[i] = Math.PI;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double sum = 0.0;
        for (int i = 0; i < d; i++) {
            double xi = x[i];
            double s1 = Math.sin(xi);
            double s2 = Math.sin(((i + 1) * xi * xi) / Math.PI);
            sum += s1 * Math.pow(s2, 2.0 * m);
        }
        return -sum;
    }
}
