package edu.umb.cs680.hw14;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw14.fs.*;

public class ReverseAlphabeticalComparatorTest {

    private static FileSystem fs;
    
    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }

    
    @Test      
    public void assertReverseAlphabeticalOrderGetChildrenTest() {
        Directory prjRoot = fs.getRootDirs().get(0);
        String[] expected = {"y", "x", "test", "src", "lib"};
        List<FSElement> directories = prjRoot.getChildren((fs1, fs2) -> fs2.getName().compareTo(fs1.getName()));
        List<String> actual = new LinkedList<String>();
        for(FSElement directory : directories) {
            actual.add(directory.getName());
        }
        List<String> expectedList = Arrays.asList(expected);
        assertArrayEquals(expectedList.toArray(), actual.toArray());
    }

    @Test
    public void assertReverseAlphabeticalOrderGetFileTest() {
        Directory prjRoot = fs.getRootDirs().get(0);
        String[] expected = {"x"};
        List<File> files = prjRoot.getFiles((fs1, fs2) -> fs2.getName().compareTo(fs1.getName()));
        List<String> actual = new LinkedList<String>();
        for(FSElement file : files) {
            actual.add(file.getName());
        }
        List<String> expectedList = Arrays.asList(expected);
        assertArrayEquals(expectedList.toArray(), actual.toArray());
    }
    

    @Test
    public void assertReverseAlphabeticalOrderGetSubDirectoriesTest() {
        Directory prjRoot = fs.getRootDirs().get(0);
        String[] expected = {"test", "src", "lib"};
        List<Directory> files = prjRoot.getSubDirectories((fs1, fs2) -> fs2.getName().compareTo(fs1.getName()));
        List<String> actual = new LinkedList<String>();
        for(FSElement file : files) {
            actual.add(file.getName());
        }
        List<String> expectedList = Arrays.asList(expected);
        assertArrayEquals(expectedList.toArray(), actual.toArray());
    }

}
