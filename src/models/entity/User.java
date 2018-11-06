package models.entity;

public class User
{
	long userID;
	String username;
	String password;
	ProfileType profileType;
	
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
	
	
	
}
