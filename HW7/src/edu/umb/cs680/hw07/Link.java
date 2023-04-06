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

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public Directory getParent() {
        return this.parent;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public boolean isDirectory() {
        return false;
    }

    public boolean isFile() {
        return false;
    }

    public FSElement getTarget() {
        return this.target;
    }

    public void setTarget(FSElement target) {
        this.target = target;
    }

}
