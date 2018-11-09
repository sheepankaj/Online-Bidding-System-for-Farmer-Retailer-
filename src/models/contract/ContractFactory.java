package models.contract;

import models.entity.Contract;
import models.entity.DailyContract;
import models.entity.MonthlyContract;
import models.entity.StockFrequency;
import models.entity.WeeklyContract;
import models.entity.YearlyContract;

public class ContractFactory
{
	public static Contract createContract(StockFrequency stockFrequency)
	{
		Contract contract = null;
		if(stockFrequency.equals( StockFrequency.DAILY ))
		{
			new DailyContract() ;
		}
		else if(stockFrequency.equals( StockFrequency.WEEKLY))
		{
			new WeeklyContract();
		}
		else if(stockFrequency.equals( StockFrequency.MONTHLY))
		{
			new MonthlyContract();
		}
		else if(stockFrequency.equals( StockFrequency.YEARLY))
		{
			new YearlyContract();
		}
		return contract;
	}
}
