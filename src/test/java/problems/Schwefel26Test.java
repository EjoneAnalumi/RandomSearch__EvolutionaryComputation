package problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Schwefel26Test {

    private static final double TOL = 1e-7;
    private static final double XSTAR = 420.9687462275036;

    @Test
    void globalMinimum2D() {
        Problem p = new Schwefel26(2);
        double[] x = {XSTAR, XSTAR};
        double f = p.evaluate(x);
        assertEquals(0.0, f, TOL);
    }

    @Test
    void globalMinimum5D() {
        Problem p = new Schwefel26(5);
        double[] x = new double[5];
        for (int i = 0; i < x.length; i++) x[i] = XSTAR;
        double f = p.evaluate(x);
        assertEquals(0.0, f, TOL);
    }

    @Test
    void globalMinimum10D() {
        Problem p = new Schwefel26(10);
        double[] x = new double[10];
        for (int i = 0; i < x.length; i++) x[i] = XSTAR;
        double f = p.evaluate(x);
        assertEquals(0.0, f, TOL);
    }
}
