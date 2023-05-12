package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class Link extends FSElement {

    Directory parent;
    FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime, target);
        this.parent = parent;
        this.target = target;
    }

    public boolean isLink() {
        return true;
    }

    public FSElement getTarget() {
        return target;
    }

    public void setTarget(FSElement target) {
        this.target = target;
    }

}
