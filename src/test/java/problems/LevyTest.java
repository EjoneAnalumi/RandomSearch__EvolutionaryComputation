package problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LevyTest {

    private static final double TOL = 1e-7;

    private static double[] ones(int d) {
        double[] x = new double[d];
        for (int i = 0; i < d; i++) x[i] = 1.0;
        return x;
    }

    @Test
    void globalMinimum2D() {
        Problem p = new Levy(2);
        assertEquals(0.0, p.evaluate(ones(2)), TOL);
    }

    @Test
    void globalMinimum5D() {
        Problem p = new Levy(5);
        assertEquals(0.0, p.evaluate(ones(5)), TOL);
    }

    @Test
    void globalMinimum10D() {
        Problem p = new Levy(10);
        assertEquals(0.0, p.evaluate(ones(10)), TOL);
    }
}
