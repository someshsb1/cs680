package edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class WalletMethodTest {
    WalletMethod walletMethod;

    @BeforeEach
    public void setUp() {
        walletMethod = new WalletMethod("1234SAAB");
    }
    
    @Test
    public void assertVenmoWalletName() {
        String expected = "1234SAAB";
        String actual = walletMethod.getVenmo();
        assertEquals(expected, actual);
    }

    @Test
    public void assertPayPalMethod() {
        int expected = 100;
        walletMethod.pay(expected);
        int actual = 100;
        assertEquals(expected, actual);
    }
}
