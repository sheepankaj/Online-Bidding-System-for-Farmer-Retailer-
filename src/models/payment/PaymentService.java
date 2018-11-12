package models.payment;

import models.entity.Contract;

public class PaymentService {

	void makePayment(Contract contract)
	{
		long retailerID = contract.getRetailerUserID();
		double finalCost = contract.getPriceOnFrequency();
		
	}
}
