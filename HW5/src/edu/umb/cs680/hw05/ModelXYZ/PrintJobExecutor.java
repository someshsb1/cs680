package edu.umb.cs680.hw05.ModelXYZ;

import edu.umb.cs680.hw04.*;


public class PrintJobExecutor extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecutor {

    protected void doAccessControl() {
        //empty
    }

    protected void doPrint() {
        System.out.println("printing job in progress");
    }

    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception {
        //empty
        // authentication method is skipped in this model
    }

    protected void doErrorHandling(Exception e) {
        System.out.println("An error occurred while executing the print job.");
    }

   
}
