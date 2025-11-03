package algorithm;

import problems.Problem;

public class RandomSearch extends Algorithm {

    @Override
    public Solution execute(Problem problem, int maxFes, boolean isDebug) {
        Solution best = null;

        for (int i = 1; i <= maxFes; i++) {
            double[] x = problem.generateRandomSolution();
            double fitness = problem.evaluate(x);
            Solution candidate = new Solution(x, fitness);

            if (best == null || fitness < best.fitness) {
                best = candidate;
                if (isDebug) {
                    System.out.print(i + ": x=[");
                    for (int j = 0; j < x.length; j++)
                        System.out.print(x[j] + (j < x.length - 1 ? ", " : ""));
                    System.out.println("] = " + fitness);
                }
            }
        }
        return best;
    }
}
