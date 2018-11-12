package models.payment;

public interface IBankAccount {
	
	boolean validateAccount();
	void makePayment();
	StringBuilder printReceipt();
	double checkBalance();
	void addCash();
}
