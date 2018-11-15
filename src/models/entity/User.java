package models.entity;

import models.notification.Notification;
import models.notification.NotificationListener;

public class User implements NotificationListener
{
	long userID;
	String username;
	String password;
	ProfileType profileType;
	String type;
	
	public User()
	{
		// TODO Auto-generated constructor stub
	}
	
	public User(String username,long userID,String password,ProfileType profileType,String type)
	{
		this.username = username;
		this.userID = userID;
		this.password = password;
		this.profileType = profileType;
		this.type = type;
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

	@Override
	public void update( Notification notification )
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
}
