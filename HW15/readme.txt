# Payment Gateway Implementation using Strategy Design Pattern

Payment Gateway system allows users with the feasibility of making payments using multiple payment methods (PayPal, Credit Card, Wallet, etc) as per their preference. Payment Gateway implementation is based on Strategy Design Pattern technique, which provides the flexibility and extensibility - where each payment method is implemented as a separate class that implements a common interface defined by the `PaymentGateway` interface. Any new payment method can be added as a new class implementing the PaymentGateway interface easily without affecting the rest of the code or classes.


# Using the payment gateway;

Creating an instance of the PaymentMethodCtx class
Setting the PaymentGateway to use by calling the setPaymentMethod and passing the instance of the payment method class which implements the PaymentGateway interface
Call the processPayment method and pass the payment amount (amt) value, set it to the boolean flag successPayment to check whether payment was successful or not.


# If there's a requirement to add support for a new Payment method as GiftCard option, we can simply create a new class as below;

Public class GiftCard implements PaymentGateway {
	public int giftCardNumber;
	public int giftCardCode;

	public GiftCardMethod(int giftCardNumber, int giftCardCode) {
		this.giftCardNumber = giftCardNumber;
		this.giftCardCode = giftCardCode;
	}

	@Overide //implementing interface PaymentGateway method
	public void pay(double amt) {
		System.out.println("Payment: " + 100);
	}

	//getter methods
	public int getGiftCardNumber() {
		return giftCardNumber;
	}
	
	public int getGiftCardCode() {
		return giftCardCode;
	}
}

# Then to call or use the GiftCard method as payment option, we can create an instance of the same in PaymentMethodCtx class as below;

        System.out.println("\nPaying via GiftCard Method: \n");
        ctx.setPaymentMethod(new GiftCardMethod(112, 201));
        ctx.processPayment(100.00);
        
