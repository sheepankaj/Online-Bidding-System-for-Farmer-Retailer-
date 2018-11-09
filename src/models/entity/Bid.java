package models.entity;

public class Bid
{
	private ProductStock productStock;
	private double unitPrice;
	private User retailer;
	private User farmer;
	
	public Bid()
	{
		
	}
	
	public Bid( ProductStock productStock, double unitPrice, User retailer, User farmer )
	{
		this.productStock = productStock;
		this.unitPrice = unitPrice;
		this.retailer = retailer;
		this.farmer = farmer;
	}

	public ProductStock getProductStock()
	{
		return productStock;
	}

	public void setProductStock( ProductStock productStock )
	{
		this.productStock = productStock;
	}

	public double getUnitPrice()
	{
		return unitPrice;
	}

	public void setUnitPrice( double unitPrice )
	{
		this.unitPrice = unitPrice;
	}

	public User getRetailer()
	{
		return retailer;
	}

	public void setRetailer( User retailer )
	{
		this.retailer = retailer;
	}

	public User getFarmer()
	{
		return farmer;
	}

	public void setFarmer( User farmer )
	{
		this.farmer = farmer;
	}	
}
