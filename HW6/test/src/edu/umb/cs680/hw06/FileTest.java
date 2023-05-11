package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileTest {

    static LocalDateTime ldt;


    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        ldt = LocalDateTime.now();
        fs = TestFixtureInitializer.createFS();

    }

    private String[] fileToStringArray(File f) {
        Directory parent = f.getParent();
        String pname = (parent == null) ? "null" : parent.getName();
        String[] fileInfo = { pname, f.getName(), Integer.toString(f.getSize()), f.getCreationTime().toString() };
        return fileInfo;
    }

    @Test
    public void verifyFileXEqualityUnderPrjRoot() {
       File actual = new File(fs.getRootDirs().get(0), "x", 0, ldt);
       String[] expected = {"prjRoot", "x", "0", ldt.toString()};
       assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyFileAEqualityUnderSrc() {
       File actual = new File(fs.getRootDirs().get(0).subDirectoryName("src"), "a", 0, ldt);
       String[] expected = {"src", "a", "0", ldt.toString()};
       assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyFileBEqualityUnderSrc() {
       File actual = new File(fs.getRootDirs().get(0).subDirectoryName("src"), "b", 0, ldt);
       String[] expected = {"src", "b", "0", ldt.toString()};
       assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyFileCEqualityUnderlib() {
       File actual = new File(fs.getRootDirs().get(0).subDirectoryName("lib"), "c", 0, ldt);
       String[] expected = {"lib", "c", "0", ldt.toString()};
       assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyFileDEqualityInSrcUnderTestDirectory() {
       File actual = new File(fs.getRootDirs().get(0).subDirectoryName("test").subDirectoryName("src"), "d", 0, ldt);
       String[] expected = {"src", "d", "0", ldt.toString()};
       assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void assertFileOrNot() {
        File actual = new File(fs.getRootDirs().get(0), "x", 0, ldt);
        assertTrue(actual.isFile());
        assertFalse(actual.isDirectory());
    }

    @Test 
    public void assertGetName() {
        File actual = new File(fs.getRootDirs().get(0), "x", 0, ldt);
        assertEquals("x", actual.getName());
    }

    @Test 
    public void assertGetParent() {
        File actual = new File(fs.getRootDirs().get(0).subDirectoryName("test").subDirectoryName("src"), "d", 0, ldt);
        assertEquals("d", actual.getName());
    }

    @Test
    public void assertGetSize() {
        File actual = new File(fs.getRootDirs().get(0).subDirectoryName("lib"), "c", 0, ldt);
        assertEquals(0, actual.getSize());
    }

    @Test
    public void assertGetCreationTime() {
        File actual = new File(fs.getRootDirs().get(0).subDirectoryName("src"), "b", 0, ldt);
        assertEquals(ldt, actual.getCreationTime());
    }
}

    