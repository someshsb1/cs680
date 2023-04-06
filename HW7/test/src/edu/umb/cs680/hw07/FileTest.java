package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class FileTest {

    LocalDateTime ldt = LocalDateTime.now();

    Directory prjRoot = new Directory(null, "prjRoot", 0, ldt, null);
    Directory src = new Directory(prjRoot, "src", 0, ldt,null);
    Directory lib = new Directory(prjRoot, "lib", 0, ldt,null);
    Directory test = new Directory(prjRoot, "test", 0, ldt,null);
    File a = new File(src, "a", 0, ldt,null);
    File b = new File(src, "b", 0, ldt,null);
    File c = new File(lib, "c", 0, ldt,null);
    File x = new File(prjRoot, "x", 0, ldt,null);
    File d = new File(src, "d", 0, ldt,null);

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
        File x = new File(prjRoot, "x", 0, ldt, null);
        String[] actual = fileToStringArray(x);
        String[] expected = { "prjRoot", "x", "0", ldt.toString() };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileAEqualityUnderSrc() {
        FileSystem fs = FileSystem.getFileSystem();
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt,null);
        Directory src = new Directory(prjRoot, "src", 0, ldt,null);
        File a = new File(src, "a",0,ldt,null);
        fs.appendRootDir(prjRoot);
        prjRoot.appendChild(src);
        String[] actual = fileToStringArray(a);
        String[] expected = { "src", "a", "0", ldt.toString() };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileBEqualityUnderSrc() {
        FileSystem fs = FileSystem.getFileSystem();
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt,null);
        Directory src = new Directory(prjRoot, "src", 0, ldt,null);
        File b = new File(src, "b",0,ldt,null);
        fs.appendRootDir(prjRoot);
        prjRoot.appendChild(src);
        String[] actual = fileToStringArray(b);
        String[] expected = { "src", "b", "0", ldt.toString() };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileCEqualityUnderLib() {
        FileSystem fs = FileSystem.getFileSystem();
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt,null);
        Directory lib = new Directory(prjRoot, "lib", 0, ldt,null);
        File c = new File(lib, "c", 0, ldt,null);
        fs.appendRootDir(prjRoot);
        prjRoot.appendChild(lib);
        String[] actual = fileToStringArray(c);
        String[] expected = { "lib", "c", "0", ldt.toString() };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileDEqualityUnderTestSrc() {
        FileSystem fs = FileSystem.getFileSystem();
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt,null);
        Directory test = new Directory(prjRoot, "test", 0, ldt,null);
        Directory src = new Directory(test, "src", 0, ldt,null);
        File d = new File(src, "d", 0, ldt,null);
        fs.appendRootDir(prjRoot);
        prjRoot.appendChild(test);
        test.appendChild(src);
        String[] actual = fileToStringArray(d);
        String[] expected = { "src", "d", "0", ldt.toString() };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFileGetName() {
        Directory src = new Directory(prjRoot, "src", 0, ldt,null);
        File a = new File(src, "a", 0, ldt,null);
        assertEquals("a", a.getName());
    }

    @Test
    public void testFileBGetSize() {
        Directory src = new Directory(prjRoot, "src", 0, ldt,null);
        File b = new File(src, "b", 100, ldt,null);
        assertEquals(100, b.getSize());
    }
    
    @Test
    public void testFileCGetParent() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt,null);
        Directory lib = new Directory(prjRoot, "lib", 0, ldt,null);
        File c = new File(lib, "c", 0, ldt,null);
        assertEquals(lib, c.getParent());
    }

    @Test
    public void testFileDGetParentSrcUnderTest() {
        Directory test = new Directory(prjRoot, "test", 0, ldt,null);
        Directory src = new Directory(test, "src", 0, ldt,null);
        File d = new File(src, "d", 0, ldt,null);
        assertEquals(src, d.getParent());
    }
    
    @Test
    public void testFileXGetCreationTime() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt,null);
        LocalDateTime ldt = LocalDateTime.of(2022, 4, 1, 12, 0, 0);
        File x = new File(prjRoot, "x", 0, ldt,null);
        assertEquals(ldt, x.getCreationTime());
    }
    
    @Test
    public void testFileXIsFileOrNot() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt,null);
        File x = new File(prjRoot, "x", 0, ldt,null);
        assertTrue(x.isFile());
        assertFalse(x.isDirectory());
    }
}
