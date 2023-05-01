package edu.umb.cs680.hw12;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.fs.FSElement;
import edu.umb.cs680.hw12.fs.File;
import edu.umb.cs680.hw12.fs.ReverseAlphabeticalComparator;

public class ReverseAlphabeticalComparatorTest {

    private static LocalDateTime ldt = LocalDateTime.now();
    
    static Directory prjRoot = new Directory(null, "prjRoot", 0, ldt, null);
    static Directory src = new Directory(prjRoot, "src", 0, ldt,null);
    static Directory lib = new Directory(prjRoot, "lib", 0, ldt,null);
    static Directory test = new Directory(prjRoot, "test", 0, ldt,null);
    static File a = new File(src, "a", 0, ldt,null);
    static File b = new File(src, "b", 0, ldt,null);
    static File c = new File(lib, "c", 0, ldt,null);
    static File x = new File(prjRoot, "x", 0, ldt,null);
    static File d = new File(src, "d", 0, ldt,null);

    
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
    public void assertReverseAlphabeticalOrderGetChildrenTest() {
        List<FSElement> fs = prjRoot.getChildren();
        ReverseAlphabeticalComparator compare = new ReverseAlphabeticalComparator();
        fs.sort(compare);
        FSElement [] expected = {x, test, src, lib};
        FSElement [] actual = fs.toArray(new FSElement[fs.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void assertReverseAlphabeticalOrderGetFileTest() {
        LinkedList<File> fs = prjRoot.getFiles();
        ReverseAlphabeticalComparator compare = new ReverseAlphabeticalComparator();
        fs.sort(compare);
        FSElement [] expected = {x};
        FSElement [] actual = fs.toArray(new FSElement[fs.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void assertReverseAlphabeticalOrderGetSubDirectoriesTest() {
        LinkedList<Directory> fs = prjRoot.getSubDirectories();
        ReverseAlphabeticalComparator compare = new ReverseAlphabeticalComparator();
        fs.sort(compare);
        FSElement [] expected = {test, src, lib};
        FSElement [] actual = fs.toArray(new FSElement[fs.size()]);
        assertArrayEquals(expected, actual);
    }


}
