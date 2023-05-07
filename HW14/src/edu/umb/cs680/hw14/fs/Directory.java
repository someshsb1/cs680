package edu.umb.cs680.hw14.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import edu.umb.cs680.hw14.ReverseAlphabeticalComparatorTest;

public class Directory extends FSElement{
    
    private LinkedList<FSElement> childrens;
    public Directory(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime, target);
        this.childrens = new LinkedList<FSElement>();
    }

    public void accept(FSVisitor v) {
        v.visit(this);
        for (FSElement e: childrens) {
            e.accept(v);
        }
    }

    public Directory getParent() {
        return parent;
    }
    
    public LinkedList<FSElement> getChildren() {
        return childrens;
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator) {
        LinkedList<FSElement> children = new LinkedList<>(childrens);
        Collections.sort(children, comparator);
        return children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void appendChild(FSElement child) {
        childrens.add(child);
        //sort childrens with default alphabetical sorting policy, so childrens always contains alphabetically sorted FS Elements.
        Collections.sort(childrens, new Comparator<FSElement>() {
            public int compare (FSElement fs1, FSElement fs2) {
                return fs1.getName().compareTo(fs2.getName());
            }
        });
    }

    public int countChildren() {
        return childrens.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDirectories = new LinkedList<Directory>();
        for (FSElement child : childrens) {
            if (child instanceof Directory) {
                subDirectories.add((Directory) child);
            }
        }
        return subDirectories;
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> fs) {
        LinkedList<Directory> subDirectories = new LinkedList<>();
        for (FSElement child: childrens) {
            if (child instanceof Directory)
            subDirectories.add((Directory) child);
        }
        Collections.sort(subDirectories, fs);
        return subDirectories;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<File>();
        for (FSElement child : childrens) {
            if(child instanceof File) {
                files.add((File) child);
            }
        }
        return files;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> fs) {
        LinkedList<File> files = new LinkedList<File>();
        for (FSElement child : childrens) {
            if(child instanceof File) {
                files.add((File) child);
            }
        }
        Collections.sort(files, fs);
        return files;
    }

    public int getTotalSize() {
        int size = 0;
        for (FSElement child : childrens) {
            if(child instanceof Directory) {
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
    
    public static void main(String args[]) {

        // Directory prjRoot = new Directory(null, "prjRoot", 0, ldt, null);
        // Directory src = new Directory(prjRoot, "src", 0, ldt,null);
        // Directory lib = new Directory(prjRoot, "lib", 0, ldt,null);
        // Directory test = new Directory(prjRoot, "test", 0, ldt,null);
        // File a = new File(src, "a", 3, ldt,null);
        // File b = new File(src, "b", 4, ldt,null);
        // File c = new File(lib, "c", 10, ldt,null);
        // File x = new File(prjRoot, "x", 5, ldt,null);
        // File d = new File(src, "d", 3, ldt,null);
        
        // prjRoot.appendChild(src);
        // prjRoot.appendChild(lib);
        // prjRoot.appendChild(test);
        // prjRoot.appendChild(x);
        // src.appendChild(a);
        // src.appendChild(b);
        // src.appendChild(d);
        // lib.appendChild(c);

        // System.out.println("Default Alphabetical Sorting policy for Children");
        // for (FSElement fs: src.getChildren((fs1, fs2) -> fs1.getName().compareTo(fs2.getName()))) {
        //     System.out.println(fs.getName());
        //     if (fs instanceof Directory) {
        //         for (FSElement child : ((Directory) fs).getChildren()) {
        //             System.out.println(child.getName());
        //         }
        //     }
        // }
        // System.out.println("Reverse Alphabetical Sorting policy for Subdirectories");
        // for (FSElement fs: prjRoot.getSubDirectories((fs1, fs2) -> fs2.getName().compareTo(fs1.getName()))) {
        //     System.out.println(fs.getName());
        //     if (fs instanceof Directory) {
        //         for (FSElement child : ((Directory) fs).getSubDirectories()) {
        //             System.out.println(child.getName());
        //         }
        //     }
        // }
        // System.out.println("Reverse Alphabetical Sorting policy for files");
        // for (FSElement fs: src.getFiles((fs1, fs2) -> fs2.getName().compareTo(fs1.getName()))) {
        //     System.out.println(fs.getName());
        //     if (fs instanceof Directory) {
        //         for (FSElement child : ((Directory) fs).getFiles()) {
        //             System.out.println(child.getName());
        //         }
        //     }
        // }
        // System.out.println("Sorting by Size policy");
        // for (FSElement fs: src.getFiles((fs1, fs2) -> fs1.getSize() - fs2.getSize())) {
        //     System.out.println(fs.getSize());
        //     if (fs instanceof Directory) {
        //         for (FSElement child : ((Directory) fs).getFiles()) {
        //             System.out.println(child.getSize());
        //         }
        //     }
        // }
    }
}
