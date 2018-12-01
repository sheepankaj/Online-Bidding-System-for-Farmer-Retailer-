package models.entity;

import java.util.LinkedList;
import java.util.Queue;

import models.notification.Notification;
import models.notification.NotificationListener;

public class User implements NotificationListener
{
	long userID;
	String username;
	String password;
	ProfileType profileType;
	String type;
	private Priority priority;
	private Queue<String> messageQueue = new LinkedList<>();
	
	public User()
	{
		// TODO Auto-generated constructor stub
	}
	
	public User(String username,long userID,String password,ProfileType profileType,Priority priority,String type)
	{
		this.username = username;
		this.userID = userID;
		this.password = password;
		this.profileType = profileType;
		this.type = type;
		this.priority = priority;
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername( String username )
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword( String password )
	{
		this.password = password;
	}
	public long getUserID()
	{
		return userID;
	}
	public void setUserID( long userID )
	{
		this.userID = userID;
	}
	public ProfileType getProfileType() {
		return profileType;
	}
	public void setProfileType(ProfileType profileType) {
		this.profileType = profileType;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
		
	}

	@Override
	public void update( Notification notification )
	{
		if(notification instanceof Product)
		{
			Product product = ((Product)notification);
			if(messageQueue == null)
			{
				messageQueue = new LinkedList<>();
			}
			messageQueue.add( "[Product : "+product.getName()+"][Quantity : "+product.getLatestProductStockQuantity()+"][Price : "+product.getLatestProductStockPrice()+"]" );
		}
	}
	
	public int getPriorityLevel() {
		
		return priority.getPriority();
		
	}

	public Queue<String> getMessageQueue()
	{
		if(messageQueue == null)
		{
			messageQueue = new LinkedList<>();
		}
		return messageQueue;
	}
	
	
	
	
	
}
