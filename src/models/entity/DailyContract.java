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
		StringBuilder builder = getContractConstraints();
		builder.append( "This contract roles out in daily basis\n");
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
