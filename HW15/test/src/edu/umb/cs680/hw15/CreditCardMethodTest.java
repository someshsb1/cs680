package edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CreditCardMethodTest {

    CreditCardMethod creditCardMethod;

    @BeforeEach
    public void setUp() {
        creditCardMethod = new CreditCardMethod("Sam Derrick", 1234567890, 231, "12/22");
    }
    
    @Test
    public void assertCardHolderName() {
        String expected = "Sam Derrick";
        String actual = creditCardMethod.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void assertCardHolderNumber() {
        double expected = 1234567890;
        double actual = creditCardMethod.getCardNumber();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void assertCardHolderCVV() {
        int expected = 231;
        int actual = creditCardMethod.getCVV();
        assertEquals(expected, actual);
    }

    @Test
    public void assertCardHolderExpiry() {
        String expected = "12/22";
        String actual = creditCardMethod.getCardExpiry();
        assertEquals(expected, actual);
    }

    @Test
    public void assertPayMethod() {
        int expected = 290;
        creditCardMethod.pay(expected);
        int actual = 290;

        assertEquals(expected, actual);
    }
}
