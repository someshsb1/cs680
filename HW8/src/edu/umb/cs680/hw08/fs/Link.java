package edu.umb.cs680.hw08.fs;

import java.time.LocalDateTime;

public class Link extends FSElement {
    

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime, target);
    }

    public void accept(FSVisitor v) {
        v.visit(this);
    }

    public boolean isLink() {
        return true;
    }

    public FSElement getTarget() {
        return this.target;
    }

    public void setTarget(FSElement target) {
        this.target = target;
    }

}
