package models.payment;

public interface IBankAccount {
	
	boolean validateAccount();
	void makePayment(double amount);
	StringBuilder printReceipt();
	double checkBalance();
	void addCash(double amount);
	
}
