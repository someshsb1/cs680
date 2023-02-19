package edu.umb.cs680.hw01;

import org.junit.Test;
import static org.junit.Assert.*;


public class PrimeGeneratorTest {
    
    @Test
    public void testPositivePrimeCases() {
    PrimeGenerator gen = new PrimeGenerator(1,20);
    gen.generatePrimes();
    Long[] expected = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L};
    assertArrayEquals(expected, gen.getPrimes().toArray());
    }

    @Test
    public void testInvalidRange() {
        try {
            PrimeGenerator gen = new PrimeGenerator(10, -10);
            gen.generatePrimes();
            fail("Expected a RuntimeException to be thrown");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=" + 10 + " to=" + -10, e.getMessage());
        }
    }

}
