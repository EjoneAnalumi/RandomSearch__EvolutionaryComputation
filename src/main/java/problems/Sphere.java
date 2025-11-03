package problems;

public class Sphere extends Problem {

    public Sphere(int d) {
        super(d, "Sphere");
        for (int i = 0; i < d; i++) {
            if (i % 2 == 0) {
                lowerBound[i] = -100;
                upperBound[i] = 100;
            } else {
                lowerBound[i] = -10;
                upperBound[i] = 10;
            }
        }
    }

    @Override
    public double evaluate(double[] x) {
        double sum = 0;
        for (double xi : x) sum += xi * xi;
        return sum;
    }
}
