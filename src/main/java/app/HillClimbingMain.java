package app;

import problems.*;
import algorithm.*;

public class HillClimbingMain {
    public static void main(String[] args) {

        Algorithm hc = new HillClimbing(0.01);

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
            int maxFes = 3000 * p.getDimensions();

            for (int r = 0; r < runs; r++) {
                Solution sol = hc.execute(p, maxFes, false);
                results[r] = sol.fitness;
            }

            double min = StatisticsUtility.getMin(results);
            double avg = StatisticsUtility.getAverage(results);
            double std = StatisticsUtility.getStd(results);

            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" Problem: " + p.getName() + " (" + p.getDimensions() + "D)");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Min: " + min);
            System.out.println("Avg: " + avg);
            System.out.println("Std: " + std);
        }
    }
}
