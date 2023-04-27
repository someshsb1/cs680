package edu.umb.cs680.hw04;

import javax.naming.AuthenticationException;

public class SecurityContext {
    private static User user;
    private State state;
    private boolean isFirstLogin = true;
    static EncryptedString password;


    public SecurityContext(User user, EncryptedString password ) {
        state = new LoggedOut();
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

    public boolean isActive() {
        boolean result = isFirstLogin;
        isFirstLogin = false;
        return result;
    }

    public State getState() {
        return state;
    }

    public User getUser() {
        return user;
    }

    public static void main(String[] args) throws AuthenticationException {
        SecurityContext ctx = new SecurityContext(user, password);

        //Current state
        System.out.println("Current State: " + (ctx.getState() instanceof LoggedOut ? "LoggedOut" : "LoggedIn"));

        //State transition after logging in
        ctx.login(new EncryptedString("password123"));
        System.out.println("After successful login: " + (ctx.getState() instanceof LoggedIn ? "LoggedIn" : "LoggedOut"));
        
    }
}