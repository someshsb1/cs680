package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileSystemTest {

    LocalDateTime ldt = LocalDateTime.now();
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void assertGetFileSystem() {
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs1, fs2);
    }

    @Test
    public void assertGetRootDirs() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        assertEquals(prjRoot.getName(), fs.getRootDirs().get(0).getName());
    }

    @Test
    public void assertAppendRootDir() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt);
        fs.appendRootDir(prjRoot);
        assertEquals(prjRoot.getName(), fs.getRootDirs().get(0).getName());
    }

}