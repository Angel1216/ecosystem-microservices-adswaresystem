package com.adsware.errors;

public class ExceptionsController extends RuntimeException {

	public ExceptionsController(String message) {
        super(message);
    }
}
