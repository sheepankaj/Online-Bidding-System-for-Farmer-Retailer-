package models.entity;

public class ProductStock
{
	private Product product;
	private int quantitiy;
	private StockFrequency frequency;
	private double unitPrice;
	
	public ProductStock()
	{
		// TODO Auto-generated constructor stub
	}
	
	public ProductStock( Product product, int quantitiy, StockFrequency frequency, double unitPrice )
	{
		this.product = product;
		this.quantitiy = quantitiy;
		this.frequency = frequency;
		this.unitPrice = unitPrice;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct( Product product )
	{
		this.product = product;
	}

	public int getQuantitiy()
	{
		return quantitiy;
	}

	public void setQuantitiy( int quantitiy )
	{
		this.quantitiy = quantitiy;
	}

	public StockFrequency getFrequency()
	{
		return frequency;
	}

	public void setFrequency( StockFrequency frequency )
	{
		this.frequency = frequency;
	}

	public double getUnitPrice()
	{
		return unitPrice;
	}

	public void setUnitPrice( double unitPrice )
	{
		this.unitPrice = unitPrice;
	}
	
	
	
}
