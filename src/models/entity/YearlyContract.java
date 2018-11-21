package models.entity;

public class YearlyContract extends Contract
{
	
	public YearlyContract(Bid bid)
	{
		super("yearlycontract"); // this is only a GSON library requirement for deserializing JSON files to java objects
		this.setStockFrequency(StockFrequency.YEARLY);
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
		builder.append( "This contract roles out in yearly basis\n");
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
