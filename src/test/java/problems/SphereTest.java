package problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SphereTest {
    private static final double TOLERANCE = 1e-7;

    @Test
    public void testGlobalOptimum2D() {
        Sphere s = new Sphere(2);
        double[] x = {0.0, 0.0};
        assertEquals(0.0, s.evaluate(x), TOLERANCE);
    }

    @Test
    public void testGlobalOptimum5D() {
        Sphere s = new Sphere(5);
        double[] x = {0, 0, 0, 0, 0};
        assertEquals(0.0, s.evaluate(x), TOLERANCE);
    }

    @Test
    public void testGlobalOptimum10D() {
        Sphere s = new Sphere(10);
        double[] x = new double[10];
        assertEquals(0.0, s.evaluate(x), TOLERANCE); }
}