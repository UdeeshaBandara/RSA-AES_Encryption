package com.ss.rsa.encrypt;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;


import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;

import com.ss.file.FileHandling;

public class EncryptData {
	private Cipher cipher;
	
	public EncryptData(File originalFile, File encrypted, SecretKeySpec secretKey, String cipherAlgorithm) throws IOException, GeneralSecurityException{
		this.cipher = Cipher.getInstance(cipherAlgorithm);		
		encryptFile(FileHandling.getFileInBytes(originalFile), encrypted, secretKey);
	}
	
	public void encryptFile(byte[] input, File output, SecretKeySpec key) throws IOException, GeneralSecurityException {
		this.cipher.init(Cipher.ENCRYPT_MODE, key);
		FileHandling.writeToFile(output, this.cipher.doFinal(input));
    }
	
}
