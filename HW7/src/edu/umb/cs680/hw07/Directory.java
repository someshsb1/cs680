package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{
    
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;

    private LinkedList<FSElement> childrens;
    private Directory parent;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime, target);
        this.name = name;
        this.size = size;
        this.parent = parent;
        this.creationTime = creationTime;

        childrens = new LinkedList<FSElement>();
    }
        
    public Directory getParent() {
        return parent;
    }
    
    public LinkedList<FSElement> getChildren() {
        return childrens;
        
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void appendChild(FSElement child) {
        childrens.add(child);
    }

    public int countChildren() {
        return childrens.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDirectories = new LinkedList<Directory>();
        for (FSElement child : childrens) {
            if (child.isDirectory()) {
                subDirectories.add((Directory) child);
            }
        }
        return subDirectories;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<File>();
        for (FSElement child : childrens) {
            if(child.isFile()) {
                files.add((File) child);
            }
        }
        return files;
    }

    public int getTotalSize() {
        int size = 0;
        for (FSElement child : childrens) {
            if(child.isDirectory()) {
                size += ((Directory) child).getTotalSize();
            } else {
                size += child.getSize();
            }
        }
        return size;
    }

    public boolean isDirectory() {
        return true;
    }

    public boolean isLink() {
        return false;
    }

    //to capture the name of the subdirectories under the parent
    public Directory subDirectoryName(String name) {
        for (FSElement fs: childrens) {
            if (fs instanceof Directory && fs.getName().equals(name)) {
                return (Directory) fs;
            }
        }
        return null;
    }
    
}
