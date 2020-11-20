package com.ss.aes;

import java.io.File;

import com.ss.file.FileHandling;


public class AESMain {
	
	    public static void main(String[] args) throws AESException {
	        String key = "%Q#$Masnd4t*!";
	        File inputFile = new File(FileHandling.clearTextFile);
	        File encryptedFile = new File(FileHandling.cipherTextFile);
	        File decryptedFile = new File(FileHandling.clearTextNewFile);
	         
	        try {
	        	
	        	AESAlgortihm.setKey(key);
	        	AESAlgortihm.encrypt( inputFile, encryptedFile);
	        	AESAlgortihm.decrypt( encryptedFile, decryptedFile);
	        	
	        } catch (AESException ex) {
	        	
	        	  throw new AESException(ex.getMessage(), ex);
	        }
	    }
	}

