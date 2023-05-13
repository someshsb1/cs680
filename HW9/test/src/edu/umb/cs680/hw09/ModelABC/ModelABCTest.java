package edu.umb.cs680.hw09.ModelABC;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import javax.naming.AuthenticationException;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.SecurityContext.*;
import edu.umb.cs680.hw09.PrintingFramework.Command;


public class ModelABCTest {

    //doAccessControl is empty so we're just doing a general test case
    @Test
    public void doAccessControlTestCase() {
        PrintJobExecutor ex = new PrintJobExecutor(null);
        try {
            ex.doAccessControl();
            System.out.println("doAccessControl");
        } catch (Exception e) {
            fail("Exception message thrown " + e.getMessage());
        }
    }

    @Test
    public void doPrintPositiveTestCase() throws AuthenticationException {
        Command job = new PrintJob();
        SecurityContext ctx = new SecurityContext(null, null);
        ctx.login(null);
        PrintJobExecutor ex = new PrintJobExecutor(ctx);
        if (ctx.isActive()) {
        try {
            ex.doPrint(job);
        } catch (Exception e) {
            fail("Exception message thrown: " + e.getMessage());
        }
    }
    }

    @Test
    public void doPrintNegativeTestCase() {
        Command job = new PrintJob();
        SecurityContext ctx = new SecurityContext(null, null);
        PrintJobExecutor ex = new PrintJobExecutor(ctx);
        try {
            ex.doPrint(job);
            fail("Not an expected exception message");
        } catch (Exception e) {
            assertEquals("User is not logged in", e.getMessage());
        }
    }

    //doAuthentication method checks the login authentication in ModelABC with relevant +ve and +ve test cases
    @Test
    public void doAuthenticationPositiveTestCase() throws AuthenticationException {
        EncryptedString pwd = new EncryptedString();
        SecurityContext ctx = new SecurityContext(null, pwd);
        ctx.login(pwd);
        PrintJobExecutor ex = new PrintJobExecutor(ctx);
        try {
            ex.doAuthentication(pwd, ctx);
            ctx.changeState(LoggedIn.getInstance(ctx));
            assertTrue(ctx.isActive());
        } catch (Exception e) {
            fail("Exception message thrown: " + e.getMessage());
        }
    }

    @Test
    public void doAuthenticationNegativeTestCase() {
    EncryptedString pwd = new EncryptedString();
    SecurityContext ctx = new SecurityContext(null, pwd);
    PrintJobExecutor ex = new PrintJobExecutor(ctx);
    try {
        ex.doAuthentication(pwd, ctx);
    } catch (Exception e) {
        assertEquals("Authentication failed: ", e.getMessage());
    }
}


    @Test
    public void doErrorHandlingTestCase() {
        PrintJobExecutor ex = new PrintJobExecutor(null);
        Exception e = new Exception("Test message exception call");
        try {
            ex.doErrorHandling(e);
        } catch (Exception ee) {
            fail("Exception message thrown: " + ee.getMessage());
        }
    }
}


