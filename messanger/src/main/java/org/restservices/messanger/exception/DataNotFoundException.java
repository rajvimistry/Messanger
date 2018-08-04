package org.restservices.messanger.exception;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4092840519557281871L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
