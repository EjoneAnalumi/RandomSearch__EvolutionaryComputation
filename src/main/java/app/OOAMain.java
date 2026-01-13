package app;

import algorithm.Algorithm;
import algorithm.OspreyOptimizationAlgorithm;
import algorithm.Solution;
import problems.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class OOAMain {

    private static final int RUNS = 50;
    private static final int POP_SIZE = 20;
    private static final String SURNAME = "Analumi";

    public static void main(String[] args) throws IOException {

        Locale.setDefault(Locale.US);

        int[] dims = {10, 20, 30};

        for (int d : dims) {

            Problem[] problems = new Problem[]{
                    new Sphere(d),
                    new Ackley(d),
                    new Griewank(d),
                    new Rastrigin(d),
                    new Schwefel26(d),
                    new Trid(d),
                    new StyblinskiTang(d),
                    new Levy(d),
                    new Michalewicz(d),
                    new Rosenbrock(d)
            };

            for (Problem p : problems) {

                int maxFes = 3000 * d;
                double[] results = new double[RUNS];

                for (int r = 0; r < RUNS; r++) {
                    Algorithm ooa = new OspreyOptimizationAlgorithm(POP_SIZE);
                    Solution sol = ooa.execute(p, maxFes, false);
                    results[r] = sol.fitness;
                }

                writeFile(results,
                        "OOA-" + SURNAME + "_" + p.getName() + "D" + d + ".txt");

                System.out.println("Wrote: OOA-" + SURNAME + "_" + p.getName() + "D" + d);
            }
        }
    }

    private static void writeFile(double[] values, String name) throws IOException {
        File dir = new File("results");
        if (!dir.exists()) dir.mkdirs();

        try (FileWriter fw = new FileWriter(new File(dir, name))) {
            for (double v : values) {
                fw.write(Double.toString(v));
                fw.write("\n");
            }
        }
    }
}
