package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class FileTest {

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

    private String[] fileToStringArray(File f) {
        Directory parent = f.getParent();
        String pname = (parent == null) ? "null" : parent.getName();
        String[] fileInfo = { pname, f.getName(), Integer.toString(f.getSize()), f.getCreationTime().toString() };
        return fileInfo;
    }

    @Test
    public void verifyFileXEqualityUnderPrjRoot() {
        FileSystem fs = FileSystem.getFileSystem();
        fs.appendRootDir(prjRoot);
        File x = new File(prjRoot, "x", 0, ldt);
        String[] actual = fileToStringArray(x);
        String[] expected = { "prjRoot", "x", "0", ldt.toString() };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileAEqualityUnderSrc() {
        FileSystem fs = FileSystem.getFileSystem();
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        Directory src = new Directory(prjRoot, "src", 0, ldt);
        File a = new File(src, "a",0,ldt);
        fs.appendRootDir(prjRoot);
        prjRoot.appendChild(src);
        String[] actual = fileToStringArray(a);
        String[] expected = { "src", "a", "0", ldt.toString() };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileBEqualityUnderSrc() {
        FileSystem fs = FileSystem.getFileSystem();
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        Directory src = new Directory(prjRoot, "src", 0, ldt);
        File b = new File(src, "b",0,ldt);
        fs.appendRootDir(prjRoot);
        prjRoot.appendChild(src);
        String[] actual = fileToStringArray(b);
        String[] expected = { "src", "b", "0", ldt.toString() };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileCEqualityUnderLib() {
        FileSystem fs = FileSystem.getFileSystem();
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        Directory lib = new Directory(prjRoot, "lib", 0, ldt);
        File c = new File(lib, "c", 0, ldt);
        fs.appendRootDir(prjRoot);
        prjRoot.appendChild(lib);
        String[] actual = fileToStringArray(c);
        String[] expected = { "lib", "c", "0", ldt.toString() };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileDEqualityUnderTestSrc() {
        FileSystem fs = FileSystem.getFileSystem();
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        Directory test = new Directory(prjRoot, "test", 0, ldt);
        Directory src = new Directory(test, "src", 0, ldt);
        File d = new File(src, "d", 0, ldt);
        fs.appendRootDir(prjRoot);
        prjRoot.appendChild(test);
        test.appendChild(src);
        String[] actual = fileToStringArray(d);
        String[] expected = { "src", "d", "0", ldt.toString() };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFileGetName() {
        Directory src = new Directory(prjRoot, "src", 0, ldt);
        File a = new File(src, "a", 0, ldt);
        assertEquals("a", a.getName());
    }

    @Test
    public void testFileBGetSize() {
        Directory src = new Directory(prjRoot, "src", 0, ldt);
        File b = new File(src, "b", 100, ldt);
        assertEquals(100, b.getSize());
    }
    
    @Test
    public void testFileCGetParent() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        Directory lib = new Directory(prjRoot, "lib", 0, ldt);
        File c = new File(lib, "c", 0, ldt);
        assertEquals(lib, c.getParent());
    }

    @Test
    public void testFileDGetParentSrcUnderTest() {
        Directory test = new Directory(prjRoot, "test", 0, ldt);
        Directory src = new Directory(test, "src", 0, ldt);
        File d = new File(src, "d", 0, ldt);
        assertEquals(src, d.getParent());
    }
    
    @Test
    public void testFileXGetCreationTime() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        LocalDateTime creationTime = LocalDateTime.of(2022, 4, 1, 12, 0, 0);
        File x = new File(prjRoot, "x", 0, creationTime);
        assertEquals(creationTime, x.getCreationTime());
    }
    
    @Test
    public void testFileXIsFileOrNot() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        File x = new File(prjRoot, "x", 0, ldt);
        assertTrue(x.isFile());
        assertFalse(x.isDirectory());
    }
}
