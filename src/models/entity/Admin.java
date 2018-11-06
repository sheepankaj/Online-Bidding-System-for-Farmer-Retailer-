package models.entity;

public class Admin extends User
{
	String adminName;
	String email;
	
	public Admin(String username,String password,String adminName,String email,String type)
	{
		super(username,password,ProfileType.ADMIN,type);
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
