package com.adswaresystem.clever.hotelier.clients.model;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The class LoginResponse.
 * 
 * @author AdsWare System
 *
 */
@Getter
@Setter
@Builder
@ApiModel(description = "Información de usuario autenticado")
public class LoginResponse {
	
  /** The name attribute. */
  private String name;
	  
  /** The middleName attribute. */
  private String middleName;
	  
  /** The userRole attribute. */
  private Integer userRole;

}
