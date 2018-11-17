package models.entity;

public class Admin extends User
{
	String adminName;
	String email;
	
	public Admin(String username,long userID,String password,String adminName,String email,Priority priority,String type)
	{
		super(username,userID,password,ProfileType.ADMIN,priority,type);
		this.adminName = adminName;
		this.email = email;
	}

	public String getAdminName()
	{
		return adminName;
	}

	public void setAdminName( String adminName )
	{
		this.adminName = adminName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}
	
	
}
