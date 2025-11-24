package algorithm;

import problems.Problem;
import java.util.ArrayList;
import java.util.List;

public class ImprovedHillClimbing extends Algorithm {

    private double stepSize;

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

        if (isDebug)
            System.out.println("Start: " + currentFitness);

        while (fes < maxFes) {

            double bestFitness = currentFitness;
            double[] bestNeighbor = null;

            List<double[]> directionVectors = generateDirectionVectors(d);

            for (double[] dir : directionVectors) {

                double[] neighbor = current.clone();
                for (int i = 0; i < d; i++) {
                    neighbor[i] += dir[i] * stepSize;

                    if (neighbor[i] < problem.getLowerBound(i))
                        neighbor[i] = problem.getLowerBound(i);

                    if (neighbor[i] > problem.getUpperBound(i))
                        neighbor[i] = problem.getUpperBound(i);
                }

                double f = problem.evaluate(neighbor);
                fes++;

                if (f < bestFitness) {
                    bestFitness = f;
                    bestNeighbor = neighbor;
                }

                if (fes >= maxFes)
                    break;
            }

            if (bestNeighbor == null) break;

            current = bestNeighbor;
            currentFitness = bestFitness;

            if (isDebug)
                System.out.println("Improved to: " + currentFitness);
        }

        return new Solution(current, currentFitness);
    }

    private List<double[]> generateDirectionVectors(int d) {
        List<double[]> dirs = new ArrayList<>();
        int total = (int) Math.pow(3, d);

        for (int mask = 0; mask < total; mask++) {
            double[] vec = new double[d];
            int tmp = mask;
            boolean allZero = true;

            for (int i = 0; i < d; i++) {
                int val = tmp % 3;
                tmp /= 3;

                if (val == 0) vec[i] = -1;
                else if (val == 1) vec[i] = 0;
                else vec[i] = +1;

                if (vec[i] != 0) allZero = false;
            }

            if (!allZero) dirs.add(vec);
        }

        return dirs;
    }
}
