package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class DirectoryTest {

    LocalDateTime ldt = LocalDateTime.now();
    
    Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
    Directory src = new Directory(prjRoot, "src", 0, ldt);
    Directory lib = new Directory(prjRoot, "lib", 0, ldt);
    Directory test = new Directory(prjRoot, "test", 0, ldt);
    File a = new File(src, "a", 0, ldt);
    File b = new File(src, "b", 0, ldt);
    File c = new File(lib, "c", 0, ldt);
    File x = new File(prjRoot, "x", 0, ldt);
    File d = new File(src, "d", 0, ldt);
    

    private String[] dirToStringArray(Directory d) {
        Directory parent = d.getParent();
        String pname = (parent == null) ? "null" : parent.getName();
        String[] dirInfo = { pname, d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString() };
        return dirInfo;
    }

    @Test
    public void verifyDirectoryEqualityPrjRoot() {
        FileSystem fs = FileSystem.getFileSystem();
        fs.appendRootDir(prjRoot);
        Directory actual = fs.getRootDirs().get(0);
        String[] expected = { "null", "prjRoot", "0", actual.getCreationTime().toString() }; //actual.getCreationTime().toString() in order to capture the same creation time.
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualitySrc() {
        FileSystem fs = FileSystem.getFileSystem();
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        Directory src = new Directory(prjRoot, "src", 0, ldt);
        fs.appendRootDir(prjRoot);
        prjRoot.appendChild(src);
        Directory actual = new Directory(fs.getRootDirs().get(0), "src", 0, ldt);
        String[] expected = { "prjRoot", "src", "0", ldt.toString() };
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityLib() {
        FileSystem fs = FileSystem.getFileSystem();
        fs.appendRootDir(prjRoot);
        String[] expected = { "prjRoot", "lib", "0", ldt.toString() };
        Directory actual = new Directory(fs.getRootDirs().get(0), "lib", 0, ldt);
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityTest() {
        FileSystem fs = FileSystem.getFileSystem();
        fs.appendRootDir(prjRoot);
        prjRoot.appendChild(test);
        Directory actual = new Directory(fs.getRootDirs().get(0), "test", 0, ldt);
        String[] expected = { "prjRoot", "test", "0", ldt.toString() };
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void testGetName() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        assertEquals("prjRoot", prjRoot.getName());
    }

    @Test
    public void testSetName() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        prjRoot.setName("root");
        assertEquals("root", prjRoot.getName());
    }

    @Test
    public void testGetParent() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        Directory src = new Directory(prjRoot, "src", 0, ldt);
        assertEquals(prjRoot, src.getParent());
    }

    @Test
    public void testCountChildren() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        File a = new File(prjRoot, "a", 100, ldt);
        prjRoot.appendChild(a);
        assertEquals(1, prjRoot.countChildren());
    }

    @Test
    public void testGetSubDirectories() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        Directory src = new Directory(prjRoot, "src", 0, ldt);
        Directory lib = new Directory(prjRoot, "lib", 0, ldt);
        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        LinkedList<Directory> subDirs = prjRoot.getSubDirectories();
        assertTrue(subDirs.contains(src));
        assertTrue(subDirs.contains(lib));
        assertEquals(2, subDirs.size());
    }

    @Test
    public void testGetFiles() {
        Directory src = new Directory(prjRoot, "src", 0, ldt);
        File a = new File(src, "a", 100, ldt);
        File b = new File(src, "b", 200, ldt);
        src.appendChild(a);
        src.appendChild(b);
        LinkedList<File> files = src.getFiles();
        assertTrue(files.contains(a));
        assertTrue(files.contains(b));
        assertEquals(2, files.size());
    }

    @Test
    public void testGetTotalSize() {
        Directory src = new Directory(prjRoot, "src", 0, ldt);
        File a = new File(src, "a", 100, ldt);
        File b = new File(src, "b", 200, ldt);
        src.appendChild(a);
        src.appendChild(b);
        Directory lib = new Directory(prjRoot, "lib", 0, ldt);
        prjRoot.appendChild(lib);
        File c = new File(lib, "c", 50, ldt);
        lib.appendChild(c);
        prjRoot.appendChild(src);
        assertEquals(350, prjRoot.getTotalSize());
    }
}
