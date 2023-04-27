package edu.umb.cs680.hw09.ModelABC;


//<< SINGLETON CLASS >>
public class Printer {

    private static Printer instance = null;

    private Printer() {}
    
    public void print() {
        
    }

    public static Printer getInstance() {
        if (instance == null) {
            instance = new Printer();
        }

        return instance;
    }
}
