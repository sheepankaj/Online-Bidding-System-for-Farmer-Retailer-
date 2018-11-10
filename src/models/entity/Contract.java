package models.entity;

import java.util.Date;

public abstract class Contract
{
	private long farmerUserID;
	private long retailerUserID;
	private Bid agreedBid;
	private Date signdate = new Date();
	private StockFrequency stockFrequency;
	private StringBuilder contractConstraints = new StringBuilder();
	
	public Contract()
	{
	}
	
	public abstract double getPriceOnFrequency();
	
	public abstract StringBuilder getContractConstraints();
	
	@Override
	public String toString()
	{
		return "Farmer ID : "+farmerUserID+" "+"Retailer ID : "+retailerUserID+" "+"Agreed Date : "+signdate+" Placed Bid : "+agreedBid.toString();
	}

	public long getFarmerUserID()
	{
		return farmerUserID;
	}

	public void setFarmerUserID( long farmerUserID )
	{
		this.farmerUserID = farmerUserID;
	}

	public long getRetailerUserID()
	{
		return retailerUserID;
	}

	public void setRetailerUserID( long retailerUserID )
	{
		this.retailerUserID = retailerUserID;
	}

	public Bid getAgreedBid()
	{
		return agreedBid;
	}

	public void setAgreedBid( Bid agreedBid )
	{
		this.agreedBid = agreedBid;
	}

	public Date getSigndate()
	{
		return signdate;
	}

	public void setSigndate( Date signdate )
	{
		this.signdate = signdate;
	}

	public StockFrequency getStockFrequency()
	{
		return stockFrequency;
	}

	public void setStockFrequency( StockFrequency stockFrequency )
	{
		this.stockFrequency = stockFrequency;
	}

	public void setContractConstraints( StringBuilder contractConstraints )
	{
		this.contractConstraints = contractConstraints;
	}	
	
	
}
