package models.entity;

public class WeeklyContract extends Contract
{

	public WeeklyContract()
	{
		super("weeklycontract"); // this is only a GSON library requirement for deserializing
	}

	@Override
	public double getPriceOnFrequency()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StringBuilder getContractConstraints()
	{
		StringBuilder builder = getContractConstraints();
		builder.append( "This contract roles out in weekly basis\n");
		return builder;
	}

}
