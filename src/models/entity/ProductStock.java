package models.entity;

public class ProductStock
{
	private Product product;
	private int quantitiy;
	private StockFrequency frequency;
	
	public ProductStock( Product product, int quantitiy, StockFrequency frequency )
	{
		this.product = product;
		this.quantitiy = quantitiy;
		this.frequency = frequency;
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
	
	
}
