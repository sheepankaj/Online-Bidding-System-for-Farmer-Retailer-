package models.contract;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import models.entity.Bid;
import models.entity.Contract;
import models.entity.Contract10PercentDiscount;
import models.entity.DailyContract;
import models.entity.EntityService;
import models.entity.MonthlyContract;
import models.entity.Retailer;
import models.entity.RuntimeTypeAdapterFactory;
import models.entity.StockFrequency;
import models.entity.WeeklyContract;
import models.entity.YearlyContract;
import models.profile.ProfilesService;

public class ContractService extends EntityService
{
	private static ContractService instance;
	static String filePath = "/WEB-INF/db/contract/Contract.json";
	private List<Contract> contracts = new ArrayList<>();
	
	private ContractService(ServletContext context,String filePath)
	{
		super(context,filePath);
	}
	
	public static ContractService getContractServiceInstance(ServletContext context)
	{
		if(instance == null)
		{
			instance = new ContractService(context,filePath);
			instance.loadEntities();
			//instance.testGSON();
		}
		return instance;
	}
	
	public Contract createContract(Bid bid)
	{
		Contract contract = null;
		Retailer retailer = (Retailer)ProfilesService.getProfile( bid.getRetailerID() );
		StockFrequency frequency = bid.getProductStock().getFrequency();
		
		// If the Retailer has more than 100 successfully closed contracts then he gets a 10 percent discount
		// this is achieved by decorating the contract
		if(retailer.getSuccessfullyClosedContracts()>100)
		{
			contract = new Contract10PercentDiscount( ContractFactory.createContract( frequency,bid ) );
		}
		else
		{
			contract =  ContractFactory.createContract( frequency,bid);
		}		
		return contract;
	}	
	
	public String  getRetailerContracts(long retailerID) {
		List<Contract> retailersContracts = new ArrayList<>();
		for(Contract contract : contracts)
		{
			if(contract.getRetailerUserID() == retailerID)
				retailersContracts.add(contract);
		}
		return getGson().toJson(retailersContracts);
	}
	
	public void loadEntities()
	{
		try
		{
			super.loadEntities();
		}
		catch ( FileNotFoundException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RuntimeTypeAdapterFactory<Contract> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
			    .of(Contract.class, "type")
			    .registerSubtype(DailyContract.class, "dailycontract")
			    .registerSubtype(WeeklyContract.class, "weeklycontract")
			    .registerSubtype(MonthlyContract.class, "monthlycontract")
		        .registerSubtype(YearlyContract.class, "yearlycontract");
		
		Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();
		Type listType = new TypeToken<List<Contract>>(){}.getType();
		contracts = gson.fromJson(new InputStreamReader(getIs()), listType);
	}
	
	
	public void testGSON()
	{
		List<Contract> contracts = new ArrayList<>();
		
//			contracts.add(new DailyContract());
//			contracts.add(new WeeklyContract());
//			contracts.add(new YearlyContract());
			
			RuntimeTypeAdapterFactory<Contract> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
				    .of(Contract.class, "type")
				    .registerSubtype(DailyContract.class, "dailycontract")
				    .registerSubtype(WeeklyContract.class, "weeklycontract")
				    .registerSubtype(MonthlyContract.class, "monthlycontract")
			        .registerSubtype(YearlyContract.class, "yearlycontract");
			
			

			Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();

			String json = gson.toJson(contracts);
			System.out.println( json );
			Type listType = new TypeToken<List<Contract>>(){}.getType();
			List<Contract> fromJson = gson.fromJson(json, listType);
	}

	public Contract getContractByID( String selectedContractID )
	{
		Contract contractFound = null;
		for(Contract contract : contracts)
		{
			if(contract.getContractID() == Long.parseLong( selectedContractID ))
            contractFound = contract;
		}
		return contractFound;
	}
}
