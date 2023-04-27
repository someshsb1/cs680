package edu.umb.cs680.hw09.PrintingFramework;

import edu.umb.cs680.hw04.*;
import edu.umb.cs680.hw09.ModelABC.*;


public abstract class PrintJobExecutor {
    private static User user;
    static EncryptedString password;
    
    protected abstract void doAccessControl();

    protected abstract void doPrint();

    protected abstract void doErrorHandling(Exception e);

    protected abstract void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception;
    
    public void execute(Command job, EncryptedString pwd, SecurityContext ctx) throws Exception {
        try {
            //template method implements common printing flow
            doAuthentication(pwd, ctx);
            doAccessControl();
            doPrint();
            
        } catch (Exception e) {
            // Abort the current print job if authentication fails
            doErrorHandling(e);
            throw e;
        } 
    }
    
    public static void main(String args[]) throws Exception {
        Command job = new PrintJob();
        
        EncryptedString password = new EncryptedString("password");
        SecurityContext ModelABC_ctx = new SecurityContext(user, password);

        //  // Running the print job in ModelABC printer
        // try {
        //     ModelABC_ex.execute(job, new EncryptedString("password"), ModelABC_ctx);
        //     System.out.println("Print job completed successfully in ModelABC context.");
        // }  catch (Exception e) {
        //     System.out.println("An error occurred while executing the print job in ModelABC: " + e.getMessage());
        // }

        edu.umb.cs680.hw09.ModelABC.PrintJobExecutor ex = new edu.umb.cs680.hw09.ModelABC.PrintJobExecutor();
            ex.execute(job, password, ModelABC_ctx);
            
    }

}
