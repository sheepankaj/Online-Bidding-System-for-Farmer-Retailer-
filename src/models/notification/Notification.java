package models.notification;

public interface Notification
{
    void attach(NotificationListener listener);
    
	void detach(NotificationListener listener);
	
	void notifyNotificationListeners();
}
