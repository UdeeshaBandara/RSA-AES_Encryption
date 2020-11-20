package com.ss.rsa.decrypt;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import javax.crypto.Cipher;


import com.ss.file.FileHandling;

public class DecryptKey {

	private Cipher cipher;

	public DecryptKey(PrivateKey privateKey, File encryptedKeyReceived, File decreptedKeyFile, String algorithm) throws IOException, GeneralSecurityException {
		this.cipher = Cipher.getInstance(algorithm);
		decryptFile(FileHandling.getFileInBytes(encryptedKeyReceived), decreptedKeyFile, privateKey);
	}
	
	public void decryptFile(byte[] input, File output, PrivateKey key) throws IOException, GeneralSecurityException {
		this.cipher.init(Cipher.DECRYPT_MODE, key);
		FileHandling.writeToFile(output, this.cipher.doFinal(input));
    }
	
}
