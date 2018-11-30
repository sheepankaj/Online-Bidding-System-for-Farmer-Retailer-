package models.payment;

public interface IPaymentStates {	
	void next(Payment payment);
	void prev(Payment payment);
	void printStatus(Payment payment);
}
