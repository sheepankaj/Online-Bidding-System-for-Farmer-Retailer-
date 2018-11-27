package models.payment;

public class NotEnoughBalanceException extends Exception
{
	double fundsNeeded;
	
	public NotEnoughBalanceException(double fundsNeeded)
	{
		this.fundsNeeded = fundsNeeded;
	}
	@Override
	public String getMessage()
	{
		return "Not enough balance in the account, Please add : "+fundsNeeded;
	}
}
