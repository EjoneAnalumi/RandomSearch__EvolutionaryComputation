package problems;

public class CarromTable extends Problem {

    public CarromTable() {
        super(2, "CarromTable");
        // Lb = [-10, -10], Ub = [10, 10]
        for (int i = 0; i < 2; i++) {
            lowerBound[i] = -10.0;
            upperBound[i] =  10.0;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double X = x[0];
        double Y = x[1];
        double cosTerm = Math.cos(X) * Math.cos(Y);
        double expTerm = Math.exp(-((X - Math.PI) * (X - Math.PI) + (Y - Math.PI) * (Y - Math.PI)));
        return 1.0 - (cosTerm * cosTerm) * expTerm; // global min 0 at (pi, pi)
    }
}
