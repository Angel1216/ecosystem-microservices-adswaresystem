package com.adsware.validation;

import java.util.Map;

/**
 * The interface BusinessValidation.
 * 
 * @author AdsWare System
 *
 */
public interface BusinessValidation {
	
	/**
	 * Method to validate constraints generics.
	 * 
	 * @param request the object to validate
	 * @return the flag constraint
	 */
	Map<String, Object> validateConstraintsGenerics(Object request);

}
