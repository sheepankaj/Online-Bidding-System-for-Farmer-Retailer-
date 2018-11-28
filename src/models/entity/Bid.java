package models.entity;

import java.util.Random;

public class Bid
{
	private ProductStock productStock;
	private double agreedFinalPrice;
	private long retailerID;
	private long farmerID;
	private boolean signedByFarmer;
	private boolean signedByRetailer;
	private long bidID;
	
	public Bid()
	{
		
	}
	
	public Bid( ProductStock productStock, double agreedFinalPrice, long retailerID, long farmerID, boolean signedByFarmer , boolean signedByRetailer)
	{
		this.productStock = productStock;
		this.agreedFinalPrice = agreedFinalPrice;
		this.retailerID = retailerID;
		this.farmerID = farmerID;
		this.signedByFarmer = signedByFarmer;
		this.signedByRetailer = signedByRetailer;
	}
	
	public Bid(ProductStock productStock, double agreedFinalPrice, long retailerID, long farmerID, boolean signedByFarmer , boolean signedByRetailer,long bidID)
	{
		this(productStock, agreedFinalPrice, retailerID, farmerID, signedByFarmer , signedByRetailer);
		this.bidID = bidID;
	}

	public ProductStock getProductStock()
	{
		return productStock;
	}

	public void setProductStock( ProductStock productStock )
	{
		this.productStock = productStock;
	}

	public double getAgreedFinalPrice()
	{
		return agreedFinalPrice;
	}

	public void setAgreedFinalPrice( double unitPrice )
	{
		this.agreedFinalPrice = unitPrice;
	}

	public long getRetailerID()
	{
		return retailerID;
	}

	public void setRetailerID( long retailerID )
	{
		this.retailerID = retailerID;
	}

	public long getFarmerID()
	{
		return farmerID;
	}

	public void setFarmerID( long farmerID )
	{
		this.farmerID = farmerID;
	}	

	public boolean isSignedByFarmer()
	{
		return signedByFarmer;
	}

	public void setSignedByFarmer( boolean signedByFarmer )
	{
		this.signedByFarmer = signedByFarmer;
	}

	public boolean isSignedByRetailer()
	{
		return signedByRetailer;
	}

	public void setSignedByRetailer( boolean signedByRetailer )
	{
		this.signedByRetailer = signedByRetailer;
	}

	public long getBidID()
	{
		return bidID;
	}	
	
	public static class BidBuilder {
		
		private ProductStock productStock;
		private double agreedFinalPrice;
		private long retailerID;
		private long farmerID;
		private boolean signedByFarmer;
		private boolean signedByRetailer;
		private long bidID;
		
		
		public BidBuilder()
		{
			
		}
		
		public BidBuilder setProductStock(Product product, int quantitiy, StockFrequency frequency, double unitPrice)
		{
			
			ProductStock productStock = new ProductStock(product, quantitiy, frequency, unitPrice, RandomNumberGenerator.getLongID() );
			this.productStock = productStock;
			return this;
		}
		
		public BidBuilder setAgreedFinalPrice(double agreedFinalPrice)
		{
			this.agreedFinalPrice = agreedFinalPrice;
			return this;
		}
		
		public BidBuilder setRetailerID(long retailerID)
		{
			this.retailerID = retailerID;
			return this;
		}
		
		public BidBuilder setFarmerID(long farmerID)
		{
			this.farmerID = farmerID;
			return this;
		}
		
		public BidBuilder setSignedByFarmer(boolean signedByFarmer)
		{
			this.signedByFarmer = signedByFarmer;
			return this;
		}
		
		public BidBuilder setSignedByRetailer(boolean signedByRetailer)
		{
			this.signedByRetailer = signedByRetailer;
			return this;
		}
		
		public BidBuilder setBidID(long bidID)
		{
			this.bidID = bidID;
			return this;
		}
		
		public Bid build() 
		{
            return new Bid(productStock, agreedFinalPrice, retailerID, farmerID, signedByFarmer , signedByRetailer,bidID);
	    }
	}

}
