package edu.umb.cs680.distance;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ManhattanTest {

    @Test
    public void testManhattanDistance() {
        
        Manhattan manhattan = new Manhattan();

        List<Double> p1 = new ArrayList<>();
        List<Double> p2 = new ArrayList<>();

        p1.add(5.0);
        p1.add(8.0);
        p1.add(12.0);

        p2.add(10.0);
        p2.add(15.0);
        p2.add(20.0);

        double expected = 20.0;
        double actual = manhattan.distance(p1, p2);
        assertEquals(expected, actual, 0.0001);
    }
}
