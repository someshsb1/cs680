package edu.umb.cs680.hw14.fs;


public class ReverseAlphabeticalComparator {

    public int compare(FSElement fs1, FSElement fs2) {
        if (fs1.isDirectory() && !fs2.isDirectory())
        {
            return -1;

        } else if (!fs1.isDirectory() && fs2.isDirectory()) {

            return 1;

        } else {

            return fs2.getName().compareTo(fs1.getName());

        }
    }
}



