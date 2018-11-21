package models.entity;

public class DailyContract extends Contract
{
	public DailyContract(Bid bid)
	{
		super("dailycontract"); // this is only a GSON library requirement for deserializing
		this.setStockFrequency(StockFrequency.DAILY);
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
		getStringBuilder().append( "  > This contract roles out in daily basis\n");
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
