package problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GriewankTest {

    private static final double TOL = 1e-7;

    @Test
    void globalMinimum2D() {
        Problem p = new Griewank(2);
        double f = p.evaluate(new double[]{0.0, 0.0});
        assertEquals(0.0, f, TOL);
    }

    @Test
    void globalMinimum5D() {
        Problem p = new Griewank(5);
        double f = p.evaluate(new double[5]);
        assertEquals(0.0, f, TOL);
    }

    @Test
    void globalMinimum10D() {
        Problem p = new Griewank(10);
        double f = p.evaluate(new double[10]);
        assertEquals(0.0, f, TOL);
    }
}
