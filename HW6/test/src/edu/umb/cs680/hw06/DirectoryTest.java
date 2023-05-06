package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DirectoryTest {

    LocalDateTime ldt = LocalDateTime.now();
    
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        
        fs = TestFixtureInitializer.createFS();

    }

    private String[] dirToStringArray(Directory d) {
        Directory parent = d.getParent();
        String pname = (parent == null) ? "null" : parent.getName();
        String[] dirInfo = { pname, d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString() };
        return dirInfo;
    }

    @Test
    public void verifyDirectoryEqualityPrjRoot() {
        Directory actual = fs.getRootDirs().get(0);
        String[] expected = { "null", "prjRoot", "0", actual.getCreationTime().toString()};
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualitySrc() {
        String[] expected = { "prjRoot", "src", "0", ldt.toString()};
        Directory actual = new Directory(fs.getRootDirs().get(0), "src", 0, ldt);
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityLib() {
        String[] expected = { "prjRoot", "lib", "0", ldt.toString() };
        Directory actual = new Directory(fs.getRootDirs().get(0), "lib", 0, ldt);
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityTest() {
        Directory actual = new Directory(fs.getRootDirs().get(0), "test", 0, ldt);
        String[] expected = { "prjRoot", "test", "0", ldt.toString() };
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualitySrcUnderTest() {
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory test = prjRoot.subDirectoryName("test");
        Directory actual = test.subDirectoryName("src");
        String[] expected = { "test", "src", "0", actual.getCreationTime().toString() };
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void assertGetName() {
        Directory prjRoot = fs.getRootDirs().get(0);
        assertEquals("prjRoot", prjRoot.getName());
    }
     
    @Test
    public void assertGetParent() {
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory actual = prjRoot.subDirectoryName("src");
        assertEquals(prjRoot, actual.getParent());
    }


    @Test
    public void assertCountChildren() {
        Directory prjRoot = fs.getRootDirs().get(0);
        int actual = prjRoot.countChildren();
        assertEquals(4, actual);
    }

    @Test
    public void assertGetSubDirectories() {
        Directory prjRoot = fs.getRootDirs().get(0);
        LinkedList<Directory> subDirs = prjRoot.getSubDirectories();
        int actual = subDirs.size();
        assertEquals(3, actual);
    }

    @Test
    public void assertGetFiles() {
        Directory prjRoot = fs.getRootDirs().get(0);
        LinkedList<File> files = prjRoot.getFiles();
        int actual = files.size();
        assertEquals(1, actual);
    }

    @Test
    public void assertGetTotalSize() {
        Directory prjRoot = fs.getRootDirs().get(0);
        int actual = prjRoot.getTotalSize();
        assertEquals(10, actual);
    }

    @Test
    public void assertSubdirectoryByName() {
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory dir = prjRoot.subDirectoryName("test");
        String actual = dir.getName();
        assertEquals("test", actual);
    }

}