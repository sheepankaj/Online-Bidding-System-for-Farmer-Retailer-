package models.entity;

public class MonthlyContract extends Contract
{

	public MonthlyContract(  )
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
		builder.append( "This contract roles out in monthy basis\n");
		return builder;
	}

}
