package models.contract;

import models.entity.Bid;
import models.entity.Contract;
import models.entity.DailyContract;
import models.entity.MonthlyContract;
import models.entity.StockFrequency;
import models.entity.WeeklyContract;
import models.entity.YearlyContract;

public class ContractFactory
{
	public static Contract createContract(StockFrequency stockFrequency,Bid bid)
	{
		Contract contract = null;
		if(stockFrequency.equals( StockFrequency.DAILY ))
		{
			contract = new DailyContract(bid) ;
		}
		else if(stockFrequency.equals( StockFrequency.WEEKLY))
		{
			contract = new WeeklyContract(bid);
		}
		else if(stockFrequency.equals( StockFrequency.MONTHLY))
		{
			contract = new MonthlyContract(bid);
		}
		else if(stockFrequency.equals( StockFrequency.YEARLY))
		{
			contract = new YearlyContract(bid);
		}
		return contract;
	}
}
