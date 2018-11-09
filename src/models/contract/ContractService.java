package models.contract;

import models.entity.Bid;
import models.entity.Contract;
import models.entity.User;

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
		User reatiler = bid.getRetailer();
		return contract;
	}
}
