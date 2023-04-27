package edu.umb.cs680.hw04;

import javax.naming.AuthenticationException;

public class LoggedOut implements State {
    private static LoggedOut instance = new LoggedOut();

    LoggedOut() {}

    private SecurityContext ctx;

    public LoggedOut(SecurityContext ctx) {
        this.ctx = ctx;
    }
    public static LoggedOut getInstance() {
        return instance;
    }

    @Override
    public void login(EncryptedString password) throws AuthenticationException {
        if (Authenticator.authenticate(ctx, password)) {
            ctx.changeState(new LoggedIn(ctx));
        } else {
            throw new AuthenticationException("Invalid password");
        }
    }

    @Override
    public void logout() {
        //empty
        System.out.println("Logged out already.");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoggedOut)) {
            return false;
        }
        return true;
    }
}