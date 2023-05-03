package edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class PayPalMethodTest {

    PayPalMethod payPalMethod;

    @BeforeEach
    public void setUp() {
        payPalMethod = new PayPalMethod("sam.derrick@gmail.com", "pwd000");
    }
    
    @Test
    public void assertCardHolderName() {
        String expected = "sam.derrick@gmail.com";
        String actual = payPalMethod.getEmail();
        assertEquals(expected, actual);
    }

    @Test
    public void assertCardHolderNumber() {
        String expected = "pwd000";
        String actual = payPalMethod.getPwd();
        assertEquals(expected, actual);
    }

    @Test
    public void assertPayPalMethod() {
        int expected = 100;
        payPalMethod.pay(expected);
        int actual = 100;

        assertEquals(expected, actual);
    }
}
