package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.fs.*;
import edu.umb.cs680.hw08.fs.util.FileSearchVisitor;

public class FileSearchVisitorTest {

    private static FileSystem fs;
    private static Directory prjRoot;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
        prjRoot = fs.getRootDirs().get(0);
    }

    @Test
    public void fileSearchForExistingFileInTheDirectory() {
        FileSearchVisitor visitor = new FileSearchVisitor("a");
        prjRoot.accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals("a", foundFiles.get(0).getName());
    }

    @Test
    public void fileSearchForExistingFileCInTheDirectory() {
        FileSearchVisitor visitor = new FileSearchVisitor("c");
        prjRoot.accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals("c", foundFiles.get(0).getName());
    }

    @Test
    public void fileSearchForExistingFileDInTheDirectory() {
        FileSearchVisitor visitor = new FileSearchVisitor("d");
        prjRoot.accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals("d", foundFiles.get(0).getName());
    }

    @Test
    public void fileSearchForExistingFileXDInTheDirectory() {
        FileSearchVisitor visitor = new FileSearchVisitor("x");
        prjRoot.accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals("x", foundFiles.get(0).getName());
    }

    @Test
    public void fileSearchForNonExistingFileInTheDirectory() {
        FileSearchVisitor visitor = new FileSearchVisitor("e"); // file "e" does not exist
        prjRoot.accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(0, foundFiles.size());
    }

    @Test
    public void fileSearchExistingFileInTheDirectoryWithSubdirectories() {
        FileSearchVisitor visitor = new FileSearchVisitor("b"); // file b in prjRoot/test/src directory
        prjRoot.accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals("b", foundFiles.get(0).getName());
    }
    
}
