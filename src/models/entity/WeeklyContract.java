package models.entity;

public class WeeklyContract extends Contract
{

	public WeeklyContract(Bid bid)
	{
		super("weeklycontract"); // this is only a GSON library requirement for deserializing
		this.setStockFrequency(StockFrequency.WEEKLY);
		this.setAgreedBid(bid);
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
	
	@Override
	public String getFarmerDetails() {
		return "Farmer ID : "+ getFarmerUserID();
	}

	@Override
	public String getRetailerDetails() {
		return "Retailer ID : "+ getRetailerUserID();
	}

}
