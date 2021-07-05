package com.adswaresystem.sales.utils;

import lombok.NoArgsConstructor;

/**
 * The interface CredentialsRepository.
 * 
 * @author AdsWare System
 *
 */
@NoArgsConstructor
public final class Constants {
  
  /** The REGISTRY_SUCCESSFUL constant. */
  public static final String REGISTRY_SUCCESSFUL =
      "El registro se realizo correctamente.";
  
  /** The REGISTRY_FAILED constant. */
  public static final String REGISTRY_FAILED =
      "Error al persistir el registro en base de datos: {}";
  
  /** The EMPTY_STRING constant. */
  public static final String EMPTY_STRING = "";
  
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
  
  /** The ERROR_CODE_BAD_REQUEST constant. */
  public static final String ERROR_CODE_BAD_REQUEST = "400";
  
  /** The ERROR_CODE_UNAUTHORIZED constant. */
  public static final String ERROR_CODE_UNAUTHORIZED = "401";
  
  /** The ERROR_CODE_INTERNAL_SERVER_ERROR constant. */
  public static final String ERROR_CODE_INTERNAL_SERVER_ERROR = "500";
  
  /** The SEMICOLON constant. */
  public static final String SEMICOLON = "; ";
  
  /** The TWO_POINTS constant. */
  public static final String TWO_POINTS = " : ";
  
  /** The VIOLATIONS_CONSTRAINT constant. */
  public static final String VIOLATIONS_CONSTRAINT = "violations";
  
  /** The ISERROR_CONSTRAINT constant. */
  public static final String ISERROR_CONSTRAINT = "isError";
  
  /** The ERROR_CONSTRAINT constant. */
  public static final String ERROR_CONSTRAINT = "Error en las restricciones del modelo: {}";
  
  /** The ERROR_CONSTRAINT_EXCEPTION constant. */
  public static final String ERROR_CONSTRAINT_EXCEPTION = "Error en las restricciones del modelo";
  
  /** The PATH_SALES constant. */
  public static final String PATH_SALES = "/sales";
  
  /** The PATTERN_TIME constant. */
  public static final String PATTERN_TIME = "HH:mm:ss";
  
  /** The PATTERN_DATE constant. */
  public static final String PATTERN_DATE = "yyyy-MM-dd";
  
  /** The PATTERN_DATE_TIME_SPLIT constant. */
  public static final String PATTERN_DATE_TIME_SPLIT = "T";
  
  /** The VALIDATE_HOUR constant. */
  public static final String VALIDATE_HOUR = "El formato o la hora, minutos y segundos no es valido: {}";
  
  /** The VALIDATE_HOUR_EXCEPTION constant. */
  public static final String VALIDATE_HOUR_EXCEPTION = "El formato o la hora, minutos y segundos no es valido: ";
  
  /** The VALIDATE_DATE constant. */
  public static final String VALIDATE_DATE = "El formato o la fecha no es valido: {}";
  
  /** The VALIDATE_DATE_EXCEPTION constant. */
  public static final String VALIDATE_DATE_EXCEPTION = "El formato o la fecha no es valido: ";
  
  /** The VALIDATE_DATE_TIME constant. */
  public static final String VALIDATE_DATE_TIME = "El formato o la fecha del atributo sellDate no es valido";
  
  /** The DATE_TIME_FORMATTER constant. */
  public static final String DATE_TIME_FORMATTER = "yyyy-MM-dd'T'HH:mm:ss";

  /** The PRODUCT_NOT_EXISTS constant. */
  public static final String PRODUCT_NOT_EXISTS =
      "ProductoId no existe en BD";
  
}
