package algorithm;

import problems.Problem;

public class ImprovedHillClimbing extends Algorithm {

    private final double stepSize;

    public ImprovedHillClimbing(double stepSize) {
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

            double bestNeighborFitness = currentFitness;
            double[] bestNeighbor = null;

            if (d == 2) {
                double[][] directions = {
                        { 1,  0},
                        {-1,  0},
                        { 0,  1},
                        { 0, -1},
                        { 1,  1},
                        { 1, -1},
                        {-1,  1},
                        {-1, -1}
                };

                for (double[] dir : directions) {
                    double[] neighbor = current.clone();

                    neighbor[0] += dir[0] * stepSize;
                    neighbor[1] += dir[1] * stepSize;

                    for (int i = 0; i < 2; i++) {
                        if (neighbor[i] < problem.getLowerBound(i))
                            neighbor[i] = problem.getLowerBound(i);
                        if (neighbor[i] > problem.getUpperBound(i))
                            neighbor[i] = problem.getUpperBound(i);
                    }

                    double f = problem.evaluate(neighbor);
                    fes++;
                    if (fes >= maxFes) break;

                    if (f < bestNeighborFitness) {
                        bestNeighborFitness = f;
                        bestNeighbor = neighbor;
                    }
                }

            } else {
                for (int i = 0; i < d && fes < maxFes; i++) {

                    double[] plus = current.clone();
                    plus[i] += stepSize;
                    if (plus[i] < problem.getLowerBound(i))
                        plus[i] = problem.getLowerBound(i);
                    if (plus[i] > problem.getUpperBound(i))
                        plus[i] = problem.getUpperBound(i);

                    double fPlus = problem.evaluate(plus);
                    fes++;

                    if (fPlus < bestNeighborFitness) {
                        bestNeighborFitness = fPlus;
                        bestNeighbor = plus;
                    }
                    if (fes >= maxFes) break;

                    double[] minus = current.clone();
                    minus[i] -= stepSize;
                    if (minus[i] < problem.getLowerBound(i))
                        minus[i] = problem.getLowerBound(i);
                    if (minus[i] > problem.getUpperBound(i))
                        minus[i] = problem.getUpperBound(i);

                    double fMinus = problem.evaluate(minus);
                    fes++;

                    if (fMinus < bestNeighborFitness) {
                        bestNeighborFitness = fMinus;
                        bestNeighbor = minus;
                    }
                }
            }

            if (bestNeighbor == null || bestNeighborFitness >= currentFitness) {
                break;
            }

            current = bestNeighbor;
            currentFitness = bestNeighborFitness;

            if (isDebug) {
                System.out.println("Improved to: " + currentFitness);
            }
        }

        return new Solution(current, currentFitness);
    }
}
