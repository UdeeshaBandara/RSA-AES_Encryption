package com.ss.rsa.chunkencryption;

import java.io.File;
import java.io.FileInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import com.ss.file.FileHandling;
import com.ss.rsa.key.KeyHandling;

public class RSAChunkEncryption {
	private static Cipher cipher;
	private static PrivateKey privateKey;
	private static PublicKey publicKey;
	
	public static void getFileToEncrypt(File f) throws Exception{
		FileInputStream fis = new FileInputStream(f);
		byte[] fbytes = new byte[245];
		
	
		KeyHandling n = new KeyHandling();
		publicKey =n.getPublic(FileHandling.baseLocationRSA+"RSA_Keys/receiverPublicKey.txt", "RSA");
		cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE,publicKey );
	    while ((fis.read(fbytes)) != -1) {
	    	FileHandling.writeToFile(new File("E:\\Note\\Notes\\SS\\CW-2\\RSA\\confidential.txt"),cipher.doFinal(fbytes));
			
	    }
	    fis.close();

	}
	public static void getFileToDecrypt(File f) throws Exception{
		FileInputStream fis = new FileInputStream(f);
	
		byte[] fbytes = new byte[256];

		KeyHandling b = new KeyHandling();
		privateKey= b.getPrivate(FileHandling.baseLocationRSA+"RSA_Keys/receiverPrivateKey.txt", "RSA");
		cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE,privateKey);
		
		while ((fis.read(fbytes)) != -1) {
		    	FileHandling.writeToFile(new File("E:\\Note\\Notes\\SS\\CW-2\\RSA\\decrypt.txt"),cipher.doFinal(fbytes));
					
		}
		fis.close();
	}

	
	public static void main(String[] args) throws Exception {
		
			
			getFileToEncrypt(new File("E:\\Note\\Notes\\SS\\CW-2\\RSA\\DecryptedFiles\\decryptedFile.txt"));
		//	getFileToEncrypt(new File("E:\\Note\\Notes\\SS\\CW-2\\RSA\\test.txt"));
		//	getFileToDecrypt(new File("E:\\Note\\Notes\\SS\\CW-2\\RSA\\confidential.txt"));
		
	}

}
