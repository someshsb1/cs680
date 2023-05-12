package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw14.fs.*;

public class AlphabeticalComparatorTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {

        fs = TestFixtureInitializer.createFS();

    }
    //passing compare() method as LE to getChildren(), getFiles(), getSubDirectories()
    @Test
    public void assertDefaultAlphabeticalOrderGetChildrenTest() {
        Directory prjRoot = fs.getRootDirs().get(0);
        String[] expectedList = {"lib", "src", "test", "x", "y"};
        List<FSElement> directories = prjRoot.getChildren((fs1, fs2) -> fs1.getName().compareTo(fs2.getName()));
        List<String> actual = new LinkedList<String>();
        for(FSElement directory : directories) {
            actual.add(directory.getName());
        }
        List<String> expected = Arrays.asList(expectedList);
        assertArrayEquals(expected.toArray(), actual.toArray());

    }

    @Test
    public void assertAlphabeticalOrderGetFileTest() {
        Directory prjRoot = fs.getRootDirs().get(0);
        String[] expectedList = {"x"};
        List<File> files = prjRoot.getFiles((fs1, fs2) -> fs1.getName().compareTo(fs2.getName()));
        List<String> actual = new LinkedList<String>();
        for(FSElement file : files) {
            actual.add(file.getName());
        }
        List<String> expected = Arrays.asList(expectedList);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void assertAlphabeticalOrderGetSubDirectoriesTest() {
        Directory prjRoot = fs.getRootDirs().get(0);
        String[] expectedList = {"lib", "src", "test"};
        List<Directory> files = prjRoot.getSubDirectories((fs1, fs2) -> fs1.getName().compareTo(fs2.getName()));
        List<String> actual = new LinkedList<String>();
        for(FSElement file : files) {
            actual.add(file.getName());
        }
        List<String> expected = Arrays.asList(expectedList);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

}
