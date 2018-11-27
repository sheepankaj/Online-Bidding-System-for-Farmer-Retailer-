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
		return getAgreedBid().getAgreedFinalPrice();
	}

	@Override
	public StringBuilder getContractConstraints()
	{
		getStringBuilder().append( "  > This contract roles out in yearly basis\n");
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
