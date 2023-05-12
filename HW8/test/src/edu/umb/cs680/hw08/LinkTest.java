package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw08.fs.*;

public class LinkTest {

    LocalDateTime ldt = LocalDateTime.now();

    private static FileSystem fs;
    private static Directory prjRoot;
    private static Directory src2;
    private static Link y;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
        prjRoot = fs.getRootDirs().get(0);
        src2 = prjRoot.subDirectoryName("src");
        y = new Link(prjRoot, "y", 0, LocalDateTime.now(), src2);
    }
    
    @Test
    public void verifyIsLinkTest() {
        
        assertTrue(y.isLink());
    }

    @Test
    public void getNameLinkTest() {

        assertEquals("y", y.getName());
    }

    @Test
    public void getSizeLinkTest() {

        assertEquals(0, y.getSize());
    }

    @Test
    public void getCreationTimeLinkTest() {

        assertNotNull(y.getCreationTime());
    }

    @Test
    public void verifyIsDirectoryTest() {
        assertFalse(y.isDirectory());
    }

    @Test
    public void verifyIsFileTest() {
        assertFalse(y.isFile());
    }

    @Test
    public void getParentLinkTest() {
        
        assertEquals(prjRoot, y.getParent());
    }

    @Test
    public void getTargetLinkTest() {
        assertEquals("src", y.getTarget().getName());
    }

    @Test
    public void setTargetLinkTest() {
        y.setTarget(src2);
        assertEquals(src2, y.getTarget());
    }
}
