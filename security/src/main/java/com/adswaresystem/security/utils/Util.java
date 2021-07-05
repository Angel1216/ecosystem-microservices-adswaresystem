package com.adswaresystem.security.utils;

import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adswaresystem.security.exceptions.custom.BadRequestException;
import com.adswaresystem.security.validation.BusinessValidation;

/**
 * The class Util.
 * 
 * @author AdsWare System
 *
 */
public class Util {
  
  /**
   * The log attribute.
   */
  private static final Logger log = LoggerFactory.getLogger(Util.class);
  
  /**
   * Builder.
   */
  private Util() {
	  
  }
  
  /**
   * Method to define default value.
   * 
   * @param target the target
   * @param defaultValue the defaultValue
   * @return the object description
   */
  public static Object defaultValue(Object target, Object defaultValue) {
    return Objects.isNull(target) ? defaultValue : target;
  }
  
  /**
   * Method to validate constraints.
   * 
   * @param request the object to validate
   */
  public static void validateConstraints(Object request, BusinessValidation businessValidation) {
	    
    // Validar restricciones del modelo
    Map<String, Object> constraints = businessValidation.validateConstraintsGenerics(request);
	    
    if(Boolean.valueOf(constraints.get(Constants.ISERROR_CONSTRAINT).toString())) {
      log.error(Constants.ERROR_CONSTRAINT, constraints.get(Constants.VIOLATIONS_CONSTRAINT).toString());
      throw new BadRequestException(Constants.ERROR_CONSTRAINT_EXCEPTION,
          constraints.get(Constants.VIOLATIONS_CONSTRAINT).toString());
    }
    
  }

}
