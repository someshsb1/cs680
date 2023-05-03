package edu.umb.cs680.hw15;

public class PayPalMethod implements PaymentGateway {

    private String email;
    private String pwd;

    public PayPalMethod(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    @Override
    public void pay(double amt) {
        System.out.println("Payment Amount :" + amt);        
    }


    //Getter Methods
    public String getPwd() {
        return pwd;
    }
    
    public String getEmail() {
        return email;
    }
}
