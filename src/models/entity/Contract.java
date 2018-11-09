package models.entity;

import java.util.Date;

public class Contract
{
	long farmerUserID;
	long retailerUserID;
	Bid agreedBid;
	Date signdate = new Date();
	
	@Override
	public String toString()
	{
		return "Farmer ID : "+farmerUserID+" "+"Retailer ID : "+retailerUserID+" "+"Agreed Date : "+signdate+" Placed Bid : "+agreedBid.toString();
	}
}
