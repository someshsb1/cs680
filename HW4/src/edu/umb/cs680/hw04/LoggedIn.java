package edu.umb.cs680.hw04;

public class LoggedIn implements State {
    private static LoggedIn instance = new LoggedIn();

    private LoggedIn() {}

    public static LoggedIn getInstance() {
        return instance;
    }

    @Override
    public void login(EncryptedString password) {
        System.out.println("Logged in already.");
    }

    @Override
    public void logout() {
        SecurityContext.changeState(LoggedOut.getInstance());
    }

    @Override
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