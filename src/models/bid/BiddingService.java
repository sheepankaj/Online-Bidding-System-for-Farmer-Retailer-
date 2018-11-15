package models.bid;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.google.gson.reflect.TypeToken;

import models.entity.Bid;
import models.entity.EntityService;
import models.entity.Product;
import models.entity.ProductStock;
import models.entity.StockFrequency;

public class BiddingService extends EntityService
{
	private static BiddingService instance;
	List<Bid> bids = new ArrayList<>();
	static String filePath = "/WEB-INF/db/bid/Bids.json";
	
	private BiddingService(ServletContext context)
	{
		super(context,filePath);
	}
	
	public static BiddingService getBiddingServiceInstance(ServletContext context) throws FileNotFoundException
	{
		if(instance == null)
		{
			instance = new BiddingService(context);
			instance.loadEntities();
		}
		return instance;
	}
	
	public void loadEntities() throws FileNotFoundException
	{
		super.loadEntities();
		TypeToken<List<Bid>> token = new TypeToken<List<Bid>>() {};
		bids = getGson().fromJson(new InputStreamReader(getIs()), token.getType());
	}
	
	private void testGSON()
	{
		List<Bid> bids = new ArrayList<>();
		bids.add( new Bid(new ProductStock( new Product("Carrots",3893930), 1000, StockFrequency.DAILY, 560000 ),550000,10020,38839) );
		bids.add( new Bid(new ProductStock( new Product("Onions",5453434), 1500, StockFrequency.MONTHLY, 4000 ),3900,13430,43434) );
		bids.add( new Bid(new ProductStock( new Product("Cabage",563354), 125000, StockFrequency.WEEKLY, 6000 ),5500,23534,57688) );
		
		System.out.println( getGson().toJson(bids)); 
	}

	public List<Bid> getBids()
	{
		return bids;
	}
	
	public String getBidsAsJSON()
	{
		return getGson().toJson(bids);
	}
	
	
}
