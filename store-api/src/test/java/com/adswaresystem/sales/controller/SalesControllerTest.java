package com.adswaresystem.sales.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.adswaresystem.clever.hotelier.clients.model.SaleDetailRequest;
import com.adswaresystem.sales.service.SalesService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SalesControllerTest {
	
	@InjectMocks
	private SalesController salesController;
	
	@Mock
	private SalesService salesService;
	
	@Test
	public void saveSaleTest() throws Exception {
		SaleDetailRequest request = new SaleDetailRequest();
		assertNotNull(salesController.saveSale(request));
	}
	
}
