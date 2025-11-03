package problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RosenbrockTest {

    private static final double TOL = 1e-7;

    @Test
    void globalMinimum2D() {
        Problem p = new Rosenbrock(2);
        double f = p.evaluate(new double[]{1.0, 1.0});
        assertEquals(0.0, f, TOL);
    }

    @Test
    void globalMinimum5D() {
        Problem p = new Rosenbrock(5);
        double[] x = {1,1,1,1,1};
        double f = p.evaluate(x);
        assertEquals(0.0, f, TOL);
    }

    @Test
    void globalMinimum10D() {
        Problem p = new Rosenbrock(10);
        double[] x = new double[10];
        for (int i = 0; i < x.length; i++) x[i] = 1.0;
        double f = p.evaluate(x);
        assertEquals(0.0, f, TOL);
    }
}
