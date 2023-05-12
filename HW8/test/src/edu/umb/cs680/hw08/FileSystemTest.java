package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.fs.*;

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
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt, null);
        assertEquals(prjRoot.getName(), fs.getRootDirs().get(0).getName());
    }

    @Test
    public void assertAppendRootDir() {
        Directory prjRoot = new Directory(null, "prjRoot", 0, ldt, null);
        fs.appendRootDir(prjRoot);
        assertEquals(prjRoot.getName(), fs.getRootDirs().get(0).getName());
    }

}