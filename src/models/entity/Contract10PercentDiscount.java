package models.entity;

public class Contract10PercentDiscount extends Contract
{	
	private Contract contract;
	
	public Contract10PercentDiscount(Contract contract)
	{
		super();
		this.contract = contract;
	}

	@Override
	public double getPriceOnFrequency()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StringBuilder getContractConstraints()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
