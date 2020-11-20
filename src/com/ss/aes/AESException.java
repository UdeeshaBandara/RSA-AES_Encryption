package com.ss.aes;


public class AESException extends Exception {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AESException() {
    	
    }
 
    public AESException(String message, Throwable throwable) throws AESException {
        super(message, throwable);
    
    }

}
