package algorithm;

import problems.Problem;

import java.util.Random;

public class DifferentialEvolution extends Algorithm {

    private final int NP;
    private final double CR;
    private final double F;
    private final Random rand = new Random();

    public DifferentialEvolution(int NP, double CR, double F) {
        if (NP < 4) throw new IllegalArgumentException("NP must be >= 4");
        if (CR < 0 || CR > 1) throw new IllegalArgumentException("CR must be in [0,1]");
        if (F < 0 || F > 2) throw new IllegalArgumentException("F must be in [0,2]");
        this.NP = NP;
        this.CR = CR;
        this.F = F;
    }

    @Override
    public Solution execute(Problem problem, int maxFes, boolean isDebug) {

        int D = problem.getDimensions();

        double[][] pop = new double[NP][D];
        double[] fit = new double[NP];

        int fes = 0;

        for (int i = 0; i < NP; i++) {
            pop[i] = problem.generateRandomSolution();
            fit[i] = problem.evaluate(pop[i]);
            fes++;
        }

        int bestIdx = 0;
        for (int i = 1; i < NP; i++) {
            if (fit[i] < fit[bestIdx]) bestIdx = i;
        }

        while (fes < maxFes) {

            for (int i = 0; i < NP && fes < maxFes; i++) {

                int a, b, c;
                do { a = rand.nextInt(NP); } while (a == i);
                do { b = rand.nextInt(NP); } while (b == i || b == a);
                do { c = rand.nextInt(NP); } while (c == i || c == a || c == b);

                double[] v = new double[D];
                for (int j = 0; j < D; j++) {
                    v[j] = pop[a][j] + F * (pop[b][j] - pop[c][j]);

                    double lb = problem.getLowerBound(j);
                    double ub = problem.getUpperBound(j);
                    if (v[j] < lb) v[j] = lb;
                    if (v[j] > ub) v[j] = ub;
                }

                double[] y = new double[D];
                int R = rand.nextInt(D);

                for (int j = 0; j < D; j++) {
                    if (rand.nextDouble() < CR || j == R) {
                        y[j] = v[j];
                    } else {
                        y[j] = pop[i][j];
                    }
                }

                double fy = problem.evaluate(y);
                fes++;

                if (fy <= fit[i]) {
                    pop[i] = y;
                    fit[i] = fy;

                    if (fy < fit[bestIdx]) {
                        bestIdx = i;
                    }
                }
            }
        }

        return new Solution(pop[bestIdx], fit[bestIdx]);
    }
}
