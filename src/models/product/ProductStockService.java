package models.product;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.google.gson.reflect.TypeToken;

import models.entity.EntityService;
import models.entity.Product;
import models.entity.ProductStock;
import models.entity.StockFrequency;
import models.profile.ProfilesService;

public class ProductStockService extends EntityService
{
	private static ProductStockService instance;
	List<ProductStock> productStock = new ArrayList<>();
	List<ProductStock> addProductStock = new ArrayList<>();
	static String filePath = "/WEB-INF/db/product/ProductStock.json";
	
	private ProductStockService( ServletContext context, String filePath )
	{
		super( context, filePath );
	}
	
	public static ProductStockService getProductStockServiceInstance(ServletContext context)
	{
		if(instance == null)
		{
			instance = new ProductStockService(context,filePath);
			instance.loadEntities();
		}
		return instance;
	}
	public String addProductStock(String name,String quantity,String frequency,String farmerID, String price) {
		
		
		ProductStock productStockObj=new ProductStock();
		
		StockFrequency freq=StockFrequency.valueOf(frequency);
		int quant=Integer.parseInt(quantity);
		long id=Long.parseLong(farmerID);
		Product prod=new Product(name,id);
		Double unitPrice=Double.parseDouble(price);
		
		productStockObj.setFrequency(freq);
		productStockObj.setQuantitiy(quant);
		productStockObj.setProduct(prod);
		productStockObj.setUnitPrice(unitPrice);
		
		
		addProductStock.add(productStockObj);
		System.out.println(addProductStock.size());
		return "added stock sucessfully";
		

	}
	public String getSearchedProductStocksAsJSON(String productID, String frequency, String quantity)
	{
		List<ProductStock> searched = new ArrayList<>();
		for(ProductStock stock : productStock)
		{
			Product product = stock.getProduct();
			if(product.getProductID() == Long.parseLong( productID ) && stock.getFrequency().toString().equals( frequency ) && stock.getQuantitiy() == Integer.parseInt( quantity ))
			{
				stock.setPriority(ProfilesService.getProfile( stock.getFarmerID() ).getPriorityLevel());
				searched.add(stock);
			}
		}
		return getGson().toJson(searched);
	}
    
	public void loadEntities()
	{
		try
		{
			super.loadEntities();
		}
		catch ( FileNotFoundException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TypeToken<List<ProductStock>> token = new TypeToken<List<ProductStock>>() {};
		productStock = getGson().fromJson(new InputStreamReader(getIs()), token.getType());
	}
}
