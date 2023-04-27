package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;


public class SecurityContextTest {

    @Test
    public void verifyAllStateTransitionTest() {
        SecurityContext ctx = new SecurityContext();

        //verify initial loggedout state
        assertTrue(ctx.getState() instanceof LoggedOut);

        //verify logout state
        ctx.logout();
        assertTrue(ctx.getState() instanceof LoggedOut);

        //verify login to logout transition state
        ctx.login(new EncryptedString("password123"));
        assertTrue(ctx.getState() instanceof LoggedIn);

        ctx.logout();
        assertTrue(ctx.getState() instanceof LoggedOut);

    }

    @Test
    public void verifyStateEqualityTest() {

        //instances of loggedin states
        LoggedIn lin1 = LoggedIn.getInstance();
        LoggedIn lin2 = LoggedIn.getInstance();
        
        //instances of loggedout states
        LoggedOut lout1 = LoggedOut.getInstance();
        LoggedOut lout2 = LoggedOut.getInstance();

        //verify state equality b/w loggedin instances
        assertEquals(lin1, lin2);

        //verify state equality b/w loggedout instances
        assertEquals(lout1, lout2);
    }
    
}
