package problems;

public class StyblinskiTang extends Problem {

    public StyblinskiTang(int d) {
        super(d, "StyblinskiTang");
        for (int i = 0; i < d; i++) {
            lowerBound[i] = -5.0;
            upperBound[i] =  5.0;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double sum = 0.0;
        for (int i = 0; i < d; i++) {
            double xi = x[i];
            sum += (Math.pow(xi, 4) - 16.0 * xi * xi + 5.0 * xi);
        }
        return 0.5 * sum;
    }
}
