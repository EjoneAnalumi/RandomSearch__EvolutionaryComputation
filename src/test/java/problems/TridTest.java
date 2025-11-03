package problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TridTest {

    private static final double TOL = 1e-7;

    private static double[] tridOptimumPoint(int d) {
        double[] x = new double[d];
        // x_i* = i * (d + 1 - i), with i starting at 1
        for (int i = 0; i < d; i++) {
            int i1 = i + 1;
            x[i] = i1 * (d + 1 - i1);
        }
        return x;
    }

    private static double tridOptimumValue(int d) {
        // f* = - d(d+4)(d-1) / 6
        return - (d * (d + 4.0) * (d - 1.0)) / 6.0;
    }

    @Test
    void globalMinimum2D() {
        int d = 2;
        Problem p = new Trid(d);
        double f = p.evaluate(tridOptimumPoint(d));
        assertEquals(tridOptimumValue(d), f, TOL);
    }

    @Test
    void globalMinimum5D() {
        int d = 5;
        Problem p = new Trid(d);
        double f = p.evaluate(tridOptimumPoint(d));
        assertEquals(tridOptimumValue(d), f, TOL);
    }

    @Test
    void globalMinimum10D() {
        int d = 10;
        Problem p = new Trid(d);
        double f = p.evaluate(tridOptimumPoint(d));
        assertEquals(tridOptimumValue(d), f, TOL);
    }
}
