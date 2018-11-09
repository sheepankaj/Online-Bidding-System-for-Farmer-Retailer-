package models.contract;

import models.entity.Bid;
import models.entity.Contract;
import models.entity.Retailer;
import models.entity.StockFrequency;

public class ContractService
{
	private static ContractService instance;
	
	private ContractService()
	{
		// TODO Auto-generated constructor stub
	}
	
	public static ContractService getContractServiceInstance()
	{
		if(instance == null)
		{
			instance = new ContractService();
		}
		return instance;
	}
	
	public Contract createContract(Bid bid)
	{
		Contract contract = null;
		Retailer retailer = (Retailer)bid.getRetailer();
		StockFrequency frequency = bid.getProductStock().getFrequency();
		contract = ContractFactory.createContract( frequency ); 
		return contract;
	}
}
