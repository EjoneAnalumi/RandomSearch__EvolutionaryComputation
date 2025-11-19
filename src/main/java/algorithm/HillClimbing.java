package algorithm;

import problems.Problem;

public class HillClimbing extends Algorithm {

    private double stepSize;

    public HillClimbing(double stepSize) {
        this.stepSize = stepSize;
    }

    @Override
    public Solution execute(Problem problem, int maxFes, boolean isDebug) {

        int d = problem.getDimensions();
        int fes = 0;

        double[] current = problem.generateRandomSolution();
        double currentFitness = problem.evaluate(current);
        fes++;

        if (isDebug) {
            System.out.println("Start: f = " + currentFitness);
        }

        while (fes < maxFes) {

            double[] bestNeighbor = null;
            double bestNeighborFitness = Double.POSITIVE_INFINITY;

            for (int i = 0; i < d; i++) {

                double[] plus = current.clone();
                plus[i] += stepSize;

                if (plus[i] > problem.getUpperBound(i))
                    plus[i] = problem.getUpperBound(i);

                double fPlus = problem.evaluate(plus);
                fes++;

                if (fPlus < bestNeighborFitness) {
                    bestNeighbor = plus;
                    bestNeighborFitness = fPlus;
                }

                if (fes >= maxFes) break;

                double[] minus = current.clone();
                minus[i] -= stepSize;

                if (minus[i] < problem.getLowerBound(i))
                    minus[i] = problem.getLowerBound(i);

                double fMinus = problem.evaluate(minus);
                fes++;

                if (fMinus < bestNeighborFitness) {
                    bestNeighbor = minus;
                    bestNeighborFitness = fMinus;
                }

                if (fes >= maxFes) break;
            }

            if (bestNeighborFitness < currentFitness) {
                current = bestNeighbor;
                currentFitness = bestNeighborFitness;

                if (isDebug) {
                    System.out.println("Improved to f = " + currentFitness);
                }

            } else {
                break;
            }
        }

        return new Solution(current, currentFitness);
    }
}
