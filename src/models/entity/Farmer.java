package models.entity;

public class Farmer extends User
{
	String farmAddress;
	String telephone;
	boolean spam;
	
	public Farmer(String username,long userID,String password,String farmAddress,String telephone,String type)
	{
		super(username,userID,password,ProfileType.FARMER,type);
		this.farmAddress = farmAddress;
		this.telephone = telephone;
	}

	public String getFarmAddress()
	{
		return farmAddress;
	}

	public void setFarmAddress( String farmAddress )
	{
		this.farmAddress = farmAddress;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone( String telephone )
	{
		this.telephone = telephone;
	}

	public boolean isSpam()
	{
		return spam;
	}

	public void setSpam( boolean spam )
	{
		this.spam = spam;
	}	
}
