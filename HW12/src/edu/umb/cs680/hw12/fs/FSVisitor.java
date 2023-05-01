package edu.umb.cs680.hw12.fs;

public interface FSVisitor {

    public void visit(Link link);
    public void visit(Directory dir);
    public void visit(File file);
    
}
