package com.adswaresystem.sales.service.impl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.adswaresystem.clever.hotelier.clients.entity.Product;
import com.adswaresystem.clever.hotelier.clients.model.Sale;
import com.adswaresystem.clever.hotelier.clients.model.SaleDetailRequest;
import com.adswaresystem.sales.exceptions.custom.BadRequestException;
import com.adswaresystem.sales.exceptions.custom.InternalServerErrorException;
import com.adswaresystem.sales.repository.ProductRepository;
import com.adswaresystem.sales.repository.SaleProductDetailRepository;
import com.adswaresystem.sales.repository.SalesProductRepository;
import com.adswaresystem.sales.validation.BusinessValidation;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SalesServiceImplTest {
	
	@InjectMocks
	private SalesServiceImpl salesServiceImpl;
	
	/** The productRepository attribute. */
	@Mock
	private ProductRepository productRepository;

	/** The salesProductRepository attribute. */
	@Mock
	private SalesProductRepository salesProductRepository;
  
	/** The saleProductDetailRepository attribute. */
	@Mock
	private SaleProductDetailRepository saleProductDetailRepository;
  
	/** The businessValidation attribute. */
	@Mock
	private BusinessValidation businessValidation;
	
	@Test(expected = BadRequestException.class)
	public void saveSaleDetailDateWrongTest() throws Exception {
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
		
		Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
		salesServiceImpl.saveSaleDetail(saleDetailRequest);
	}
	
	@Test(expected = InternalServerErrorException.class)
	public void saveSaleDetailProductInvalidTest() throws Exception {
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
		saleDetailRequest.setSellDate("2021-12-31T23:59:59");
		saleDetailRequest.setTaxes(23D);
		
		Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
		salesServiceImpl.saveSaleDetail(saleDetailRequest);
	}

	@Test(expected = BadRequestException.class)
	public void saveSaleDetailHourWrongTest() throws Exception {
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
		saleDetailRequest.setSellDate("2020-12-31T24:59:59");
		saleDetailRequest.setTaxes(23D);
		
		Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
		Product product = new Product();
		Optional<Product> entityProduct = Optional.of(product);
		when(productRepository.findById(Mockito.any())).thenReturn(entityProduct);
		 
		
		salesServiceImpl.saveSaleDetail(saleDetailRequest);
	}
	
	@Test
	public void saveSaleDetailTest() throws Exception {
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
		saleDetailRequest.setSellDate("2020-12-31T23:59:59");
		saleDetailRequest.setTaxes(23D);
		
		Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
		Product product = new Product();
		Optional<Product> entityProduct = Optional.of(product);
		when(productRepository.findById(Mockito.any())).thenReturn(entityProduct);
		
		salesServiceImpl.saveSaleDetail(saleDetailRequest);
	}
	
}
