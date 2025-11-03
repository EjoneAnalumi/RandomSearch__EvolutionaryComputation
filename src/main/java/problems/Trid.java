package problems;

public class Trid extends Problem {

    public Trid(int d) {
        super(d, "Trid");
        double bound = d * d;
        for (int i = 0; i < d; i++) {
            lowerBound[i] = -bound;
            upperBound[i] =  bound;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double sum1 = 0.0;
        double sum2 = 0.0;
        for (int i = 0; i < d; i++) {
            double xi = x[i];
            sum1 += (xi - 1.0) * (xi - 1.0);
            if (i > 0) sum2 += xi * x[i - 1];
        }
        return sum1 - sum2;
    }
}
