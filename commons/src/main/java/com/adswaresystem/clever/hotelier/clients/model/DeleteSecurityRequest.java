package com.adswaresystem.clever.hotelier.clients.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * The class LoginRequest.
 * 
 * @author AdsWare System
 *
 */
@Getter
@Setter
@ApiModel(description = "Nombre de usuario que se eliminará")
public class DeleteSecurityRequest {
	
  /** The user attribute. */
  @NotNull(message = "El username se requiere")
  @NotBlank(message = "El username no debe estar en blanco")
  @NotEmpty(message = "El username no debe estar vacío")
  private String username;

}
