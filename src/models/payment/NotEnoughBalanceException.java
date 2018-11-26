package models.payment;

public class NotEnoughBalanceException extends Exception
{
	@Override
	public String getMessage()
	{
		return "Not enough balance in the account";
	}
}
