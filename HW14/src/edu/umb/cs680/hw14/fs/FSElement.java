package edu.umb.cs680.hw14.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;

import edu.umb.cs680.hw14.fs.util.CountingVisitor;
import edu.umb.cs680.hw14.fs.util.FileCrawlingVisitor;
import edu.umb.cs680.hw14.fs.util.FileSearchVisitor;

public class FSElement {

    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    protected Directory parent;
    FSElement target;

    

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
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

    public void accept(FSVisitor v) {

    }

    public static void main(String args[]) {
        Directory prjRoot = new Directory(null, "prjRoot", 0, LocalDateTime.now(), null);
        Directory src = new Directory(prjRoot, "src", 0, LocalDateTime.now(), null);
        Directory lib = new Directory(prjRoot, "lib", 0, LocalDateTime.now(), null);
        Directory test = new Directory(prjRoot, "test", 0, LocalDateTime.now(), null);
        Directory src1 = new Directory(test, "src", 0, LocalDateTime.now(), null);
        File a = new File(src, "a", 10, LocalDateTime.now(), null);
        File b = new File(src, "b", 20, LocalDateTime.now(), null);
        File c = new File(lib, "c", 30, LocalDateTime.now(), null);
        Link y = new Link(prjRoot, "y", 0, LocalDateTime.now(), src);

        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        test.appendChild(src1);
        src.appendChild(a);
        src.appendChild(b);
        lib.appendChild(c);
        src1.appendChild(y);
        
        System.out.println("Total Size: " + prjRoot.getTotalSize());
        System.out.println("Parent: " + a.getParent().getName());
        
        FileSearchVisitor visitor = new FileSearchVisitor("b");
        prjRoot.accept(visitor);
        System.out.println("Visitor Size: " + visitor.getFoundFiles().size());

        FileSearchVisitor visitor1 = new FileSearchVisitor("c");
        src.accept(visitor1);
        System.out.println("Visitor Size: " + visitor1.getFoundFiles().size());

        FileCrawlingVisitor visitor2 = new FileCrawlingVisitor();
        prjRoot.accept(visitor2);
        LinkedList<String> fileNames = visitor2.getFileName();
        System.out.println("Visitor Files: " + fileNames);

        CountingVisitor visitor3 = new CountingVisitor();
        prjRoot.accept(visitor3);
        System.out.println("Dir Count: " + visitor3.getDirNum());
        System.out.println("File Count: " + visitor3.getFileNum());
        System.out.println("Link Count: " + visitor3.getLinkNum());
    }
}
