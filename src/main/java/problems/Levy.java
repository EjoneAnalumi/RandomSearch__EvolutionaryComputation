package problems;

public class Levy extends Problem {

    public Levy(int d) {
        super(d, "Levy");
        for (int i = 0; i < d; i++) {
            lowerBound[i] = -10.0;
            upperBound[i] =  10.0;
        }
    }

    @Override
    public double evaluate(double[] x) {
        // Levy N.13 (global min f=0 at x_i = 1 for all i)
        // w_i = 1 + (x_i - 1)/4
        double[] w = new double[d];
        for (int i = 0; i < d; i++) {
            w[i] = 1.0 + (x[i] - 1.0) / 4.0;
        }

        double term1 = Math.sin(Math.PI * w[0]);
        term1 *= term1;

        double sum = 0.0;
        for (int i = 0; i < d - 1; i++) {
            double wi = w[i];
            double inner = Math.sin(Math.PI * wi + 1.0);
            sum += (wi - 1.0) * (wi - 1.0) * (1.0 + 10.0 * inner * inner);
        }

        double wd = w[d - 1];
        double term3 = (wd - 1.0) * (wd - 1.0) * (1.0 + Math.sin(2.0 * Math.PI * wd) * Math.sin(2.0 * Math.PI * wd));

        return term1 + sum + term3;
    }
}
