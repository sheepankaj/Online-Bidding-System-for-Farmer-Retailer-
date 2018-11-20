package models.payment;

import java.util.Date;

public class PaymentStatus implements IPaymentStates {

	@Override
	public void next(Payment payment) {
		System.out.println("The payment is in the last state");

	}

	@Override
	public void prev(Payment payment) {
		payment.setState(new ProcessedByPaymentGateway());

	}

	@Override
	public void printStatus(Payment payment) {
		payment.getBuilder().append("Final status received"+ new Date().toString());

	}

}
