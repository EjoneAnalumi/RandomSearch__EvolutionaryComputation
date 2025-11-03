package problems;

import java.util.Random;

public abstract class Problem {
    protected int d;
    protected double[] lowerBound;
    protected double[] upperBound;
    protected String name;
    protected Random rand = new Random();

    public Problem(int d, String name) {
        this.d = d;
        this.name = name;
        this.lowerBound = new double[d];
        this.upperBound = new double[d];
    }

    public abstract double evaluate(double[] x);

    public double[] generateRandomSolution() {
        double[] x = new double[d];
        for (int i = 0; i < d; i++) {
            x[i] = lowerBound[i] + rand.nextDouble() *
                    (upperBound[i] - lowerBound[i]);
        }
        return x;
    }

    public int getDimensions() { return d; }
    public String getName() { return name; }
}
