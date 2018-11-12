package models.contract;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import models.entity.Bid;
import models.entity.Contract10PercentDiscount;
import models.entity.DailyContract;
import models.entity.ProductStock;
import models.entity.Retailer;
import models.entity.StockFrequency;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ContractFactory.class)
class TestContractService
{
	@Test
    public void testCreateContract() {
		PowerMockito.mockStatic(ContractFactory.class);
		Bid bid = mock(Bid.class);
		Retailer retailer = mock(Retailer.class);
		ProductStock stock = mock(ProductStock.class);
		ContractFactory contractFactory = mock(ContractFactory.class);
		PowerMockito.when(bid.getRetailer()).thenReturn(new Retailer());
		PowerMockito.when(bid.getProductStock()).thenReturn(new ProductStock());
		ContractService contractService = mock(ContractService.class);
		Contract10PercentDiscount discount = mock(Contract10PercentDiscount.class);
		PowerMockito.when(retailer.getSuccessfullyClosedContracts()).thenReturn(105);
		PowerMockito.when(stock.getFrequency()).thenReturn(StockFrequency.DAILY);
		PowerMockito.when(ContractFactory.createContract(StockFrequency.DAILY)).thenReturn(new DailyContract());
        assertTrue(contractService.createContract(bid) instanceof Contract10PercentDiscount);
    }

}
