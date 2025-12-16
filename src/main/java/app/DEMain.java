package app;

import algorithm.*;
import problems.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class DEMain {

    public static void main(String[] args) throws IOException {

        Locale.setDefault(Locale.US);

        String surname = "Analumi";

        int[] dims = {10, 20, 30};
        int runs = 50;

        int NP = 20;
        double CR = 0.5;
        double F = 0.6;

        Algorithm de = new DifferentialEvolution(NP, CR, F);

        Problem[] prototypes = new Problem[] {
                new Sphere(1), new Ackley(1), new Griewank(1), new Rastrigin(1),
                new Schwefel26(1), new Trid(1), new StyblinskiTang(1), new Levy(1),
                new Michalewicz(1)
        };

        File resultsDir = new File("results");
        if (!resultsDir.exists()) resultsDir.mkdirs();

        for (Problem proto : prototypes) {
            for (int d : dims) {

                String problemName = proto.getName();
                String fileName = "DE-" + surname + "_" + problemName + "D" + d + ".txt";
                File outFile = new File(resultsDir, fileName);

                try (FileWriter fw = new FileWriter(outFile)) {

                    for (int r = 0; r < runs; r++) {

                        Problem p = makeProblem(problemName, d);

                        int maxFes = 3000 * d;
                        Solution sol = de.execute(p, maxFes, false);

                        double val = sol.fitness;

                        if (Double.isNaN(val) || Double.isInfinite(val)) {
                            val = 1e308;
                        }

                        fw.write(Double.toString(val));
                        fw.write("\n");
                    }
                }

                System.out.println("Wrote: results/" + fileName);
            }
        }
    }

    private static Problem makeProblem(String name, int d) {
        return switch (name) {
            case "Sphere" -> new Sphere(d);
            case "Ackley" -> new Ackley(d);
            case "Griewank" -> new Griewank(d);
            case "Rastrigin" -> new Rastrigin(d);
            case "Schwefel26" -> new Schwefel26(d);
            case "Trid" -> new Trid(d);
            case "StyblinskiTang" -> new StyblinskiTang(d);
            case "Levy" -> new Levy(d);
            case "Michalewicz" -> new Michalewicz(d);
            default -> throw new IllegalArgumentException("Unknown problem: " + name);
        };
    }
}
