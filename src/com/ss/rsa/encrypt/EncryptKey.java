package com.ss.rsa.encrypt;

import java.io.File;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;


import javax.crypto.Cipher;


import com.ss.file.FileHandling;

public class EncryptKey {
private Cipher cipher;
	
	public EncryptKey(PublicKey key, File originalKeyFile, File encryptedKeyFile, String cipherAlgorithm) throws IOException, GeneralSecurityException{
		this.cipher = Cipher.getInstance(cipherAlgorithm);
		
		encryptFile(FileHandling.getFileInBytes(originalKeyFile), encryptedKeyFile, key);
	}
	public void encryptFile(byte[] input, File output, PublicKey key) throws IOException, GeneralSecurityException {
		this.cipher.init(Cipher.ENCRYPT_MODE, key);
		FileHandling.writeToFile(output, this.cipher.doFinal(input));
    }
	
	
}
