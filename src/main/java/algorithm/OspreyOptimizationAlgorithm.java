package algorithm;

import problems.Problem;

import java.util.Random;

public class OspreyOptimizationAlgorithm extends Algorithm {

    private final int N;
    private final Random rand = new Random();

    public OspreyOptimizationAlgorithm(int populationSize) {
        if (populationSize < 4)
            throw new IllegalArgumentException("Population size must be >= 4");
        this.N = populationSize;
    }

    @Override
    public Solution execute(Problem problem, int maxFes, boolean isDebug) {

        int D = problem.getDimensions();
        double[][] X = new double[N][D];
        double[] fit = new double[N];

        int fes = 0;

        int bestIdx = 0;
        for (int i = 0; i < N; i++) {
            X[i] = problem.generateRandomSolution();
            fit[i] = problem.evaluate(X[i]);
            fes++;
            if (fit[i] < fit[bestIdx]) bestIdx = i;
        }

        int remaining = maxFes - fes;
        int T = Math.max(1, remaining / (2 * N));

        for (int t = 1; t <= T && fes < maxFes; t++) {

            bestIdx = argMin(fit);

            for (int i = 0; i < N && fes < maxFes; i++) {

                // Phase 1: Exploration (hunt fish)
                int fish = pickBetterIndex(i, fit, bestIdx);
                if (fish == -1) fish = bestIdx;

                double[] cand1 = X[i].clone();
                int I = 1 + rand.nextInt(2);

                for (int d = 0; d < D; d++) {
                    double r = rand.nextDouble();
                    cand1[d] = X[i][d] + r * (X[fish][d] - I * X[i][d]);
                    cand1[d] = clamp(cand1[d],
                            problem.getLowerBound(d),
                            problem.getUpperBound(d));
                }

                double f1 = problem.evaluate(cand1);
                fes++;

                if (f1 < fit[i]) {
                    X[i] = cand1;
                    fit[i] = f1;
                }

                if (fes >= maxFes) break;

                // Phase 2: Exploitation (carry fish)
                double shrink = 1.0 - ((double) t / (double) T);
                if (shrink < 1e-6) shrink = 1e-6;

                double[] safe = new double[D];
                for (int d = 0; d < D; d++) {
                    safe[d] = problem.getLowerBound(d)
                            + rand.nextDouble()
                            * (problem.getUpperBound(d) - problem.getLowerBound(d));
                }

                double[] cand2 = X[i].clone();
                for (int d = 0; d < D; d++) {
                    double r = rand.nextDouble();
                    cand2[d] = X[i][d] + r * shrink * (safe[d] - X[i][d]);
                    cand2[d] = clamp(cand2[d],
                            problem.getLowerBound(d),
                            problem.getUpperBound(d));
                }

                double f2 = problem.evaluate(cand2);
                fes++;

                if (f2 < fit[i]) {
                    X[i] = cand2;
                    fit[i] = f2;
                }
            }
        }

        bestIdx = argMin(fit);
        return new Solution(X[bestIdx], fit[bestIdx]);
    }

    // helpers

    private int argMin(double[] a) {
        int best = 0;
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[best]) best = i;
        return best;
    }

    private int pickBetterIndex(int i, double[] fit, int bestIdx) {
        if (bestIdx != i && fit[bestIdx] < fit[i] && rand.nextDouble() < 0.5)
            return bestIdx;

        int[] tmp = new int[fit.length];
        int cnt = 0;
        for (int j = 0; j < fit.length; j++) {
            if (j != i && fit[j] < fit[i]) tmp[cnt++] = j;
        }
        if (cnt == 0) return -1;
        return tmp[rand.nextInt(cnt)];
    }

    private double clamp(double v, double lo, double hi) {
        if (v < lo) return lo;
        if (v > hi) return hi;
        return v;
    }
}
