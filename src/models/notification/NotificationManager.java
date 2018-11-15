package models.notification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationManager
{
    Map<Notification, List<NotificationListener>> mapping;
	
	public NotificationManager(){
		mapping = new HashMap<Notification, List<NotificationListener>>();
	}
	
	
	public void register(Notification subject, NotificationListener listener){
		if(mapping.containsKey(subject)){
			mapping.get(subject).add(listener);
		}
		else{
			mapping.put(subject, new ArrayList<NotificationListener>(Arrays.asList(listener)));
		}
	}
	
	
	public void unregister(Notification subject, NotificationListener listener){
		if(mapping.containsKey(subject)){
			if(mapping.get(subject).contains(listener)){
				mapping.get(subject).remove(listener);
			}
		}
	}
	
	
	public void notifyNotificationListeners(Notification notification){
		for (NotificationListener listener : mapping.get(notification)) {
			listener.update(notification);
		}
	}
}
