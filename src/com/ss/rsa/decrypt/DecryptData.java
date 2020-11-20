package com.ss.rsa.decrypt;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;


import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;

import com.ss.file.FileHandling;

public class DecryptData {

	private Cipher cipher;

	public DecryptData(File encryptedFileReceived, File decryptedFile, SecretKeySpec secretKey, String algorithm) throws IOException, GeneralSecurityException {
		this.cipher = Cipher.getInstance(algorithm);
		decryptFile(FileHandling.getFileInBytes(encryptedFileReceived), decryptedFile, secretKey);
	}
	
	public void decryptFile(byte[] input, File output, SecretKeySpec key) throws IOException, GeneralSecurityException {
		this.cipher.init(Cipher.DECRYPT_MODE, key);
		FileHandling.writeToFile(output, this.cipher.doFinal(input));
    }
	

}
