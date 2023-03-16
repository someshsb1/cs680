package edu.umb.cs680.hw04;

public class LoggedOut implements State {
    private static LoggedOut instance = new LoggedOut();

    private LoggedOut() {}

    public static LoggedOut getInstance() {
        return instance;
    }

    @Override
    public void login(EncryptedString password) {
        if (Authenticator.authenticate(null, password)) {
            SecurityContext.changeState(LoggedIn.getInstance());
        } else {
            System.out.println("Unable to Login, Please try again!");
        }
    }

    @Override
    public void logout() {
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