package problems;

public class Ackley extends Problem {

    public Ackley(int d) {
        super(d, "Ackley");
        for (int i = 0; i < d; i++) {
            lowerBound[i] = -32.768;
            upperBound[i] = 32.768;
        }
    }

    @Override
    public double evaluate(double[] x) {
        int n = d;
        double sumSq = 0.0;
        double sumCos = 0.0;
        for (double xi : x) {
            sumSq += xi * xi;
            sumCos += Math.cos(2.0 * Math.PI * xi);
        }
        double term1 = -20.0 * Math.exp(-0.2 * Math.sqrt(sumSq / n));
        double term2 = -Math.exp(sumCos / n);
        return term1 + term2 + 20.0 + Math.E;
    }
}
