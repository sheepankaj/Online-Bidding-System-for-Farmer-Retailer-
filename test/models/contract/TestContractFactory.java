package models.contract;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import models.entity.DailyContract;
import models.entity.StockFrequency;

class TestContractFactory
{

	@Test
	void testCreateContract()
	{
		assertTrue(ContractFactory.createContract( StockFrequency.DAILY ) instanceof DailyContract);
	}

}
