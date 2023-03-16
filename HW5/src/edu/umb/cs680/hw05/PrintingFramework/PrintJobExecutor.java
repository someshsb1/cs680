package edu.umb.cs680.hw05.PrintingFramework;


import edu.umb.cs680.hw04.*;

public abstract class PrintJobExecutor {
    
    protected abstract void doAccessControl();

    protected abstract void doPrint();

    protected abstract void doErrorHandling(Exception e);

    protected abstract void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception;
    

    public void execute(PrintJob job, EncryptedString pwd, SecurityContext ctx) throws Exception {
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
    
    public static void main(String args[]) {
        PrintJob job = new PrintJob();
        SecurityContext ModelABC_ctx = new SecurityContext();
        SecurityContext ModelXYZ_ctx = new SecurityContext();
        edu.umb.cs680.hw05.ModelABC.PrintJobExecutor ModelABC_ex = new edu.umb.cs680.hw05.ModelABC.PrintJobExecutor();

         // Running the print job in ModelABC printer
        try {
            ModelABC_ex.execute(job, new EncryptedString("password"), ModelABC_ctx);
            System.out.println("Print job completed successfully in ModelABC context.");
        }  catch (Exception e) {
            System.out.println("An error occurred while executing the print job in ModelABC: " + e.getMessage());
        }
    
        // Running the print job in ModelXYZ printer
        edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor ModelXYZ_ex = new edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor();
        try {
            ModelXYZ_ex.execute(job, new EncryptedString(""), ModelXYZ_ctx);
            System.out.println("Print job completed successfully in ModelXYZ context.");
        } catch (Exception e) {
            System.out.println("An error occurred while executing the print job in ModelXYZ context: " + e.getMessage());
        }
    }

}
