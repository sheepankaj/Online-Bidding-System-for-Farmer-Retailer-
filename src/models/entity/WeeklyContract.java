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
		return getAgreedBid().getAgreedFinalPrice();
	}

	@Override
	public StringBuilder getContractConstraints()
	{
		getStringBuilder().append( "  > This contract roles out in weekly basis\n");
		return getStringBuilder();
	}
	
	@Override
	public String getFarmerDetails() {
		return "Farmer ID : "+ getAgreedBid().getFarmerID();
	}

	@Override
	public String getRetailerDetails() {
		return "Retailer ID : "+ getAgreedBid().getRetailerID();
	}

}
