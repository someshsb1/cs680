package edu.umb.cs680.hw14.fs;

import java.time.LocalDateTime;

public class Link extends FSElement {
    

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime, target);
    }

    public void accept(FSVisitor v) {
        v.visit(this);
    }

}
