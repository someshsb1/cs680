package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.PrintingFramework.Command;

public class PrintJob implements Command {

    public PrintJob() {

    }

    public static void execute() {
        Printer print = Printer.getInstance();
        print.print();
        System.out.println("Printing in progress");
    }
}
