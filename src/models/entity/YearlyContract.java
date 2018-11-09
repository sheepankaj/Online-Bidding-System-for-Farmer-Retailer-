package models.entity;

public class YearlyContract extends Contract
{
	
	public YearlyContract( StockFrequency stockFrequency )
	{
		super( stockFrequency );
		// TODO Auto-generated constructor stub
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
