package com.ss.rsa.aeskey;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.ss.file.FileHandling;



public class GenerateAESKey {
	private SecretKeySpec secretKey;

	public GenerateAESKey(int length, String algorithm) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException {
		SecureRandom rnd = new SecureRandom();
		byte [] key = new byte [length];
		System.out.println(key.length);
		rnd.nextBytes(key);
		//System.out.println(rnd.nextBytes(key).toString());
		this.secretKey = new SecretKeySpec(key, algorithm);
		
	}
	
	//public method to access localised secret key
	public SecretKeySpec getKey(){
		return this.secretKey;
	}

	

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IOException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		GenerateAESKey genSK = new GenerateAESKey(16, "AES");
		FileHandling.writeToFile(new File(FileHandling.baseLocationRSA+"AES/AESKey.txt"), genSK.getKey().getEncoded());
	}

}
