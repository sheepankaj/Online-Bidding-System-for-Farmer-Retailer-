package models.contract;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import models.entity.Bid;
import models.entity.Contract10PercentDiscount;
import models.entity.DailyContract;
import models.entity.ProductStock;
import models.entity.Retailer;
import models.entity.StockFrequency;

class TestContractService
{
	@Test
    public void testCreateContract() {
		Bid bid = mock(Bid.class);
		Retailer retailer = mock(Retailer.class);
		ProductStock stock = mock(ProductStock.class);
		ContractFactory contractFactory = mock(ContractFactory.class);
		when(bid.getRetailer()).thenReturn(new Retailer());
		when(bid.getProductStock()).thenReturn(new ProductStock());
		ContractService contractService = mock(ContractService.class);
		Contract10PercentDiscount discount = mock(Contract10PercentDiscount.class);
		when(retailer.getSuccessfullyClosedContracts()).thenReturn(105);
		when(stock.getFrequency()).thenReturn(StockFrequency.DAILY);
		when(ContractFactory.createContract(StockFrequency.DAILY)).thenReturn(new DailyContract());
        assertTrue(contractService.createContract(bid) instanceof Contract10PercentDiscount);
    }

}
