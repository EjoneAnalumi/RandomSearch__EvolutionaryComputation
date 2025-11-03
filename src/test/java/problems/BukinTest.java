package problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BukinTest {
    private static final double TOL = 1e-7;

    @Test
    void globalMinimum() {
        Problem p = new Bukin();
        double f = p.evaluate(new double[]{-10.0, 1.0});
        assertEquals(0.0, f, TOL);
    }
}
