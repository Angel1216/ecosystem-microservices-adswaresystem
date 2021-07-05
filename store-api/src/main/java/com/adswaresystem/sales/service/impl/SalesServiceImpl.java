package com.adswaresystem.sales.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.adswaresystem.sales.repository.ProductRepository;
import com.adswaresystem.sales.repository.SaleProductDetailRepository;
import com.adswaresystem.sales.repository.SalesProductRepository;
import com.adswaresystem.sales.service.SalesService;
import com.adswaresystem.sales.utils.Constants;
import com.adswaresystem.sales.utils.Util;
import com.adswaresystem.sales.validation.BusinessValidation;
import com.adswaresystem.clever.hotelier.clients.entity.Product;
import com.adswaresystem.clever.hotelier.clients.entity.SaleProductDetail;
import com.adswaresystem.clever.hotelier.clients.entity.SalesProduct;
import com.adswaresystem.clever.hotelier.clients.model.Sale;
import com.adswaresystem.clever.hotelier.clients.model.SaleDetailRequest;
import com.adswaresystem.sales.exceptions.custom.BadRequestException;
import com.adswaresystem.sales.exceptions.custom.InternalServerErrorException;

import lombok.AllArgsConstructor;

/**
 * The class RegistryServiceImpl.
 * 
 * @author AdsWare System
 *
 */
@Service
@Transactional
@AllArgsConstructor
public class SalesServiceImpl implements SalesService {

  /** The log attribute. */
  private static final Logger log = LoggerFactory.getLogger(SalesServiceImpl.class);

  /** The productRepository attribute. */
  @Autowired
  private ProductRepository productRepository;

  /** The salesProductRepository attribute. */
  @Autowired
  private SalesProductRepository salesProductRepository;
  
  /** The saleProductDetailRepository attribute. */
  @Autowired
  private SaleProductDetailRepository saleProductDetailRepository;
  
  /** The businessValidation attribute. */
  @Autowired
  private BusinessValidation businessValidation;
  
  /**
   * Method to make the registry.
   * 
   * @param request The RegistryRequest object
   * @throws Exception 
   */
  @Override
  public void saveSaleDetail(SaleDetailRequest request) throws Exception {

    // Validar restricciones del modelo
    Util.validateConstraints(request, businessValidation);
    validateDateTime(request);
    
    try {
    	
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMATTER);
      LocalDateTime dateTime = LocalDateTime.parse(request.getSellDate(), formatter);
      ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.systemDefault());

      SalesProduct salesProduct = SalesProduct.builder()
          .salesAmount(request.getSalesAmount())
          .sell_date(zonedDateTime)
          .taxes(request.getTaxes())
          .customerId(request.getCustomerId())
          .build();
        
      // Insertar venta
      salesProductRepository.save(salesProduct);
    	
      // Insertar detalle de venta
      request.getSale().forEach(row -> addRowSaleProductDetail(row, salesProduct));
      
      log.info(Constants.REGISTRY_SUCCESSFUL);
    } catch(DataAccessException ex) {
      log.error(Constants.REGISTRY_FAILED, ex.getMessage());
      throw new InternalServerErrorException(ex.getMessage(), Constants.PATH_SALES);
    } catch(Exception ex) {
      log.error(Constants.REGISTRY_FAILED, ex.getMessage());
      throw new InternalServerErrorException(ex.getMessage(), Constants.PATH_SALES);
    }
    
  }
  
  /**
   * Method to add row sale product detail.
   * 
   * @param row the productId
   * @param salesProduct the main sale
   */
  public void addRowSaleProductDetail(Sale row, SalesProduct salesProduct) {
	
	Optional<Product> product = productRepository.findById(row.getProductId());
	
	if(!product.isPresent()) {
		log.error(Constants.PRODUCT_NOT_EXISTS);
		throw new InternalServerErrorException(Constants.PRODUCT_NOT_EXISTS, Constants.PATH_SALES);
	}
	
	SaleProductDetail saleProductDetail = SaleProductDetail.builder()
        .saleId(salesProduct)
        .productId(product.get())
        .productQuantity(row.getProductQuantity())
        .sellPrice(row.getSellPrice())
        .build();
	
  	saleProductDetailRepository.save(saleProductDetail);
  	
  	// Productos restantes
  	int remainingProduct = product.get().getInStock() - row.getProductQuantity();
  	product.get().setInStock(remainingProduct);
  	
  	productRepository.save(product.get());
  }
  
  /**
   * Method to validate the date and time.
   * 
   * @param request the object SaleDetailRequest
   */
  public void validateDateTime(SaleDetailRequest request) {
	  
	String[] dateTimeExp = request.getSellDate().split(Constants.PATTERN_DATE_TIME_SPLIT);

  	if(!validateDate(dateTimeExp[0])) {
  		log.error(Constants.VALIDATE_DATE, request.getSellDate());
        throw new BadRequestException(Constants.VALIDATE_DATE_EXCEPTION.concat(request.getSellDate()), Constants.PATH_SALES);
  	}
  	
  	if(!validateHour(dateTimeExp[1])) {
  		log.error(Constants.VALIDATE_HOUR, request.getSellDate());
        throw new BadRequestException(Constants.VALIDATE_HOUR_EXCEPTION.concat(request.getSellDate()), Constants.PATH_SALES);
  	}
	  
  }
  
  /**
   * Method to validate date.
   * 
   * @param date the date
   * @return the flag
   */
  public boolean validateDate(String date) {
      try {
          SimpleDateFormat formatoFecha = new SimpleDateFormat(Constants.PATTERN_DATE);
          formatoFecha.setLenient(false);
          formatoFecha.parse(date);
      } catch (ParseException e) {
          return false;
      }
      return true;
  }
  
  /**
   * Method to validate time.
   * 
   * @param time the time
   * @return the flag
   */
  public boolean validateHour(String time) {
      try {
          SimpleDateFormat formatoFecha = new SimpleDateFormat(Constants.PATTERN_TIME);
          formatoFecha.setLenient(false);
          formatoFecha.parse(time);
      } catch (ParseException e) {
          return false;
      }
      return true;
  }
  
}
