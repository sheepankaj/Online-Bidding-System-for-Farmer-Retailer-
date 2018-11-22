package models.notification;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import models.entity.Farmer;
import models.entity.Product;
import models.entity.User;
import models.login.LoginService;
import models.product.ProductService;
import models.profile.ProfilesService;

public class NotificationService
{
	private static NotificationService instance;

	public NotificationService()
	{
		// notificationManager = NotificationManager.getNotificationManagerInstance();
	}

	public static NotificationService getNotificationServiceInstance()
	{
		if ( instance == null )
		{
			instance = new NotificationService();
			instance.registerFarmersForProductNotifications();
		}
		return instance;
	}

	public void registerFarmerForProductNotifications( String[] products, User user )
	{
		if(products != null)
		{
			List<Product> productsList = ProductService.getProductServiceInstance( LoginService.getServeletContext() ).getProducts();
			for ( Product product : productsList )
			{
				if ( Arrays.asList( products ).contains( product.getName() ) )
				{
					product.attach( user );
				}
			}
		}		
	}

	private void registerFarmersForProductNotifications()
	{
		for ( User user : ProfilesService.getProfileServiceInstance( LoginService.getServeletContext() ).getUsers() )
		{
			if ( user instanceof Farmer )
			{
				Farmer farmer = ( Farmer ) user;
				String[] involvedProducts = ( ( Farmer ) user ).getProductsInvolved();
				NotificationService.getNotificationServiceInstance().registerFarmerForProductNotifications( involvedProducts, farmer );
			}
		}
	}

	public void updateFarmersForProductNotification( String productCode, String qty, String price )
	{
		long productID = Long.parseLong( productCode );
		Product product = ProductService.getProductServiceInstance( LoginService.getServeletContext() ).getProductByProductID( productID );
		product.setLatestProductStockPrice( Double.parseDouble( price ) );
		product.setLatestProductStockQuantity( Integer.parseInt( qty ) );
		product.notifyNotificationListeners();
	}
}
