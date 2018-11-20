package models.entity;

public class DailyContract extends Contract
{
	public DailyContract()
	{
		super("dailycontract"); // this is only a GSON library requirement for deserializing
	}

	@Override
	public double getPriceOnFrequency()
	{
		return getAgreedBid().getAgreedFinalPrice();
	}

	@Override
	public StringBuilder getContractConstraints()
	{
		StringBuilder builder = getContractConstraints();
		builder.append( "This contract roles out in daily basis\n");
		return builder;
	}

}
