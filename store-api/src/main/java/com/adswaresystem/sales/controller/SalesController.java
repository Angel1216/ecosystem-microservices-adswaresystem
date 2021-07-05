package com.adswaresystem.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adswaresystem.clever.hotelier.clients.model.SaleDetailRequest;
import com.adswaresystem.sales.service.SalesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

/**
 * The class SalesController.
 * 
 * @author AdsWare System
 *
 *
 */
@RequestMapping("${api.basepath}")
@RestController
@AllArgsConstructor
@Api(value = "sales", description = "Sales details")
public class SalesController {
  
  /** The service for sales. */
  @Autowired
  private SalesService salesService;
  
  /**
   * Method to save sale detail.
   * 
   * @param request The SaleDetailRequest object
   * @throws Exception 
   */
  @ApiOperation(value = "Save sale detail")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Registry successfull"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Error in database")})
  @PostMapping(value = "${api.save-sale}")
  public ResponseEntity<Void> saveSale(@RequestBody SaleDetailRequest request) throws Exception {
	  salesService.saveSaleDetail(request);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  
}
