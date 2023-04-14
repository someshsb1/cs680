package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.fs.*;
import edu.umb.cs680.hw08.fs.util.FileCrawlingVisitor;

public class FileCrawlingVisitorTest {

    @Test
    public void getFileNameTest() {

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

        LinkedList<String> exp = new LinkedList<String>();
        exp.add("a");
        exp.add("b");
        exp.add("c");

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        prjRoot.accept(visitor);

        LinkedList<String> act = visitor.getFileName();
        assertEquals(exp, act);

    }
    
}
