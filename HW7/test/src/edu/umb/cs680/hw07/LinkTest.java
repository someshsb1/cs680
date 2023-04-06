package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkTest {

    LocalDateTime ldt = LocalDateTime.now();

    private Directory prjRoot;
    private Directory src;
    private Directory lib;
    private Directory test;
    private Directory src1;
    private File a;
    private File b;
    private File c;
    private Link y;

    @BeforeEach
    public void setUp() {
        prjRoot = new Directory(null, "prjRoot", 0, ldt, null);
        src = new Directory(prjRoot, "src", 0, ldt, null);
        lib = new Directory(prjRoot, "lib", 0, ldt, null);
        test = new Directory(prjRoot, "test", 0, ldt, null);
        src1 = new Directory(test, "src", 0, ldt, null);
        a = new File(src, "a", 10, ldt, null);
        b = new File(src, "b", 20, ldt, null);
        c = new File(lib, "c", 30, ldt, null);
        y = new Link(prjRoot, "y", 1, ldt, src1);

        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        test.appendChild(src1);
        src.appendChild(a);
        src.appendChild(b);
        lib.appendChild(c);
        src1.appendChild(y);
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

        assertEquals(1, y.getSize());
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
        y.setTarget(test);
        assertEquals(test, y.getTarget());
    }
}
