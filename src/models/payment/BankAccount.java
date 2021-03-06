package models.payment;

public abstract class BankAccount implements IBankAccount
{
	double balance;
	String swiftCode;
	String accountNumber;
	long userID;
	String emailID;
	String type;
	StringBuilder receipt;
	boolean cardDetailsExpired = false;
	String accountType;
	
	
	
	public BankAccount( double balance, String swiftCode, String accountNumber, long userID, String emailID,String type )
	{
		this.balance = balance;
		this.swiftCode = swiftCode;
		this.accountNumber = accountNumber;
		this.userID = userID;
		this.emailID = emailID;
		this.type = type;
		receipt = new StringBuilder();
	}

	
	@Override
	public abstract boolean validateAccount();

	@Override
	public abstract String makePayment( double amount ) throws NotEnoughBalanceException;

	@Override
	public abstract StringBuilder printReceipt();

	@Override
	public abstract double checkBalance();

	@Override
	public abstract void addCash(double amount);

	public double getBalance()
	{
		return balance;
	}

	public void setBalance( double balance )
	{
		this.balance = balance;
	}

	public String getSwiftCode()
	{
		return swiftCode;
	}

	public void setSwiftCode( String swiftCode )
	{
		this.swiftCode = swiftCode;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber( String accountNumber )
	{
		this.accountNumber = accountNumber;
	}

	public long getUserID()
	{
		return userID;
	}

	public void setUserID( long userID )
	{
		this.userID = userID;
	}

	public String getEmailID()
	{
		return emailID;
	}

	public void setEmailID( String emailID )
	{
		this.emailID = emailID;
	}

	public String getType()
	{
		return type;
	}

	public void setType( String type )
	{
		this.type = type;
	}

	public StringBuilder getReceipt() {
		return receipt;
	}

	public void setReceipt(StringBuilder receipt) {
		this.receipt = receipt;
	}


	public String getAccountType()
	{
		return accountType;
	}
}
