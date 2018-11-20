package models.payment;

import java.util.Date;

public class SentToPaymentGateway implements IPaymentStates {

	@Override
	public void next(Payment payment) {
		payment.setState(new ProcessedByPaymentGateway());

	}

	@Override
	public void prev(Payment payment) {
		payment.setState(new Initiated());

	}

	@Override
	public void printStatus(Payment payment) 
	{
		payment.getBuilder().append("Payment Sent to payment gateway"+ new Date().toString());
	}

}
