package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw12.fs.*;

public class SizeComparatorTest {

    private static FileSystem fs;
    private static SizeComparator comparator;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
        comparator = new SizeComparator();
    }

    @Test
    public void assertSizeComparatorForImmediateChildrenSubDirectoriesTest() {
        List<Directory> subDirectories = fs.getRootDirs().get(0).getSubDirectories(comparator);
        Collections.sort(subDirectories, comparator);
        List<String> actual = new LinkedList<String>();
        for (Directory directory: subDirectories) {
            actual.add(directory.getName());
        }
        String[] expected = {"lib", "src", "test"};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void assertSizeComparatorForGetFileTestInImmediateSubdirectories() {
        List<File> files = new LinkedList<File>();
        allFiles(fs.getRootDirs().get(0), files);
        Collections.sort(files, comparator);
        List<String> actual = new LinkedList<String>();
        for (File file: files) {
            actual.add(file.getName());
        }
        String[] expected = {"c", "a", "b", "d", "x"};
        assertArrayEquals(expected, actual.toArray());
    }

    //helper method for recursively checking and adding all files in the prjRoot subdirectories
    private void allFiles(Directory directory, List<File> files) {
        for (FSElement fsElement: directory.getChildren(comparator)) {
            if(fsElement instanceof Directory) {
                allFiles((Directory) fsElement, files);
            } else if (fsElement instanceof File) {
                files.add((File) fsElement);
            }
        }
    }

    @Test
    public void assertSizeComparatorForImmediateChildrenTest() {
        List<FSElement> fsElements = fs.getRootDirs().get(0).getChildren(comparator);
        Collections.sort(fsElements, comparator);
        List<String> fsEList = new LinkedList<String>();
        for (FSElement fsElement: fsElements) {
            fsEList.add(fsElement.getName());
        }
        String[] expected = {"lib", "src", "test", "y", "x"};
        assertArrayEquals(expected, fsEList.toArray());
    }
}
