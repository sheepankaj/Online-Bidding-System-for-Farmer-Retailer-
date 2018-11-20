package models.entity;

public class Product
{
	String name;
	long productID;
	
	public Product(String name,long productID)
	{
		this.name = name;
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}
	
	
}
