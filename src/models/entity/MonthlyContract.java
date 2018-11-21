package models.entity;

public class MonthlyContract extends Contract
{

	public MonthlyContract(Bid bid)
	{
		super("monthlycontract"); // this is only a GSON library requirement for deserializing
		this.setStockFrequency(StockFrequency.MONTHLY);
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
		builder.append( "This contract roles out in monthy basis\n");
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
