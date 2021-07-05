package com.adswaresystem.sales.validation;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.adswaresystem.clever.hotelier.clients.model.Sale;
import com.adswaresystem.clever.hotelier.clients.model.SaleDetailRequest;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BusinessValidationImplTest {
	
	@InjectMocks
	private BusinessValidationImpl businessValidationImpl;
	
	@Test
	public void validateConstraintsGenericsNoOkTest() {
		SaleDetailRequest saleDetailRequest = new SaleDetailRequest();
		businessValidationImpl.validateConstraintsGenerics(saleDetailRequest);
	}
	
	@Test
	public void validateConstraintsGenericsOkTest() {
		Sale sale = new Sale();
		SaleDetailRequest saleDetailRequest = new SaleDetailRequest();
		
		sale.setProductId(1);
		sale.setProductQuantity(3);
		sale.setSellPrice(23D);
		
		List<Sale> lstSale = new ArrayList<>();
		lstSale.add(sale);
		
		saleDetailRequest.setCustomerId(23);
		saleDetailRequest.setSale(lstSale);
		saleDetailRequest.setSalesAmount(23D);
		saleDetailRequest.setSellDate("");
		saleDetailRequest.setTaxes(23D);
		
		assertNotNull(businessValidationImpl.validateConstraintsGenerics(saleDetailRequest));
	}

}
