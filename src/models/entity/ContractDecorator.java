package models.entity;

public class ContractDecorator extends Contract
{
    private Contract contract;
    
    public ContractDecorator(Contract contract)
	{
		this.contract = contract;
	}
    
	@Override
	public double getPriceOnFrequency()
	{
		return contract.getPriceOnFrequency();
	}

	@Override
	public StringBuilder getContractConstraints()
	{
		return contract.getContractConstraints();
	}

}
