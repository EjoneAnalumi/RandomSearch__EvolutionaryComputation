package problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RastriginTest {

    private static final double TOL = 1e-7;

    @Test
    void globalMinimum2D() {
        Problem p = new Rastrigin(2);
        double f = p.evaluate(new double[]{0.0, 0.0});
        assertEquals(0.0, f, TOL);
    }

    @Test
    void globalMinimum5D() {
        Problem p = new Rastrigin(5);
        double f = p.evaluate(new double[5]); // zeros
        assertEquals(0.0, f, TOL);
    }

    @Test
    void globalMinimum10D() {
        Problem p = new Rastrigin(10);
        double f = p.evaluate(new double[10]); // zeros
        assertEquals(0.0, f, TOL);
    }
}
