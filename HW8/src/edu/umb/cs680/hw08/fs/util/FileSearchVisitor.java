package edu.umb.cs680.hw08.fs.util;

import java.util.LinkedList;

import edu.umb.cs680.hw08.fs.*;

public class FileSearchVisitor implements FSVisitor {

    String fileName;

    LinkedList<File> foundFiles;

    public FileSearchVisitor(String fileName) {
        this.fileName = fileName;
        this.foundFiles = new LinkedList<File>();
    }
 
    public void visit(Link link) {

        return;

    }
    public void visit(Directory dir) {

        return;

    }
    public void visit(File file) {

        if (file.getName().equals(fileName)) 
            foundFiles.add(file);
        
    }

    public LinkedList<File> getFoundFiles() {
        return foundFiles;

    }
    
}
