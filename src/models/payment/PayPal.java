package models.payment;

public class PayPal extends BankAccount {	

	public PayPal( double balance, String swiftCode, String accountNumber, long userID, String emailID )
	{
		super( balance, swiftCode, accountNumber, userID, emailID,"paypal" );
	}

	@Override
	public boolean validateAccount() {
		return cardDetailsExpired;
	}

	@Override
	public String makePayment(double amount) throws NotEnoughBalanceException {
		String message="{\"state\":\"success\",\"message\":\"Fund "+amount+" added Successfully\"}";
		if(balance < (amount + amount*0.02))
		{
			throw new NotEnoughBalanceException((amount + amount*0.02)-balance);
		}
		balance =  balance - (amount + amount*0.02);
		return message;
	}

	@Override
	public StringBuilder printReceipt() {
		return receipt.append( "Paypal Inc. \n" );
	}

	@Override
	public double checkBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	@Override
	public void addCash(double amount) {
		balance += amount;
	}

}
