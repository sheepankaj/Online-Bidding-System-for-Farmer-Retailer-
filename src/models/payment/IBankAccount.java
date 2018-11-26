package models.payment;

public interface IBankAccount {
	
	boolean validateAccount();
	void makePayment(double amount) throws NotEnoughBalanceException;
	StringBuilder printReceipt();
	double checkBalance();
	void addCash(double amount);
	
}
