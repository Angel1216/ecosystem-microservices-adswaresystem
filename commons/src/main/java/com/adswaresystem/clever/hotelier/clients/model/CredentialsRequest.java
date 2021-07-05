package com.adswaresystem.clever.hotelier.clients.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@ApiModel(description = "Credenciales que serán validadas")
public class CredentialsRequest {
  
  /** The user attribute. */
  @NotNull(message = "El username se requiere")
  @NotBlank(message = "El username no debe estar en blanco")
  @NotEmpty(message = "El username no debe estar vacío")
  private String username;

  /** The password attribute. */
  @NotNull(message = "El password se requiere")
  @NotBlank(message = "El password no debe estar en blanco")
  @NotEmpty(message = "El password no debe estar vacío")
  @Size(min = 5, max = 8, message = "La contraseña debe tener entre 5 y 8 caracteres")
  private String password;
  
}
