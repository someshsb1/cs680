package edu.umb.cs680.hw14.fs;

import java.time.LocalDateTime;
public class TestFixtureInitializer {

    // separate class that is responsible for creating the test fixture for the File System as per the Note 11, Slide 41
    public static FileSystem createFS() {  

        FileSystem fs = FileSystem.getFileSystem();

        Directory prjRoot = new Directory(null, "prjRoot", 0, LocalDateTime.now(), null);
        Directory src = new Directory(prjRoot, "src", 0, LocalDateTime.now(), null);
        Directory lib = new Directory(prjRoot, "lib", 0, LocalDateTime.now(), null);
        Directory test = new Directory(prjRoot, "test", 0, LocalDateTime.now(), null);
        Directory src2 = new Directory(test, "src", 0, LocalDateTime.now(), null);

        File x = new File(prjRoot, "x", 10, LocalDateTime.now(), null);
        File a = new File(src, "a", 0, LocalDateTime.now(), null);
        File b = new File(src, "b", 0, LocalDateTime.now(), null);
        File c = new File(lib, "c", 0, LocalDateTime.now(), null);
        File d = new File(src2, "d", 0, LocalDateTime.now(), null);

        Link y = new Link(prjRoot, "y", 0, LocalDateTime.now(), src2);

        fs.appendRootDir(prjRoot);
        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        test.appendChild(src2);
        prjRoot.appendChild(x);
        src.appendChild(a);
        src.appendChild(b);
        lib.appendChild(c);
        src2.appendChild(d);
        prjRoot.appendChild(y);

        return fs;
        
    }
    
}
