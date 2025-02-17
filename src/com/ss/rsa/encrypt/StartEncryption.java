package com.ss.rsa.encrypt;

import java.io.File;
import java.io.IOException;

import java.security.GeneralSecurityException;


import com.ss.file.FileHandling;
import com.ss.rsa.key.KeyHandling;

public class StartEncryption {
	
	public static void main(String[] args) throws IOException, GeneralSecurityException, Exception {
		// TODO Auto-generated method stub
		KeyHandling key = new KeyHandling();
	
		
		File originalFile = new File(FileHandling.clearTextFile);
		File encryptedFile = new File(FileHandling.baseLocationRSA+"EncryptedFiles/encryptedFile.txt");
		new EncryptData(originalFile, encryptedFile, key.getSecretKey(FileHandling.baseLocationRSA+"AES/AESKey.txt", "AES"), "AES");
	
		File originalKeyFile = new File(FileHandling.baseLocationRSA+"AES/AESKey.txt");
		File encryptedKeyFile = new File(FileHandling.baseLocationRSA+"EncryptedFiles/encryptedAESKey.txt");
		new EncryptKey(key.getPublic(FileHandling.baseLocationRSA+"RSA_Keys/receiverPublicKey.txt", "RSA"), originalKeyFile, encryptedKeyFile, "RSA");
	

	}

}
