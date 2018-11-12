package models.payment;

public class PayPal extends BankAccount {	

	public PayPal( double balance, String swiftCode, String accountNumber, long userID, String emailID )
	{
		super( balance, swiftCode, accountNumber, userID, emailID,"paypal" );
	}

	@Override
	public boolean validateAccount() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void makePayment(double amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public StringBuilder printReceipt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double checkBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addCash() {
		// TODO Auto-generated method stub

	}

}
