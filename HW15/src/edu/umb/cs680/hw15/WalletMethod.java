package edu.umb.cs680.hw15;

public class WalletMethod implements PaymentGateway {

    private String venmoNumber;

    public WalletMethod(String venmoNumber) {
        this.venmoNumber = venmoNumber;
    }

    public void pay(double amt) {
        System.out.println("Payment Amount :" + amt);
    }

    //Getter Methods
    public String getVenmo() {
        return venmoNumber;
    }
    
}
