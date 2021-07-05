package com.adswaresystem.clever.hotelier.clients.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;

/**
 * The class SaleDetailRequest.
 * 
 * @author AdsWare System
 *
 */
@Getter
@Setter
@ApiModel(description = "Detalle de venta que se guardará")
public class SaleDetailRequest {
  
  /** The sale attribute. */
  @NotNull
  @Valid
  private List<Sale> sale;
  
  /** The salesAmount attribute. */
  @NotNull
  private Double salesAmount;
  
  /** The sellDate attribute. */
  @NotNull
  private String sellDate;
  
  /** The iva attribute. */
  @NotNull
  private Double taxes;
  
  /** The customerId attribute. */
  private Integer customerId;
  
}
