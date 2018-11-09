package models.entity;

public class DailyContract extends Contract
{
	public DailyContract()
	{
		super(StockFrequency.DAILY);
	}

	@Override
	public double getPriceOnFrequency()
	{
		return getAgreedBid().getUnitPrice();
	}

	@Override
	public StringBuilder getContractConstraints()
	{
		StringBuilder builder = getContractConstraints();
		builder.append( "This contract roles out in daily basis\n");
		return builder;
	}

}
