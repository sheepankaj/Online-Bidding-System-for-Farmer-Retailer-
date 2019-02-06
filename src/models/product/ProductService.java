package models.product;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import models.entity.EntityService;
import models.entity.Product;

public class ProductService extends EntityService
{
	private static ProductService productService;
	List<Product> products = new ArrayList<>();
	static String filePath = "/WEB-INF/db/product/Product.json";

	
	private ProductService(ServletContext context,String filePath)
	{
		super(context,filePath);
	}
	
	public static ProductService getProductServiceInstance(ServletContext context)
	{
		if(productService == null)
		{
			productService = new ProductService(context,filePath);
			productService.loadEntities();
		}
		return productService;
	}
	
	public void saveProductList() throws IOException
	{
		setWriter( new FileWriter(getContext().getRealPath("/WEB-INF/db/product/Product.json"),true));
		setGson(new GsonBuilder().create());
		getGson().toJson(products, getWriter());
		getWriter().close();
	}
	
	public String getProductsAsJSON()
	{
		return getGson().toJson(products);
	}
	
	public void addProduct( Product product )
	{
		products.add( product );
	}	
	
	public List<Product> getProducts()
	{
		return products;
	}
	
	public Product getProductByProductID(long productID)
	{
		for(Product product : products)
		{
			if(product.getProductID() == productID)
			return product;
		}
		return null;
	}
	
	public String disableEnableProduct(long productID)
	{
		String message = "";
		for(Product product : products)
		{
			if(product.getProductID() == productID)
			{
				if(product.isDisabled())
				{
					product.setDisabled( false );
					message = "{\"state\":\"success\",\"message\":\"Successflly enabled the product\",\"changedto\":\"Disable\"}";
				}
				else
				{
					product.setDisabled( true );
					message = "{\"state\":\"success\",\"message\":\"Successflly disabled the product\",\"changedto\":\"Enable\"}";
				}
			}
		}
		return message;
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
		TypeToken<List<Product>> token = new TypeToken<List<Product>>() {};
		products = getGson().fromJson(new InputStreamReader(getIs()), token.getType());
	}
}
