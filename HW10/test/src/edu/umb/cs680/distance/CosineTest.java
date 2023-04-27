package edu.umb.cs680.distance;

import java.util.List;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CosineTest {

    @Test
    public void testCosineTest() {

        Cosine cosine = new Cosine();

        List<Double> p1 = List.of(40.0, 55.0, 75.0);
        List<Double> p2 = List.of(20.0, 25.0, 30.0);

        double expected = 0.0038242271491688573;
        double actual = cosine.distance(p1, p2);
        assertEquals(expected, actual, 0.00001);
    }
    
}
