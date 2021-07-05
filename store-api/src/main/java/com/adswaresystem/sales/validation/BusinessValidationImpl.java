package com.adswaresystem.sales.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

import com.adswaresystem.sales.utils.Constants;

/**
 * The class BusinessValidationImpl.
 * 
 * @author AdsWare System
 *
 */
@Service
public class BusinessValidationImpl implements BusinessValidation {

	/**
	 * Method to validate constraints generics.
	 * 
	 * @param request the object to validate
	 * @return the flag constraint
	 */
	@Override
	public Map<String, Object> validateConstraintsGenerics(Object request) {
	      
	      Map<String, Object> constraints = new HashMap<>();
	      
	      StringBuilder fieldsError = new StringBuilder();
	      ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
	      Validator validator = validatorFactory.getValidator();
	      Set<ConstraintViolation<Object>> violations = 
	          validator.validate(request);
	      
	      if(!violations.isEmpty()) {
	    	  violations.forEach(row -> {
	    		  ConstraintViolation<Object> action = row;
	    		  fieldsError.append(action.getPropertyPath()).append(Constants.TWO_POINTS)
	    		      .append(action.getMessage()).append(Constants.SEMICOLON);
	    	  });
	    	  
	    	  constraints.put(Constants.VIOLATIONS_CONSTRAINT, fieldsError.toString());
	    	  constraints.put(Constants.ISERROR_CONSTRAINT, true);
	    	  
	    	  return constraints;
	      }
	      
	      constraints.put(Constants.VIOLATIONS_CONSTRAINT, null);
		  constraints.put(Constants.ISERROR_CONSTRAINT, false);
		  
		  return constraints;
		}

}
