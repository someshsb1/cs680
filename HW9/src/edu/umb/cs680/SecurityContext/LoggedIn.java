package edu.umb.cs680.SecurityContext;

import javax.naming.AuthenticationException;

//<<Singleton Class>>
public class LoggedIn implements State {

    private static LoggedIn instance = null; //private constructor

    public SecurityContext ctx;

    public LoggedIn(SecurityContext ctx) {
        this.ctx = ctx;
    }

    public static LoggedIn getInstance(SecurityContext ctx) {
        if (instance == null) {
            instance = new LoggedIn(ctx);
        }
        return instance;
    }

    //isActive returns true in the first login, then returns false.
    public void login(EncryptedString password) throws AuthenticationException {
        if(!ctx.isActive()) {
            ctx.changeState(new LoggedOut(ctx));
            ctx.login(password);
        }
    }

    
    public void logout() {
        ctx.changeState(new LoggedOut(ctx));
    }
}