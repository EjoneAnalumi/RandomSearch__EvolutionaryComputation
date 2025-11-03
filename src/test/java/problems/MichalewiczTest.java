package problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MichalewiczTest {

    private static final double TOL = 1e-7;

    @Test
    void globalMinimum2D() {
        Problem p = new Michalewicz(2);
        double[] x = {2.202906, Math.PI / 2.0};
        double f = p.evaluate(x);
        assertEquals(-1.8013034, f, TOL);
    }

    @Test
    void globalMinimum5D() {
        Problem p = new Michalewicz(5);
        double[] x = {
                2.202906, Math.PI / 2.0, 1.284992, 1.923058, 1.720470
        };
        double f = p.evaluate(x);
        assertEquals(-4.6876582, f, TOL);
    }

    @Test
    void globalMinimum10D() {
        Problem p = new Michalewicz(10);
        double[] x = {
                2.202906, Math.PI / 2.0, 1.284992, 1.923058, 1.720470,
                Math.PI / 2.0, 1.454414, 1.756087, 1.655717, Math.PI / 2.0
        };
        double f = p.evaluate(x);
        assertEquals(-9.6601517, f, TOL);
    }
}
