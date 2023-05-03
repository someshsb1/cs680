package edu.umb.cs680.hw14.fs;

public class SizeComparator {

    public int compare(FSElement fs1, FSElement fs2) {
        if (fs1.getSize() > fs2.getSize()) {
        return 1;
        } else if (fs1.getSize() < fs2.getSize()) {
            return -1;
        } else {
            return 0;
        }
    }
    
}
