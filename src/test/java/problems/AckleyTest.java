package problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AckleyTest {

    private static final double TOL = 1e-7;

    @Test
    void globalMinimum2D() {
        Problem p = new Ackley(2);
        double f = p.evaluate(new double[]{0.0, 0.0});
        assertEquals(0.0, f, TOL);
    }

    @Test
    void globalMinimum5D() {
        Problem p = new Ackley(5);
        double[] x = new double[5]; // all zeros
        double f = p.evaluate(x);
        assertEquals(0.0, f, TOL);
    }

    @Test
    void globalMinimum10D() {
        Problem p = new Ackley(10);
        double[] x = new double[10]; // all zeros
        double f = p.evaluate(x);
        assertEquals(0.0, f, TOL);
    }
}
