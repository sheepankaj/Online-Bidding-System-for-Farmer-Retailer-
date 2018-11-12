package models.payment;

public abstract class BankAccount implements IBankAccount
{
	double balance;
	String swiftCode;
	String accountNumber;
	long userID;
	String emailID;
	String type;
	
	
	
	public BankAccount( double balance, String swiftCode, String accountNumber, long userID, String emailID,String type )
	{
		this.balance = balance;
		this.swiftCode = swiftCode;
		this.accountNumber = accountNumber;
		this.userID = userID;
		this.emailID = emailID;
		this.type = type;
	}

	@Override
	public abstract boolean validateAccount();

	@Override
	public abstract void makePayment( double amount );

	@Override
	public abstract StringBuilder printReceipt();

	@Override
	public abstract double checkBalance();

	@Override
	public abstract void addCash();

}
