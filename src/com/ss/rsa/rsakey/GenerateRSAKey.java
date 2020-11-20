package com.ss.rsa.rsakey;


import java.io.File;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import com.ss.file.FileHandling;


public class GenerateRSAKey {

	private KeyPairGenerator keyGen;
	private KeyPair pair;
	private PrivateKey privateKey;
	private PublicKey publicKey;
	
	
	//default  generate public and private keys 
	public GenerateRSAKey(int keylength) throws NoSuchAlgorithmException, NoSuchProviderException {
		this.keyGen = KeyPairGenerator.getInstance("RSA");
		this.keyGen.initialize(keylength);
	}
	
	//Method to assign generated keys into local variables
	public void createKeys() {
		this.pair = this.keyGen.generateKeyPair();
		this.privateKey = pair.getPrivate();
		this.publicKey = pair.getPublic();
	}

	
	//public methods to access localised public and private keys
	public PrivateKey getPrivateKey() {
		return this.privateKey;
	}

	public PublicKey getPublicKey() {
		return this.publicKey;
	}


	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, IOException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		GenerateRSAKey senderKey;
		GenerateRSAKey receiverKey;
		
		//Generate and save public, private key of sender
		
		senderKey = new GenerateRSAKey(2048);
		senderKey.createKeys();
		FileHandling.writeToFile(new File(FileHandling.baseLocationRSA+"RSA_Keys/senderPublicKey.txt"), senderKey.getPublicKey().getEncoded());
		FileHandling.writeToFile(new File(FileHandling.baseLocationRSA+"RSA_Keys/senderPrivateKey.txt"), senderKey.getPrivateKey().getEncoded());
			
		//Generate and save public, private key of receiver 
		
		receiverKey = new GenerateRSAKey(2048);
		receiverKey.createKeys();
		FileHandling.writeToFile(new File(FileHandling.baseLocationRSA+"RSA_Keys/receiverPublicKey.txt"), receiverKey.getPublicKey().getEncoded());
		FileHandling.writeToFile(new File(FileHandling.baseLocationRSA+"RSA_Keys/receiverPrivateKey.txt"), receiverKey.getPrivateKey().getEncoded());

	}

}
