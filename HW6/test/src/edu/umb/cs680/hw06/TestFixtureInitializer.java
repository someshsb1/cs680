package edu.umb.cs680.hw06;

import java.time.LocalDateTime;
public class TestFixtureInitializer {


    // separate class that is responsible for creating the test fixture for the File System as per the Note 11, Slide 41
    public static FileSystem createFS() {  

        FileSystem fs = FileSystem.getFileSystem();
        LocalDateTime ldt = LocalDateTime.now();


        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        Directory src = new Directory(prjRoot, "src", 0, ldt);
        Directory lib = new Directory(prjRoot, "lib", 0, ldt);
        Directory test = new Directory(prjRoot, "test", 0, ldt);
        Directory src2 = new Directory(test, "src", 0, ldt);

        File x = new File(prjRoot, "x", 10, ldt);
        File a = new File(src, "a", 0, ldt);
        File b = new File(src, "b", 0, ldt);
        File c = new File(lib, "c", 0, ldt);
        File d = new File(src2, "d", 0, ldt);

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

        return fs;
        
    }
    
}
