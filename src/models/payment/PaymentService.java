package models.payment;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import models.entity.Contract;
import models.entity.EntityService;
import models.entity.RuntimeTypeAdapterFactory;

public class PaymentService extends EntityService{
	
	public static PaymentService paymentService;	
	static String filePath = "/WEB-INF/db/bankaccounts/Bankaccounts.json";
	ServletContext context;
	List<BankAccount> accounts =  new ArrayList<>();

	public PaymentService( ServletContext context, String filePath )
	{
		super( context, filePath );
	}
	
	public static PaymentService getPaymentServiceInstance(ServletContext context) throws FileNotFoundException
	{
		if(paymentService == null)
		{
			paymentService = new PaymentService(context,filePath);
			paymentService.loadEntities();
		}
		return paymentService;
	}

	void makePayment(Contract contract)
	{
		long retailerID = contract.getRetailerUserID();
		double finalCost = contract.getPriceOnFrequency();
		
	}
	
	BankAccount getBankAccount(long userID)
	{
		BankAccount bankAccount = null;
		for(BankAccount account : accounts)
		{
			if(account.getUserID() == userID)
			bankAccount = account;
		}
		return bankAccount;
	}
	
	public void loadEntities() throws FileNotFoundException
	{
		super.loadEntities();
		RuntimeTypeAdapterFactory<BankAccount> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
			    .of(BankAccount.class, "type")
			    .registerSubtype(PayPal.class, "paypal")
			    .registerSubtype(Venmo.class, "venmo")
			    .registerSubtype(AmazonPayments.class, "amazonpayments");
		Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();
		Type listType = new TypeToken<List<BankAccount>>(){}.getType();
		accounts = gson.fromJson(new InputStreamReader(getIs()), listType);
	}
	
	public List<BankAccount> getBankAccoutns()
	{
		return accounts;
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
