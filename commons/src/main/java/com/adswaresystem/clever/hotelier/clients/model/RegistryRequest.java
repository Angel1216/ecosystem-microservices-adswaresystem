package com.adswaresystem.clever.hotelier.clients.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

/**
 * El class RegistryRequest.
 * 
 * @author AdsWare System
 *
 */
@Getter
@Setter
@ApiModel(description = "Usuario que se guardará")
public class RegistryRequest {
  
  /** El username attribute. */
  @NotNull(message = "El username se requiere")
  @NotBlank(message = "El username no debe estar en blanco")
  @NotEmpty(message = "El username no debe estar vacío")
  private String username;
  
  /** El password attribute. */
  @NotNull(message = " password se requiere")
  @NotBlank(message = "El password no debe estar en blanco")
  @NotEmpty(message = "El password no debe estar vacío")
  @Size(min = 5, max = 8, message = "La contraseña debe tener entre 5 y 8 caracteres")
  private String password;
  
  /** El email attribute. */
  @NotNull(message = "El email se requiere")
  @NotBlank(message = "El email no debe estar en blanco")
  @NotEmpty(message = "El email no debe estar vacío")
  @Pattern(regexp="[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,4}", message = "El email debe ser un correo electrónico")
  private String email;
  
  /** El name attribute. */
  @NotNull(message = "El name se requiere")
  @NotBlank(message = "El name no debe estar en blanco")
  @NotEmpty(message = "El name no debe estar vacío")
  private String name;
  
  /** El middleName attribute. */
  @NotNull(message = "El middleName se requiere")
  @NotBlank(message = "El middleName no debe estar en blanco")
  @NotEmpty(message = "El middleName no debe estar vacío")
  private String middleName;
  
  /** El lastName attribute. */
  @NotNull(message = "El lastName se requiere")
  @NotBlank(message = "El lastName no debe estar en blanco")
  @NotEmpty(message = "El lastName no debe estar vacío")
  private String lastName;
  
  /** El userRole attribute. */
  @NotNull(message = "El userRole se requiere")
  private Integer userRole;

}
