package edu.umb.cs680.hw14.fs;

public interface FSVisitor {

    public void visit(Link link);
    public void visit(Directory dir);
    public void visit(File file);
    
}
