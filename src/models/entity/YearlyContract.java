package models.entity;

public class YearlyContract extends Contract
{
	
	public YearlyContract()
	{
		super("yearlycontract"); // this is only a GSON library requirement for deserializing JSON files to java objects
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
		builder.append( "This contract roles out in yearly basis\n");
		return builder;
	}

}
