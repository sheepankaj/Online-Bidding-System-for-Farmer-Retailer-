package models.payment;

import java.util.Date;

public class Initiated implements IPaymentStates {

	@Override
	public void next(Payment payment) {
		payment.setState(new SentToPaymentGateway());

	}

	@Override
	public void prev(Payment payment) {
		System.out.println("The payment is in initiated state");
	}

	@Override
	public void printStatus(Payment payment) {
		payment.getBuilder().append("Payment Initiated"+ new Date().toString());

	}

}
