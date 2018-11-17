package models.entity;

public class Retailer extends User
{
	String companyName;
	String companyAddress;
	String fax;
	String tel;
	boolean spam;
	private String statusType;
	int successfullyClosedContracts;
	
	public Retailer()
	{
		// TODO Auto-generated constructor stub
	}
	
	public Retailer(String username,long userID,String password,String companyName,String companyAddress,String fax, String tel,String type)
	{
		super(username,userID,password,ProfileType.RETAILER,type);
		this.fax = fax;
		this.tel = tel;
		this.companyAddress = companyAddress;
		this.companyName = companyName;
	}
	
	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
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

	public int getSuccessfullyClosedContracts()
	{
		return successfullyClosedContracts;
	}

	public void setSuccessfullyClosedContracts( int successfullyClosedContracts )
	{
		this.successfullyClosedContracts = successfullyClosedContracts;
	}	
}
