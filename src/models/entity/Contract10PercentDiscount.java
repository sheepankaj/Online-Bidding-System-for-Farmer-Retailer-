package models.entity;

public class Contract10PercentDiscount extends ContractDecorator
{		
	public Contract10PercentDiscount(Contract contract)
	{
		super(contract);
	}

	@Override
	public double getPriceOnFrequency()
	{
		return super.getPriceOnFrequency()*90/100;
	}

	@Override
	public StringBuilder getContractConstraints()
	{
		return super.getContractConstraints().append( "  > Retailer will receive 10 percent discount.\n" );
	}	
	
	@Override
	public String getFarmerDetails() {
		return super.getFarmerDetails();
	}

	@Override
	public String getRetailerDetails() {
		return super.getRetailerDetails();
	}
	
	@Override
	public Contract getContract() {
		return super.getContract();
	}
	
}
