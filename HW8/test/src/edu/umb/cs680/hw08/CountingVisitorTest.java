package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.fs.*;
import edu.umb.cs680.hw08.fs.util.CountingVisitor;

public class CountingVisitorTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }
    @Test
    public void countingVisitorTest() {
        CountingVisitor visitor = new CountingVisitor();
        Directory prjRoot = fs.getRootDirs().get(0);
        prjRoot.accept(visitor);
        assertEquals(5, visitor.getDirNum());
        assertEquals(5, visitor.getFileNum());
        assertEquals(1, visitor.getLinkNum());
    }
    @Test
    public void emptyPrjRootDirectoryCountingVisitorTest() {
        CountingVisitor visitor = new CountingVisitor();
        Directory prjRoot = new Directory(null, "prjRoot", 0, LocalDateTime.now(), null);
        prjRoot.accept(visitor);
        assertEquals(1, visitor.getDirNum());
        assertEquals(0, visitor.getFileNum());
        assertEquals(0, visitor.getLinkNum());
    }
}
