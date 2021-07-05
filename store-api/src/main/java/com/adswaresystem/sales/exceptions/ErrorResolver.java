package com.adswaresystem.sales.exceptions;

import java.time.ZonedDateTime;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.adswaresystem.sales.exceptions.custom.BadRequestException;
import com.adswaresystem.sales.utils.Constants;
import com.adswaresystem.sales.exceptions.ErrorResolver;
import com.adswaresystem.sales.exceptions.custom.InternalServerErrorException;
import com.adswaresystem.sales.exceptions.custom.UnauthorizedException;

/**
 * The class ErrorResolver.
 * 
 * @author AdsWare System
 *
 */
@RestControllerAdvice
public class ErrorResolver {

	  /**
	   * The log attribute.
	   */
	  private static final Logger log = LoggerFactory.getLogger(ErrorResolver.class);
	  
	  /**
	   * Method to write to log.
	   * 
	   * @param errorResponse the errorResponse
	   * @param exception the exception
	   */
	  private static void writeToLog(ErrorResponse errorResponse, Exception exception) {
		  log.error(Constants.ERROR_RESPONSE_TYPE, errorResponse.getType());
		  log.error(Constants.ERROR_RESPONSE_CODE, errorResponse.getCode());
		  log.error(Constants.ERROR_RESPONSE_DETAILS, errorResponse.getDetails());
		  log.error(Constants.ERROR_RESPONSE_LOCATION, errorResponse.getLocation());
		  log.error(Constants.ERROR_RESPONSE_MORE_INFO, errorResponse.getMoreInfo());
		  
		  String message = Objects.isNull(exception) ? Constants.EMPTY_STRING
				  : exception.getMessage();
		  log.error(message, exception);
	  }
	  
	  /**
	   * Method to resolve bad request exception.
	   * 
	   * @param request the request
	   * @param ex the exception
	   * @return the exception
	   */
	  @ExceptionHandler(BadRequestException.class)
	  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	  public ErrorResponse resolveBadRequestException(HttpServletRequest request,
	    BadRequestException ex) {
		  
		  ErrorResponse errorResponse = new ErrorResponse();
		  
		  errorResponse.setType(ErrorType.ERROR.name());
		  errorResponse.setCode(Constants.ERROR_CODE_BAD_REQUEST);
		  errorResponse.setLocation(ex.getBadFields());
		  errorResponse.setDetails(ex.getMessage());
		  errorResponse.setTimestamp(ZonedDateTime.now());
		  
		  ErrorResolver.writeToLog(errorResponse, ex);
		  
		  
		  return errorResponse;
	  }
	  
	  /**
	   * Method to resolve bad request exception.
	   * 
	   * @param request the request
	   * @param ex the exception
	   * @return the exception
	   */
	  @ExceptionHandler(UnauthorizedException.class)
	  @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	  public ErrorResponse resolveUnauthorizedException(HttpServletRequest request,
	    UnauthorizedException ex) {
		  
		  ErrorResponse errorResponse = new ErrorResponse();
		  
		  errorResponse.setType(ErrorType.ERROR.name());
		  errorResponse.setCode(Constants.ERROR_CODE_UNAUTHORIZED);
	  
		  errorResponse.setLocation(ex.getLocation());
		  errorResponse.setDetails(ex.getMessage());
		  errorResponse.setTimestamp(ZonedDateTime.now());
		  
		  ErrorResolver.writeToLog(errorResponse, ex);
		  
		  
		  return errorResponse;
	  }
	  
	  /**
	   * Method to resolve internal server error exception.
	   * 
	   * @param request the request
	   * @param ex the exception
	   * @return the exception
	   */
	  @ExceptionHandler(InternalServerErrorException.class)
	  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	  public ErrorResponse resolveInternalServerErrorException(HttpServletRequest request,
	      InternalServerErrorException ex) {
		  
		  ErrorResponse errorResponse = new ErrorResponse();
		  
		  errorResponse.setType(ErrorType.ERROR.name());
		  errorResponse.setCode(Constants.ERROR_CODE_INTERNAL_SERVER_ERROR);
	  
		  errorResponse.setLocation(ex.getLocation());
		  errorResponse.setDetails(ex.getMessage());
		  errorResponse.setTimestamp(ZonedDateTime.now());
		  
		  ErrorResolver.writeToLog(errorResponse, ex);
		  
		  
		  return errorResponse;
	  }
	  
}
