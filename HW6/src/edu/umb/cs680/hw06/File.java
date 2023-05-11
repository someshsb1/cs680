package edu.umb.cs680.hw06;

import java.time.LocalDateTime;

public class File extends FSElement {

    Directory parent;
    
    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        this.parent = parent;
        
    }

    public boolean isFile() {
        return true;
    }
}
