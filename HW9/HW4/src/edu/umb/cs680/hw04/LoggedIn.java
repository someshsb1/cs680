package edu.umb.cs680.hw04;

import javax.naming.AuthenticationException;

public class LoggedIn implements State {
    private static LoggedIn instance = new LoggedIn();

    private LoggedIn() {}

    private SecurityContext ctx;

    public LoggedIn(SecurityContext ctx) {
        this.ctx = ctx;
    }

    public static LoggedIn getInstance(SecurityContext ctx) {
        return instance;
    }

    
    public void login(EncryptedString password) throws AuthenticationException {
        if(!ctx.isActive()) {
            ctx.changeState(new LoggedOut(ctx));
            ctx.login(password);
        }
    }

    
    public void logout() {
        ctx.changeState(new LoggedOut(ctx));
    }

    
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoggedIn)) {
            return false;
        }
        return true;
    }
}