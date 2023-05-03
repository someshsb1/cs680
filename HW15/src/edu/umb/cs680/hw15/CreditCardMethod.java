package edu.umb.cs680.hw15;

public class CreditCardMethod implements PaymentGateway {

    private String name;
    private double cardNumber;
    private int cvv;
    private String cardExpiry;

    public CreditCardMethod(String name, double cardNumber, int cvv, String cardExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardExpiry = cardExpiry;
    }

    public void pay(double amt) {
        System.out.println("Payment Amount :" + amt);
    }

    //Getter Methods
    public String getName() {
        return name;
    }

    public double getCardNumber() {
        return cardNumber;
    }

    public int getCVV() {
        return cvv;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }
    
}
