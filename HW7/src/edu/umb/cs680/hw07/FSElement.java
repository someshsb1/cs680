package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class FSElement {
    
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    private Directory parent;
    FSElement target;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target){
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
        this.parent = parent;
        this.target = target;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isDirectory() {
        return false;
        
    }

    public boolean isFile() {
        return false;
    }

    public boolean isLink() {
        return false;
    }

    public Directory getParent() {
        return parent;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public static void main(String args[]) {
        
        System.out.println("File System with Link Implemented");
    }
}

