package models.entity;

public class MonthlyContract extends Contract
{

	public MonthlyContract()
	{
		super("monthlycontract"); // this is only a GSON library requirement for deserializing
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
		builder.append( "This contract roles out in monthy basis\n");
		return builder;
	}

}
