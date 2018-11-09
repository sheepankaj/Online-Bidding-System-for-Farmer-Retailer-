package models.contract;

import models.entity.Bid;
import models.entity.Contract;
import models.entity.Retailer;

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
		if(retailer.getSuccessfullyClosedContracts() > 100)
		{
			// we provide a 10% of discount
			
		}
		return contract;
	}
}
