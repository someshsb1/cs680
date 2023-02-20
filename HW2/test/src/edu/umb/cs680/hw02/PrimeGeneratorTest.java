package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {
    private static SingletonPrimeGenerator instance1;
    private static SingletonPrimeGenerator instance2;

    @BeforeAll
    public static void setUp() {
        instance1 = SingletonPrimeGenerator.getInstance(1, 100);
        instance2 = SingletonPrimeGenerator.getInstance(1, 100);
    }

    @Test
    public void testGetInstanceNonNullValue() {

        assertNotNull(instance1);

    }

    @Test
    public void testIdenticalInstances() {
        
        assertSame(instance1, instance2);

    }

    @Test
    public void testGetPrimesReturnsExpectedResult() {
        instance1.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L};
        assertIterableEquals(instance1.getPrimes(), List.of(expectedPrimes));
    }

    @Test
    public void testInstanceWithInvalidRange() {
        try {
            SingletonPrimeGenerator.getInstance(-10, 10);
            fail("Expected RuntimeException to be thrown");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("Invalid range"));
        }

    }
}


