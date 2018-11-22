package models.entity;

import java.util.ArrayList;
import java.util.List;

import models.notification.Notification;
import models.notification.NotificationListener;

public class Product implements Notification
{
	private String name;
	private long productID;
	List<NotificationListener> productListeners = new ArrayList<>();
	private double latestProductStockPrice;
	private int latestProductStockQuantity;
	
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

	public double getLatestProductStockPrice()
	{
		return latestProductStockPrice;
	}

	public void setLatestProductStockPrice( double latestProductStockPrice )
	{
		this.latestProductStockPrice = latestProductStockPrice;
	}

	public int getLatestProductStockQuantity()
	{
		return latestProductStockQuantity;
	}

	public void setLatestProductStockQuantity( int latestProductStockQuantity )
	{
		this.latestProductStockQuantity = latestProductStockQuantity;
	}

	@Override
	public void attach( NotificationListener listener )
	{
		if(productListeners == null)
		{
			productListeners = new ArrayList<>();
		}
		productListeners.add( listener );
	}

	@Override
	public void notifyNotificationListeners()
	{
		for (NotificationListener listener : productListeners) {
			listener.update(this);
		}
	}

	@Override
	public void detach( NotificationListener listener )
	{
		productListeners.remove( listener );
	}
	
	
}
