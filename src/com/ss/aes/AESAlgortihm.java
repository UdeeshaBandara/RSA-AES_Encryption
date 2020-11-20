package com.ss.aes;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import java.security.MessageDigest;

import java.util.Arrays;

import java.util.logging.Level;
import java.util.logging.Logger;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.ss.log.LogHandler;


public class AESAlgortihm {
  
    private static SecretKeySpec secretKey;
    private static byte[] key;
    private final static Logger logger = Logger.getLogger(LogHandler.class.getName());
    
    public static void setKey(String myKey) throws AESException  {
    	
    	MessageDigest sha = null;
    	try {
    		
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
	   		key = Arrays.copyOf(key, 16);
	   		secretKey = new SecretKeySpec(key, "AES");
	   		
		} catch (Exception ex) {
			
			logger.log(Level.WARNING,ex.getMessage());
            throw new AESException(ex.getMessage(), ex);
            
		}	
    }
    public static void encrypt(File inputFile, File outputFile) throws AESException {
    	performCryptography(Cipher.ENCRYPT_MODE, inputFile, outputFile);
    }
 
    public static void decrypt(File inputFile, File outputFile) throws AESException {
    	performCryptography(Cipher.DECRYPT_MODE, inputFile, outputFile);
    }
 
    private static void performCryptography(int cipherMode, File inputFile,File outputFile) throws AESException {
        try {
            
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, secretKey);
            System.out.print(cipherMode);
             
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
           
            inputStream.read(inputBytes);
             
            byte[] outputBytes = cipher.doFinal(inputBytes);
             
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
             
            inputStream.close();
            outputStream.close();
             
        } catch (Exception ex) {
        	//Handling log file
        	logger.log(Level.WARNING,ex.getMessage());
            throw new AESException(ex.getMessage(), ex);
            
        }
    }

}
