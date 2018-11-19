package models.notification;

import models.entity.Bid;

public class NotificationService
{
	NotificationManager notificationManager;
	
	public NotificationService()
	{
		notificationManager = NotificationManager.getNotificationManagerInstance();
	}
	void createBidNotification(Bid bid)
	{
		long productId = bid.getProductStock().getProduct().getProductID();
		
	}
}
