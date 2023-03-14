package edu.umb.cs680.hw04;

public class SecurityContext {
    private User user;
    private static State state;
    private boolean isFirstLogin = true;


    public SecurityContext() {
        state = LoggedOut.getInstance();
    }

    public static void changeState(State newState) {
        state = newState;
    }

    public void login(EncryptedString password) {
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

    public static void main(String[] args) {
        SecurityContext ctx = new SecurityContext();

        //Current state
        System.out.println("Current State: " + (ctx.getState() instanceof LoggedOut ? "LoggedOut" : "LoggedIn"));

        //State transition after logging in
        ctx.login(new EncryptedString("password123"));
        System.out.println("After successful login: " + (ctx.getState() instanceof LoggedIn ? "LoggedIn" : "LoggedOut"));
        
    }
}