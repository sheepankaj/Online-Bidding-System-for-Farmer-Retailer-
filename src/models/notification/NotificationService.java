package models.notification;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import models.entity.Product;
import models.entity.User;
import models.login.LoginService;
import models.product.ProductService;

public class NotificationService
{
	NotificationManager notificationManager;
	private static NotificationService instance;
	
	public NotificationService()
	{
		notificationManager = NotificationManager.getNotificationManagerInstance();
	}
	
	public static NotificationService getNotificationServiceInstance()
	{
		if(instance == null )
		{
			instance = new NotificationService();
		}
		return instance;
	}
	
	public void registerFarmerForProductNotifications(String [] products, User user) throws FileNotFoundException
	{
		List<Product> productsList = ProductService.getProductServiceInstance( LoginService.getServeletContext() ).getProducts();
		for(Product product : productsList)
		{
			if(Arrays.asList(products).contains(product.getName()))
			{
				notificationManager.register( product, user );
			}
		}
	}
}
