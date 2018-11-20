package models.entity;

import models.notification.Notification;
import models.notification.NotificationListener;

public class Bid implements Notification
{
	private ProductStock productStock;
	private double agreedFinalPrice;
	private long retailerID;
	private long farmerID;
	
	public Bid()
	{
		
	}
	
	public Bid( ProductStock productStock, double agreedFinalPrice, long retailerID, long farmerID )
	{
		this.productStock = productStock;
		this.agreedFinalPrice = agreedFinalPrice;
		this.retailerID = retailerID;
		this.farmerID = farmerID;
	}

	public ProductStock getProductStock()
	{
		return productStock;
	}

	public void setProductStock( ProductStock productStock )
	{
		this.productStock = productStock;
	}

	public double getAgreedFinalPrice()
	{
		return agreedFinalPrice;
	}

	public void setAgreedFinalPrice( double unitPrice )
	{
		this.agreedFinalPrice = unitPrice;
	}

	public long getRetailerID()
	{
		return retailerID;
	}

	public void setRetailerID( long retailerID )
	{
		this.retailerID = retailerID;
	}

	public long getFarmerID()
	{
		return farmerID;
	}

	public void setFarmerID( long farmerID )
	{
		this.farmerID = farmerID;
	}

	@Override
	public void attach( NotificationListener listener )
	{
		System.out.println( "attach from notification" );
	}

	@Override
	public void detach( NotificationListener listener )
	{
		System.out.println( "detach from notification" );
		
	}

	@Override
	public void notifyNotificationListeners()
	{
		System.out.println( "notifyNotificationListeners from notification" );
		
	}	
	
	
}
