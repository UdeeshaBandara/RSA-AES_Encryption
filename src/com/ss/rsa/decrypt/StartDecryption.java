package com.ss.rsa.decrypt;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import com.ss.file.FileHandling;
import com.ss.rsa.key.KeyHandling;



public class StartDecryption {
	
	
	public static void main(String[] args) throws IOException, GeneralSecurityException, Exception{
		// TODO Auto-generated method stub
		KeyHandling startDec = new KeyHandling();
		
		File encryptedKeyReceived = new File(FileHandling.baseLocationRSA+"EncryptedFiles/encryptedAESKey.txt");
		File decreptedKeyFile = new File(FileHandling.baseLocationRSA+"DecryptedFiles/decryptedAESKey.txt");
		new DecryptKey(startDec.getPrivate(FileHandling.baseLocationRSA+"RSA_Keys/receiverPrivateKey.txt", "RSA"), encryptedKeyReceived, decreptedKeyFile, "RSA");
		
		File encryptedFileReceived = new File(FileHandling.baseLocationRSA+"EncryptedFiles/encryptedFile.txt");
		File decryptedFile = new File(FileHandling.baseLocationRSA+"DecryptedFiles/decryptedFile.txt");
		new DecryptData(encryptedFileReceived, decryptedFile, startDec.getSecretKey(FileHandling.baseLocationRSA+"DecryptedFiles/decryptedAESKey.txt", "AES"), "AES");
	}

}
