package models.contract;

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
import models.entity.EntityService;
import models.entity.Retailer;
import models.entity.RuntimeTypeAdapterFactory;
import models.entity.StockFrequency;
import models.payment.AmazonPayments;
import models.payment.BankAccount;
import models.payment.PayPal;
import models.payment.Venmo;
import models.profile.ProfilesService;

public class ContractService extends EntityService
{
	private static ContractService instance;
	static String filePath = "/WEB-INF/db/product/Product.json";
	
	private ContractService(ServletContext context,String filePath)
	{
		super(context,filePath);
	}
	
	public static ContractService getContractServiceInstance(ServletContext context,String filePath)
	{
		if(instance == null)
		{
			instance = new ContractService(context,filePath);
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
			contract = new Contract10PercentDiscount( ContractFactory.createContract( frequency ) );
		}
		contract = new Contract10PercentDiscount( ContractFactory.createContract( StockFrequency.DAILY ) );
		return contract;
	}
	
	public void testGSON()
	{
		List<BankAccount> accounts = new ArrayList<>();
		accounts.add(new PayPal(4000,"PP3784","PA7748849393",100106,"100106@paypal.com"));
		accounts.add(new AmazonPayments(8000,"AP5467","PA7748849393",100107,"100106@amazon.com"));
		accounts.add(new Venmo(6000,"VO2334","VO34342232",100108,"100106@venmo.com"));
		accounts.add(new PayPal(9000,"PP7895","PA7748849393",100109,"100106@paypal.com"));
		
		RuntimeTypeAdapterFactory<BankAccount> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
			    .of(BankAccount.class, "type")
			    .registerSubtype(PayPal.class, "paypal")
			    .registerSubtype(Venmo.class, "venmo")
			    .registerSubtype(AmazonPayments.class, "amazonpayments");
			Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();

			String json = gson.toJson(accounts);
			System.out.println( json );
			Type listType = new TypeToken<List<BankAccount>>(){}.getType();
			List<BankAccount> fromJson = gson.fromJson(json, listType);
	}
}
