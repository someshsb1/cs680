package edu.umb.cs680.hw05.ModelABC;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw04.EncryptedString;
import edu.umb.cs680.hw04.SecurityContext;

public class ModelABCTest {

    //doAccessControl is empty is we're just doing a general test case
    @Test
    void doAccessControlTestCase() {
        PrintJobExecutor ex = new PrintJobExecutor();
        try {
            ex.doAccessControl();
        } catch (Exception e) {
            fail("Exception message thrown " + e.getMessage());
        }
    }

    @Test
    void doPrintPositiveTestCase() {
        PrintJobExecutor ex = new PrintJobExecutor();
        ex.setLoggedin(true);
        try {
            ex.doPrint();
        } catch (Exception e) {
            fail("Exception message thrown: " + e.getMessage());
        }
    }

    @Test
    void doPrintNegativeTestCase() {
        PrintJobExecutor ex = new PrintJobExecutor();
        try {
            ex.doPrint();
            fail("Not an expected exception message");
        } catch (Exception e) {
            assertEquals("User is not logged in", e.getMessage());
        }
    }

    //doAuthentication method checks the login authentication in ModelABC with relevant +ve and +ve test cases
    @Test
    void doAuthenticationPositiveTestCase() {
        PrintJobExecutor ex = new PrintJobExecutor();
        EncryptedString pwd = new EncryptedString("password");
        SecurityContext ctx = new SecurityContext();
        try {
            ex.doAuthentication(pwd, ctx);
            assertTrue(ex.isLoggedin());
        } catch (Exception e) {
            fail("Exception message thrown: " + e.getMessage());
        }
    }

    @Test
    void doAuthenticationNegativeTestCase() {
    PrintJobExecutor ex = new PrintJobExecutor();
    EncryptedString pwd = new EncryptedString("incorrect pwd");
    SecurityContext ctx = new SecurityContext();

    try {
        ex.doAuthentication(pwd, ctx);
    } catch (Exception e) {
        assertEquals("Authentication failed: ", e.getMessage());
    }
}


    @Test
    void doErrorHandlingTestCase() {
        PrintJobExecutor ex = new PrintJobExecutor();
        Exception e = new Exception("Test message exception call");
        try {
            ex.doErrorHandling(e);
        } catch (Exception ee) {
            fail("Exception message thrown: " + ee.getMessage());
        }
    }


}


