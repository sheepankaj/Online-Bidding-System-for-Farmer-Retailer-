package models.payment;

import java.util.Date;

public class ProcessedByPaymentGateway implements IPaymentStates {

	@Override
	public void next(Payment payment) {
		payment.setState(new PaymentStatus());

	}

	@Override
	public void prev(Payment payment) {
		payment.setState(new SentToPaymentGateway());

	}

	@Override
	public void printStatus(Payment payment) {
		payment.getBuilder().append("Processed payment came from payment gateway"+ new Date().toString());
	}

}
