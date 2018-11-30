package models.payment;

public class NotEnoughBalanceException extends Exception
{
	double amount;
	
	public NotEnoughBalanceException(double amount)
	{
		this.amount = amount;
	}
	
	@Override
	public String getMessage()
	{
		return "Please add this amount : "+amount;
	}
}
