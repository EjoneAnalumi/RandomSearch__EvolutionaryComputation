package app;

import problems.*;
import algorithm.*;

public class HillClimbingMain {
    public static void main(String[] args) {

        Algorithm hc = new HillClimbing(0.01);
        Algorithm hcImproved = new ImprovedHillClimbing(0.01);

        Problem[] problems = {
                new Sphere(2), new Sphere(5), new Sphere(10),
                new Ackley(2), new Ackley(5), new Ackley(10),
//                new Griewank(2), new Griewank(5), new Griewank(10),
//                new Rastrigin(2), new Rastrigin(5), new Rastrigin(10),
//                new Schwefel26(2), new Schwefel26(5), new Schwefel26(10),
//                new Trid(2), new Trid(5), new Trid(10),
//                new StyblinskiTang(2), new StyblinskiTang(5), new StyblinskiTang(10),
//                new Levy(2), new Levy(5), new Levy(10),
                new Michalewicz(2), new Michalewicz(5), new Michalewicz(10),
//                new Bukin(),
//                new CarromTable()
        };

        int runs = 100;

        for (Problem p : problems) {

            double[] results = new double[runs];
            double[] resultsImp = new double[runs];

            int maxFes = 3000 * p.getDimensions();

            for (int r = 0; r < runs; r++) {
                Solution sol1 = hc.execute(p, maxFes, false);
                results[r] = sol1.fitness;

                Solution sol2 = hcImproved.execute(p, maxFes, false);
                resultsImp[r] = sol2.fitness;
            }

            double minHC = StatisticsUtility.getMin(results);
            double avgHC = StatisticsUtility.getAverage(results);
            double stdHC = StatisticsUtility.getStd(results);

            double minImp = StatisticsUtility.getMin(resultsImp);
            double avgImp = StatisticsUtility.getAverage(resultsImp);
            double stdImp = StatisticsUtility.getStd(resultsImp);

            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" Problem: " + p.getName() + " (" + p.getDimensions() + "D)");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            System.out.println("Original HillClimbin: ");
            System.out.println("Min: " + minHC);
            System.out.println("Avg: " + avgHC);
            System.out.println("Std: " + stdHC);

            System.out.println("Improved HillClimbin: ");
            System.out.println("Min: " + minImp);
            System.out.println("Avg: " + avgImp);
            System.out.println("Std: " + stdImp);
        }
    }
}
