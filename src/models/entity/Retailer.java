package models.entity;

public class Retailer extends User
{
	String companyName;
	String companyAddress;
	String fax;
	String tel;
	boolean spam;
	
	public Retailer(String username,String password,String companyName,String companyAddress,String fax, String tel,String type)
	{
		super(username,password,ProfileType.RETAILER,type);
		this.fax = fax;
		this.tel = tel;
		this.companyAddress = companyAddress;
		this.companyName = companyName;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName( String companyName )
	{
		this.companyName = companyName;
	}

	public String getCompanyAddress()
	{
		return companyAddress;
	}

	public void setCompanyAddress( String companyAddress )
	{
		this.companyAddress = companyAddress;
	}

	public String getFax()
	{
		return fax;
	}

	public void setFax( String fax )
	{
		this.fax = fax;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel( String tel )
	{
		this.tel = tel;
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
