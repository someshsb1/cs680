package edu.umb.cs680.hw12;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw12.fs.*;

public class ReverseAlphabeticalComparatorTest {

    private static FileSystem fs;
    private static ReverseAlphabeticalComparator comparator;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
        comparator = new ReverseAlphabeticalComparator();
    }

    @Test
    public void assertReverseAlphabeticalOrderGetChildrenTest() {
        List<Directory> subDirectories = fs.getRootDirs().get(0).getSubDirectories(comparator);
        Collections.sort(subDirectories, comparator);
        List<String> actual = new LinkedList<String>();
        for (Directory directory: subDirectories) {
            actual.add(directory.getName());
        }
        String[] expected = {"test", "src", "lib"};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void assertReverseAlphabeticalOrderGetAllFilesTest() {
        List<File> files = new LinkedList<File>();
        allFiles(fs.getRootDirs().get(0), files);
        Collections.sort(files, comparator);
        List<String> actual = new LinkedList<String>();
        for (File file: files) {
            actual.add(file.getName());
        }
        String[] expected = {"x", "d", "c", "b", "a"};
        assertArrayEquals(expected, actual.toArray());
    }

    //helper method for recursively check and add all files in the prjRoot and its subdirectories
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
    public void assertReverseAlphabeticalOrderGetSubDirectoriesTest() {
        List<FSElement> fsElements = fs.getRootDirs().get(0).getChildren(comparator);
        Collections.sort(fsElements, comparator);
        List<String> fsEList = new LinkedList<String>();
        for (FSElement fsElement: fsElements) {
            fsEList.add(fsElement.getName());
        }
        String[] expected = {"y", "x", "test", "src", "lib"};
        assertArrayEquals(expected, fsEList.toArray());
    }
    
    @Test
    public void assertReverseAlphabeticalOrderGetImmediateFileTest() {
        List<File> files = fs.getRootDirs().get(0).getFiles(comparator);
        Collections.sort(files, comparator);
        List<String> actual = new LinkedList<String>();
        for (File file: files) {
            actual.add(file.getName());
        }
        String[] expected = {"x"};
        assertArrayEquals(expected, actual.toArray());
    }
}
