package models.entity;

public class Farmer extends User
{
	String farmAddress;
	String telephone;
	boolean spam;
	private String statusType;
	
	public Farmer(String username,long userID,String password,String farmAddress,String telephone,Priority priority,String type)
	{
		super(username,userID,password,ProfileType.FARMER,priority,type);
		this.farmAddress = farmAddress;
		this.telephone = telephone;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
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
