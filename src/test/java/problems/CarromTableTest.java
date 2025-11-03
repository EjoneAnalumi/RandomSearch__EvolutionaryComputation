package problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarromTableTest {
    private static final double TOL = 1e-7;

    @Test
    void globalMinimum() {
        Problem p = new CarromTable();
        double f = p.evaluate(new double[]{Math.PI, Math.PI});
        assertEquals(0.0, f, TOL);
    }
}
