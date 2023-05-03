package edu.umb.cs680.hw15;

public class PaymentMethodCtx {

    private PaymentGateway paymentMethod;

    public void setPaymentMethod(PaymentGateway paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    // returns true or false based on payment processing after selecting payment method.
    public boolean processPayment(double amt) {

        if (paymentMethod == null) {
            throw new IllegalStateException(" No Payment Method available.");
        }
        try {
            paymentMethod.pay(amt);
            return true;
        } catch (Exception e) {
            System.out.println("Payment could not be completed :" + e.getMessage());
            return false;
        }
    }

    public static void main(String args[]) {
        PaymentMethodCtx ctx = new PaymentMethodCtx();
        boolean successPayment = false;

        try {
        System.out.println("\nPaying via PayPal Method: \n");
        ctx.setPaymentMethod(new PayPalMethod("abc@test.com", "pwd000"));
        successPayment = ctx.processPayment(340.00);
        if (successPayment) {
            System.out.println("Payment Successful\n");
        }

        System.out.println("Paying via Venmo Method: \n");
        ctx.setPaymentMethod(new WalletMethod("1234SAAB"));
        successPayment = ctx.processPayment(10.00);
        if (successPayment) {
            System.out.println("Payment Successful\n");
        }

        System.out.println("Paying via CreditCard Method: \n");
        ctx.setPaymentMethod(new CreditCardMethod("ChaseFreedom", 312234412, 325, "04/23"));
        successPayment = ctx.processPayment(40.00);
        if (successPayment) {
            System.out.println("Payment Successful\n");
        }

        ctx.setPaymentMethod(null); //error handling if no payment method available.
        successPayment = ctx.processPayment(100.00);
        if (successPayment) {
            System.out.println("Payment Successful");
        }

        } catch (Exception e) {
            System.out.println("Payment could not be completed :" + e.getMessage());
        }
    }
}
