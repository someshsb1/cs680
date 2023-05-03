package edu.umb.cs680.hw15;

//Interface of PaymentGateway
public interface PaymentGateway {

    
    public void pay(double amt) throws PaymentExceptionHandling; //for error handling when no payment method available.
    
}
