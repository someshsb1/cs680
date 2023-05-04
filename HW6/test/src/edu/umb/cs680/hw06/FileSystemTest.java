package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileSystemTest {

    private FileSystem fs;
    private LocalDateTime ldt;

    @BeforeEach
    public void setUp() throws Exception {
        fs = FileSystem.getFileSystem();
        ldt = LocalDateTime.now();
    }

    @Test
    void testGetFileSystem() {
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs1, fs2);
    }

    @Test
    void testGetRootDirs() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        Directory src = new Directory(prjRoot, "src", 0, ldt);
        Directory lib = new Directory(prjRoot, "lib", 0, ldt);
        Directory test = new Directory(prjRoot, "test", 0, ldt);
        fs.appendRootDir(prjRoot);
        fs.appendRootDir(src);
        fs.appendRootDir(lib);
        fs.appendRootDir(test);
    
        LinkedList<Directory> rootDirs = fs.getRootDirs();
        assertNotNull(rootDirs);
        assertEquals(11, rootDirs.size());

        assertTrue(rootDirs.contains(prjRoot));
        assertTrue(rootDirs.contains(src));
        assertTrue(rootDirs.contains(lib));
        assertTrue(rootDirs.contains(test));
    }

    @Test
    public void testAppendRootDir() {
    Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
    Directory src = new Directory(prjRoot, "src", 0, ldt);
    fs.appendRootDir(prjRoot);
    fs.appendRootDir(src);

    LinkedList<Directory> rootDirs = fs.getRootDirs();
    assertNotNull(rootDirs); 
    assertEquals(7, rootDirs.size());

    Directory rootDir = rootDirs.get(0);
    assertNotNull(rootDir.getSubDirectories()); 
    assertEquals(0, rootDir.getSubDirectories().size());
    }
}


