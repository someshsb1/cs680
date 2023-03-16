package edu.umb.cs680.hw05.ModelXYZ;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw04.EncryptedString;
import edu.umb.cs680.hw04.SecurityContext;

public class ModelXYZTest {

    //doAccessControl is empty for both models
    @Test
    public void doAccessControlTestCase() {
        PrintJobExecutor ex = new PrintJobExecutor();
        try {
            ex.doAccessControl();
        } catch (Exception e) {
            fail("Exception message thrown " + e.getMessage());
        }
    }
    
    @Test
    public void doPrintTestCase() {
        PrintJobExecutor ex = new PrintJobExecutor();
        try {
            ex.doPrint();
        } catch(Exception e) {
            fail("Exception message thrown " + e.getMessage());
        }
    }

    //doAuthentication process is skipped in the ModelXYZ
    @Test
    public void doAuthenticationTestCase() {
        PrintJobExecutor ex = new PrintJobExecutor();
        EncryptedString pwd = new EncryptedString("password123");
        SecurityContext ctx = new SecurityContext();
        try {
            ex.doAuthentication(pwd, ctx);
        } catch (Exception e) {
            fail("Exception message thrown " + e.getMessage());
        }
    }

    @Test
    public void doErrorHandlingTestCase() {
        PrintJobExecutor ex = new PrintJobExecutor();
        Exception exc = new Exception("Testing exception message");
        try {
            ex.doErrorHandling(exc);
        } catch (Exception e) {
            fail("Exception message thrown " + e.getMessage());
        }
    }
}
