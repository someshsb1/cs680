package edu.umb.cs680.hw04;

import javax.naming.AuthenticationException;

public interface State {

    void login(EncryptedString password) throws AuthenticationException;
    void logout();
    
}
