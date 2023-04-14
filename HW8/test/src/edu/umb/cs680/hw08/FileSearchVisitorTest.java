package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.fs.*;
import edu.umb.cs680.hw08.fs.util.FileSearchVisitor;

public class FileSearchVisitorTest {

    @Test
    public void fileSearchForExistingFileInTheDirectory() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, LocalDateTime.now(), null);
        Directory src = new Directory(prjRoot, "src", 0, LocalDateTime.now(), null);
        Directory lib = new Directory(prjRoot, "lib", 0, LocalDateTime.now(), null);
        Directory test = new Directory(prjRoot, "test", 0, LocalDateTime.now(), null);
        Directory src1 = new Directory(test, "src", 0, LocalDateTime.now(), null);
        File a = new File(src, "a", 10, LocalDateTime.now(), null);
        File b = new File(src, "b", 20, LocalDateTime.now(), null);
        File c = new File(lib, "c", 30, LocalDateTime.now(), null);
        Link y = new Link(prjRoot, "y", 0, LocalDateTime.now(), src1);
    
        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        test.appendChild(src1);
        src.appendChild(a);
        src.appendChild(b);
        lib.appendChild(c);
        src1.appendChild(y);

        FileSearchVisitor visitor = new FileSearchVisitor("a");
        prjRoot.accept(visitor);

        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals(a, foundFiles.get(0));
    }

    @Test
    public void fileSearchForNonExistingFileInTheDirectory() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, LocalDateTime.now(), null);
        Directory src = new Directory(prjRoot, "src", 0, LocalDateTime.now(), null);
        Directory lib = new Directory(prjRoot, "lib", 0, LocalDateTime.now(), null);
        Directory test = new Directory(prjRoot, "test", 0, LocalDateTime.now(), null);
        Directory src1 = new Directory(test, "src", 0, LocalDateTime.now(), null);
        File a = new File(src, "a", 10, LocalDateTime.now(), null);
        File b = new File(src, "b", 20, LocalDateTime.now(), null);
        File c = new File(lib, "c", 30, LocalDateTime.now(), null);
        Link y = new Link(prjRoot, "y", 0, LocalDateTime.now(), src1);
    
        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        test.appendChild(src1);
        src.appendChild(a);
        src.appendChild(b);
        lib.appendChild(c);
        src1.appendChild(y);

        FileSearchVisitor visitor = new FileSearchVisitor("d");
        prjRoot.accept(visitor);

        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(0, foundFiles.size());
    }

    @Test
    public void fileSearchExistingFileInTheDirectoryWithSubdirectories() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, LocalDateTime.now(), null);
        Directory src = new Directory(prjRoot, "src", 0, LocalDateTime.now(), null);
        Directory lib = new Directory(prjRoot, "lib", 0, LocalDateTime.now(), null);
        Directory test = new Directory(prjRoot, "test", 0, LocalDateTime.now(), null);
        Directory src1 = new Directory(test, "src", 0, LocalDateTime.now(), null);
        File a = new File(src, "a", 10, LocalDateTime.now(), null);
        File b = new File(src, "b", 20, LocalDateTime.now(), null);
        File c = new File(lib, "c", 30, LocalDateTime.now(), null);
        Link y = new Link(prjRoot, "y", 0, LocalDateTime.now(), src1);
    
        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        test.appendChild(src1);
        src.appendChild(a);
        src.appendChild(b);
        lib.appendChild(c);
        src1.appendChild(y);

        FileSearchVisitor visitor = new FileSearchVisitor("b");
        prjRoot.accept(visitor);

        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals(b, foundFiles.get(0));
    }
    
}
