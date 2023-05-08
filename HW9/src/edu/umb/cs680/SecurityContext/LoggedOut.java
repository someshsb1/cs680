package edu.umb.cs680.SecurityContext;

import javax.naming.AuthenticationException;

//<<Singleton Class>>
public class LoggedOut implements State {
    private static LoggedOut instance = null; //private constructor

    public SecurityContext ctx;

    public LoggedOut(SecurityContext ctx) {
        this.ctx = ctx;
    }

    public static LoggedOut getInstance(SecurityContext ctx) {
        if (instance == null) {
            instance = new LoggedOut(ctx);
        }
        return instance;
    }

    @Override
    public void login(EncryptedString password) throws AuthenticationException {
        if (Authenticator.authenticate(ctx, password)) {
            ctx.changeState(new LoggedIn(ctx));
        } else {
            throw new AuthenticationException("Incorrect password");
        }
    }

    @Override
    public void logout() {
        //empty
        System.out.println("Logged out already.");
    }
}