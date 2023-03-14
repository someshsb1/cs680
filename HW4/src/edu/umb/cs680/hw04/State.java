package edu.umb.cs680.hw04;

public interface State {

    void login(EncryptedString password);
    void logout();
    
}
