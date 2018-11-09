package models.contract;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestContractService
{

	@Test
    public void testCreateContract() {
        assertEquals("test123", ContractService.testing());
    }

}
