package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw04.*;

public class PrintJobExecutor extends edu.umb.cs680.hw09.PrintingFramework.PrintJobExecutor {

    public boolean isLoggedin = false; //initially flag is set to false.

    protected void doAccessControl() {
        //empty

    }

    protected void doPrint() {
        if (!isLoggedin) {
            throw new RuntimeException("User is not logged in");
        }
        // performs printing if the user is logged in / isloggedin = true
            System.out.println("User logged in, printing job in progress");
            PrintJob.execute();
        }

    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception {
        
        try {
            // login / authentication takes place
            ctx.login(pwd);
            // isloggedin is set to true if login authentication is succesfull else exception is thrown
            isLoggedin = true;
        }  catch (Exception e) {
            throw new Exception("Authentication failed: " + e.getMessage());  
        }
    }

    public boolean isLoggedin() {
        return isLoggedin;
    }

    protected void doErrorHandling(Exception e) {
        System.out.println("Exception message, print job unsuccessful.");
    }

    public void setLoggedin(boolean result) {
        this.isLoggedin = result;
    }
    
}

    
