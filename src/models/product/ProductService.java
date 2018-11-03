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
	public static ProductService productService;
	List<Product> products = new ArrayList<>();
	static String filePath = "/WEB-INF/db/product/Product.json";

	
	private ProductService(ServletContext context,String filePath)
	{
		super(context,filePath);
	}
	
	public static ProductService getProductServiceInstance(ServletContext context) throws FileNotFoundException
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
		products.add( new Product( "Pork", 939494 ) );
		setGson(new GsonBuilder().create());
		getGson().toJson(products, getWriter());
		getWriter().close();
	}
	
	public void addProduct( Product profile )
	{
		products.add( profile );
	}	
	
	public void loadEntities() throws FileNotFoundException
	{
		super.loadEntities();
		TypeToken<List<Product>> token = new TypeToken<List<Product>>() {};
		products = getGson().fromJson(new InputStreamReader(getIs()), token.getType());
	}
}
