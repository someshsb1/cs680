package edu.umb.cs680.SecurityContext;

import javax.naming.AuthenticationException;

public interface State {

    void login(EncryptedString password) throws AuthenticationException;
    void logout();
    
}
