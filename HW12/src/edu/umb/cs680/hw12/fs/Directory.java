package edu.umb.cs680.hw12.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


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

    public LinkedList<FSElement> getChildren(Comparator<FSElement> fs) {
        LinkedList<FSElement> children = new LinkedList<>(childrens);
        Collections.sort(children, fs);
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

        Directory prjRoot = new Directory(null, "prjRoot", 0, LocalDateTime.now(), null);
        Directory src = new Directory(prjRoot, "src", 10, LocalDateTime.now(), null);
        Directory test = new Directory(prjRoot, "test", 20, LocalDateTime.now(), null);
        Directory lib = new Directory(prjRoot, "lib", 20, LocalDateTime.now(), null);

        File a = new File(src, "a", 5, LocalDateTime.now(), null);
        File b = new File(src, "b", 10, LocalDateTime.now(), null);
        File c = new File(test, "c", 15, LocalDateTime.now(), null);
        
        prjRoot.appendChild(test);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(src);
        test.appendChild(c);
        test.appendChild(a);
        test.appendChild(b);

        System.out.println("Default Alphabetical Sorting policy");
        for (FSElement fs: prjRoot.getChildren(new AlphabeticalComparator())) {
            System.out.println(fs.getName());
            if (fs instanceof Directory) {
                for (FSElement child : ((Directory) fs).getChildren()) {
                    System.out.println(child.getName());
                }
            }
        }
    }

}
