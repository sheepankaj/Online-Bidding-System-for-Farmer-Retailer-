package models.entity;

public class Bid
{
	private ProductStock productStock;
	private double price;
	private User retailer;
	private User farmer;
	
	public Bid()
	{
		
	}
	
	public Bid( ProductStock productStock, double price, User retailer, User farmer )
	{
		this.productStock = productStock;
		this.price = price;
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

	public double getPrice()
	{
		return price;
	}

	public void setPrice( double price )
	{
		this.price = price;
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
