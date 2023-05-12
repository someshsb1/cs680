package edu.umb.cs680.SecurityContext;

import javax.naming.AuthenticationException;

public class SecurityContext {
    private static User user;
    private State state;
    static EncryptedString password;


    public SecurityContext(User user, EncryptedString password) {
        state = new LoggedOut(this);
    }

    public void changeState(State newState) {
        state = newState;
    }

    public void login(EncryptedString password) throws AuthenticationException {
        state.login(password);
    }

    public void logout() {
        state.logout();
    }

    //isActive returns true in the first login, then returns false.
    public boolean isActive() {
        if (this.state instanceof LoggedIn) {
            return true;
        }
        return false;
    }

    public State getState() {
        return state;
    }

    public User getUser() {
        return user;
    }

    public static void main(String[] args) throws AuthenticationException {
        User user = null;
        EncryptedString password = null;
        SecurityContext ctx = new SecurityContext(user, password);

        //Current state
        System.out.println("Current State: " + (ctx.getState() instanceof LoggedOut ? "LoggedOut" : "LoggedIn"));

        //After call to ctx.login(...); Successful Login.
        try {
        ctx.login(new EncryptedString());
        System.out.println("After successful login: " + (ctx.getState() instanceof LoggedIn ? "LoggedIn" : "LoggedOut"));
        } catch (AuthenticationException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }
}