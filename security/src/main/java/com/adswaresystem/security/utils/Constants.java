package com.adswaresystem.security.utils;

/**
 * The interface CredentialsRepository.
 * 
 * @author AdsWare System
 *
 */
public final class Constants {
  
  /** The REGISTRY_SUCCESSFUL constant. */
  public static final String REGISTRY_SUCCESSFUL =
      "El registro del usuario {} se realizo correctamente.";
  
  /** The REGISTRY_FAILED constant. */
  public static final String REGISTRY_FAILED =
      "Error al persistir el registro del usuario {} en base de datos: {}";
  
  /** The REGISTRY_FAILED constant. */
  public static final String INVALID_CREDENTIALS =
      "Credenciales invalidas para el usuario {}";
  
  /** The INVALID_CREDENTIALS_EXCEPTION constant. */
  public static final String INVALID_CREDENTIALS_EXCEPTION =
      "Credenciales invalidas";
  
  /** The INVALID_USER constant. */
  public static final String INVALID_USER =
      "Error al recuperar la informacion del nombre de usuario {}";
  
  /** The INVALID_USER_EXCEPTION constant. */
  public static final String INVALID_USER_EXCEPTION =
      "Error al recuperar la informacion del nombre de usuario";
  
  /** The USER_EXISTS constant. */
  public static final String USER_EXISTS =
      "El usuario {} {} {} ya existe";
  
  /** The USER_EXISTS_EXCEPTION constant. */
  public static final String USER_EXISTS_EXCEPTION =
      "El usuario ya existe";
  
  /** The USERNAME_EXISTS constant. */
  public static final String USERNAME_EXISTS =
      "El nombre de usuario {} ya existe";
  
  /** The USERNAME_EXISTS_EXCEPTION constant. */
  public static final String USERNAME_EXISTS_EXCEPTION =
      "El nombre de usuario ya existe";
  
  /** The USERNAME_UPDATE constant. */
  public static final String USERNAME =
      "El nombre de usuario {} no existe";
  
  /** The USERNAME_UPDATE_EXCEPTION constant. */
  public static final String USERNAME_EXCEPTION =
      "El nombre de usuario no existe";
  
  /** The USERROL_INVALID constant. */
  public static final String USERROL_INVALID =
      "El rol del usuario {} no es valido";
  
  /** The USERROL_INVALID_EXCEPTION constant. */
  public static final String USERROL_INVALID_EXCEPTION =
      "Rol de usuario no valido";
  
  /** The EMPTY_STRING constant. */
  public static final String EMPTY_STRING = "";
  
  /** The PATH_REGISTRY constant. */
  public static final String PATH_REGISTRY = "/registry";
  
  /** The PATH_UPDATE constant. */
  public static final String PATH_UPDATE = "/update";
  
  /** The PATH_DELETE constant. */
  public static final String PATH_DELETE = "/delete";
  
  /** The PATH_LOGIN constant. */
  public static final String PATH_LOGIN = "/login";
  
  /** The ERR_TIME_PATTERN constant. */
  public static final String ERR_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";
  
  /** The COMMA_SEPARATOR constant. */
  public static final String COMMA_SEPARATOR = ",";
  
  /** The ERROR_RESPONSE_TYPE constant. */
  public static final String ERROR_RESPONSE_TYPE = "errorResponse.type, {}";
  
  /** The ERROR_RESPONSE_CODE constant. */
  public static final String ERROR_RESPONSE_CODE = "errorResponse.code, {}";
  
  /** The ERROR_RESPONSE_DETAILS constant. */
  public static final String ERROR_RESPONSE_DETAILS = "errorResponse.details, {}";
  
  /** The ERROR_RESPONSE_LOCATION constant. */
  public static final String ERROR_RESPONSE_LOCATION = "errorResponse.location, {}";
  
  /** The ERROR_RESPONSE_MORE_INFO constant. */
  public static final String ERROR_RESPONSE_MORE_INFO = "errorResponse.moreinfo, {}";
  
  /** The ERROR_CODE_UNAUTHORIZED constant. */
  public static final String ERROR_CODE_UNAUTHORIZED = "401";
  
  /** The ERROR_CODE_BAD_REQUEST constant. */
  public static final String ERROR_CODE_BAD_REQUEST = "400";
  
  /** The ERROR_CODE_INTERNAL_SERVER_ERROR constant. */
  public static final String ERROR_CODE_INTERNAL_SERVER_ERROR = "500";
  
  /** The ERROR_CODE_NOT_FOUND constant. */
  public static final String ERROR_CODE_NOT_FOUND = "404";
  
  /** The VIOLATIONS_CONSTRAINT constant. */
  public static final String VIOLATIONS_CONSTRAINT = "violations";
  
  /** The ISERROR_CONSTRAINT constant. */
  public static final String ISERROR_CONSTRAINT = "isError";
  
  /** The ERROR_CONSTRAINT constant. */
  public static final String ERROR_CONSTRAINT = "Error en las restricciones del modelo: {}";
  
  /** The ERROR_CONSTRAINT_EXCEPTION constant. */
  public static final String ERROR_CONSTRAINT_EXCEPTION = "Error en las restricciones del modelo";
  
  /** The SEMICOLON constant. */
  public static final String SEMICOLON = "; ";
  
  /** The TWO_POINTS constant. */
  public static final String TWO_POINTS = " : ";
  
  /** The USER_ROL_ADMINISTRATOR constant. */
  public static final Integer USER_ROL_ADMINISTRATOR = 2;
  
  /** The MAXIMUM_ADMINISTRATORS constant. */
  public static final Integer MAXIMUM_ADMINISTRATORS = 3;
  
  /** The MAXIMUM_ALLOWABLE_ADMINISTRATORS constant. */
  public static final String MAXIMUM_ALLOWABLE_ADMINISTRATORS = "No se puede registrar el usuario {}, ya cuenta con los administradores maximos permitidos";
  
  /** The MAXIMUM_ALLOWABLE_ADMINISTRATORS_EXCEPTION constant. */
  public static final String MAXIMUM_ALLOWABLE_ADMINISTRATORS_EXCEPTION = "Administradores maximos permitidos";
  
  /** The STATUS_DEFAULT constant. */
  public static final Boolean STATUS_DEFAULT = true;
  
  /** The USER_ROL_SUPER_USER constant. */
  public static final Integer USER_ROL_SUPER_USER = 1;

  /** The MAXIMUM_SUPER_USER constant. */
  public static final Integer MAXIMUM_SUPER_USER = 1;

  /** The MAXIMUM_ALLOWABLE_SUPER_USER constant. */
  public static final String MAXIMUM_ALLOWABLE_SUPER_USER = "No se puede registrar el usuario {}, el sistema ya cuenta con un super usuario";
  
  /** The MAXIMUM_ALLOWABLE_SUPER_USER_EXCEPTION constant. */
  public static final String MAXIMUM_ALLOWABLE_SUPER_USER_EXCEPTION = "El sistema solo permite 1 super usuario";

  /** The CAPITAL_LETTERS_ERROR constant. */
  public static final String CAPITAL_LETTERS_ERROR = "No se permiten más de 2 caracteres en mayúsculas; ";

  /** The NUMBERS_ERROR constant. */
  public static final String NUMBERS_ERROR = "No se permiten más de 3 caracteres numéricos";

  
  /**
   * Builder.
   */
  private Constants() {
	  
  }
  
}
