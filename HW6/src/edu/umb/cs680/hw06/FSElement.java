package edu.umb.cs680.hw06;

import java.time.LocalDateTime;

public class FSElement {
    
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    private Directory parent;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime){
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
        this.parent = parent;
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
        Directory prjRoot = new Directory(null, "prjRoot", 0, LocalDateTime.now());
        Directory src = new Directory(prjRoot, "src", 0, LocalDateTime.now());
        Directory lib = new Directory(prjRoot, "lib", 0, LocalDateTime.now());

        File a = new File(src, "a", 10, LocalDateTime.now());
        File b = new File(src, "b", 20, LocalDateTime.now());
        File c = new File(lib, "c", 30, LocalDateTime.now());

        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        src.appendChild(a);
        src.appendChild(b);
        lib.appendChild(c);
        
        System.out.println("Total Size: " + prjRoot.getTotalSize());
    }
}

