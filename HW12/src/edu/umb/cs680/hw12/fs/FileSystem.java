package edu.umb.cs680.hw12.fs;

import java.util.LinkedList;

// <<SINGLETON CLASS>>
public class FileSystem {

    private LinkedList<Directory> rootDirs;
    private static FileSystem ins = null;

    private FileSystem() {
        rootDirs = new LinkedList<Directory>();
    }
    
    public static FileSystem getFileSystem() {
        if (ins == null) {
            ins = new FileSystem();
        }
        return ins;
    }

    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
        
    }

    public void appendRootDir(Directory prjRoot) {
        rootDirs.add(prjRoot);
    }
    
}
