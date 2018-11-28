package models.payment;

public interface IBankAccount {
	
	boolean validateAccount();
	String makePayment(double amount) throws NotEnoughBalanceException;
	StringBuilder printReceipt();
	double checkBalance();
	void addCash(double amount);
	
}
