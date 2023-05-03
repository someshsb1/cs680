package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw14.fs.*;

public class SizeComparatorTest {

    private static LocalDateTime ldt = LocalDateTime.now();
    
    static Directory prjRoot = new Directory(null, "prjRoot", 0, ldt, null);
    static Directory src = new Directory(prjRoot, "src", 0, ldt,null);
    static Directory lib = new Directory(prjRoot, "lib", 0, ldt,null);
    static Directory test = new Directory(prjRoot, "test", 0, ldt,null);
    static File a = new File(src, "a", 1, ldt,null);
    static File b = new File(src, "b", 3, ldt,null);
    static File c = new File(lib, "c", 2, ldt,null);
    static File x = new File(prjRoot, "x", 8, ldt,null);
    static File d = new File(src, "d", 6, ldt,null);

    
    @BeforeAll
    public static void setUp() {
       
    prjRoot.appendChild(src);
    prjRoot.appendChild(lib);
    prjRoot.appendChild(test);
    prjRoot.appendChild(x);
    src.appendChild(a);
    src.appendChild(b);
    src.appendChild(d);
    lib.appendChild(c);
    
    }

    @Test
    public void assertSizeComparatorGetChildrenTest() {
        List<FSElement> fs = prjRoot.getChildren((fs1, fs2) -> fs1.getSize() - fs2.getSize());
        FSElement [] expected = {lib, src, test, x};
        FSElement [] actual = fs.toArray(new FSElement[fs.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void assertSizeComparatorForGetFileTest() {
        LinkedList<File> fs = prjRoot.getFiles((fs1, fs2) -> fs1.getSize() - fs2.getSize());
        FSElement [] expected = {x};
        FSElement [] actual = fs.toArray(new FSElement[fs.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void assertSizeComparatorForGetSubDirectoriesTest() {
        LinkedList<Directory> fs = prjRoot.getSubDirectories((fs1, fs2) -> fs1.getSize() - fs2.getSize());
        FSElement [] expected = {lib, src, test};
        FSElement [] actual = fs.toArray(new FSElement[fs.size()]);
        assertArrayEquals(expected, actual);
                System.out.println(expected); //debugging
        System.out.println(actual);
    }


}
