package edu.umb.cs680.hw09.PrintingFramework;

import javax.naming.AuthenticationException;

import edu.umb.cs680.SecurityContext.*;

import edu.umb.cs680.hw09.ModelABC.*;


public abstract class PrintJobExecutor {

    protected EncryptedString password;
    protected abstract void doAccessControl();

    protected abstract void doPrint(Command job);

    protected abstract void doErrorHandling(Exception e);

    protected abstract void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws AuthenticationException;
    
    public void execute(Command job, EncryptedString pwd, SecurityContext ctx) throws AuthenticationException {
        try {
            //template method implements common printing flow
            doAuthentication(pwd, ctx);
            doAccessControl();
            doPrint(job);
            
        } catch (AuthenticationException e) {
            // Abort the current print job if authentication fails
            doErrorHandling(e);
            throw e;
        } 
    }
    
    public static void main(String args[]) throws Exception {
        Command job = new PrintJob();
        User user = null;
        EncryptedString password = null;
        SecurityContext ModelABC_ctx = new SecurityContext(user, password);
        ModelABC_ctx.login(new EncryptedString()); //logging in
        edu.umb.cs680.hw09.ModelABC.PrintJobExecutor ex = new edu.umb.cs680.hw09.ModelABC.PrintJobExecutor(ModelABC_ctx);
        ex.execute(job, password, ModelABC_ctx);//call to printjob after successful login.
    }
}
