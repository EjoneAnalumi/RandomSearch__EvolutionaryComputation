package problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StyblinskiTangTest {
    private static final double TOL = 1e-7;
    private static final double XSTAR = -2.90353401818596;
    private static final double F_PER_DIM = -39.16616570377142;

    private static double[] vector(int d, double value) {
        double[] x = new double[d];
        for (int i = 0; i < d; i++) x[i] = value;
        return x;
    }

    @Test
    void globalMinimum2D() {
        int d = 2;
        Problem p = new StyblinskiTang(d);
        double f = p.evaluate(vector(d, XSTAR));
        assertEquals(F_PER_DIM * d, f, TOL);
    }

    @Test
    void globalMinimum5D() {
        int d = 5;
        Problem p = new StyblinskiTang(d);
        double f = p.evaluate(vector(d, XSTAR));
        assertEquals(F_PER_DIM * d, f, TOL);
    }

    @Test
    void globalMinimum10D() {
        int d = 10;
        Problem p = new StyblinskiTang(d);
        double f = p.evaluate(vector(d, XSTAR));
        assertEquals(F_PER_DIM * d, f, TOL);
    }
}
