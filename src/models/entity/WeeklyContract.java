package models.entity;

public class WeeklyContract extends Contract
{

	public WeeklyContract()
	{
		
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
