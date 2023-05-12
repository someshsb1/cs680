package edu.umb.cs680.hw09.ModelABC;

import javax.naming.AuthenticationException;

import edu.umb.cs680.SecurityContext.*;
import edu.umb.cs680.hw09.PrintingFramework.Command;

public class PrintJobExecutor extends edu.umb.cs680.hw09.PrintingFramework.PrintJobExecutor {
    SecurityContext ctx;
    
    public PrintJobExecutor(SecurityContext ctx) {
        this.ctx = ctx;
    }
    
    protected void doAccessControl() {
        //empty

    }

    protected void doPrint(Command job) {
        if (!ctx.isActive()) {
            throw new RuntimeException("User is not logged in");
        } else
        // performs printing if the user is logged in
            System.out.println("User logged in, printing job in progress");
            job.execute();
        }

    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws AuthenticationException {
            if(ctx.isActive())
            // login / authentication takes place
            ctx.login(pwd);        
    }

    protected void doErrorHandling(Exception e) {
        System.out.println("Exception message, print job unsuccessful.");
    }

    
}

    
