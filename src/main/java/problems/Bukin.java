package problems;

public class Bukin extends Problem {

    public Bukin() {
        super(2, "BukinN6");
        // Lb = [-15, -3], Ub = [-5, 3]
        lowerBound[0] = -15.0; upperBound[0] = -5.0;
        lowerBound[1] = -3.0;  upperBound[1] =  3.0;
    }

    @Override
    public double evaluate(double[] x) {
        // f(x, y) = 100*sqrt(|y - 0.01*x^2|) + 0.01*|x + 10|
        double X = x[0];
        double Y = x[1];
        double term1 = 100.0 * Math.sqrt(Math.abs(Y - 0.01 * X * X));
        double term2 = 0.01 * Math.abs(X + 10.0);
        return term1 + term2; // global min 0 at (-10, 1)
    }
}
