package edu.umb.cs680.hw14.fs;

public class AlphabeticalComparator {

    public int compare(FSElement fs1, FSElement fs2) {
    

        if (fs1.isDirectory() && !fs2.isDirectory())
        {
            return -1;

        } else if (!fs1.isDirectory() && fs2.isDirectory()) {

            return 1;

        } else {

            return fs1.getName().compareTo(fs2.getName());
            
        }
    };
    
}
