package edu.umb.cs680.hw14.fs.util;

import java.util.LinkedList;

import edu.umb.cs680.hw14.fs.Directory;
import edu.umb.cs680.hw14.fs.FSVisitor;
import edu.umb.cs680.hw14.fs.File;
import edu.umb.cs680.hw14.fs.Link;

public class FileCrawlingVisitor implements FSVisitor {

    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    private LinkedList<File> files;

    public FileCrawlingVisitor() {
        files = new LinkedList<File>();
    }

    @Override
    public void visit(File file) {
        
        files.add(file);
    }

    public LinkedList<File> getFiles() {
        return files;
        
    }  
    
    public LinkedList<String> getFileName() {
        LinkedList<String> fileName = new LinkedList<String>();
        for(File file: files) {
            fileName.add(file.getName());
        }
        return fileName;
    }
}
