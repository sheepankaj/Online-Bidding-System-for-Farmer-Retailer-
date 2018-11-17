package models.notification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationManager
{
    Map<Notification, List<NotificationListener>> mapping;
    private static NotificationManager instance;
    
    public static NotificationManager getNotificationManagerInstance()
    {
    	if(instance == null)
    	{
    		instance = new NotificationManager();
    	}
    	return instance;
    }
	
	private NotificationManager(){
		mapping = new HashMap<Notification, List<NotificationListener>>();
	}	
	
	public void register(Notification notification, NotificationListener listener){
		if(mapping.containsKey(notification)){
			mapping.get(notification).add(listener);
		}
		else{
			mapping.put(notification, new ArrayList<NotificationListener>(Arrays.asList(listener)));
		}
	}	
	
	public void unregister(Notification notification, NotificationListener listener){
		if(mapping.containsKey(notification)){
			if(mapping.get(notification).contains(listener)){
				mapping.get(notification).remove(listener);
			}
		}
	}	
	
	public void notifyNotificationListeners(Notification notification){
		for (NotificationListener listener : mapping.get(notification)) {
			listener.update(notification);
		}
	}
}
