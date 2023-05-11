package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.fs.*;
import edu.umb.cs680.hw08.fs.util.FileCrawlingVisitor;

public class FileCrawlingVisitorTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void getFileNameTest() {

        Directory prjRoot = fs.getRootDirs().get(0);
        LinkedList<String> exp = new LinkedList<String>();
        exp.add("a");
        exp.add("b");
        exp.add("c");
        exp.add("d");
        exp.add("x");

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        prjRoot.accept(visitor);

        LinkedList<String> act = visitor.getFileName();
        assertEquals(exp, act);

    }
    
}
