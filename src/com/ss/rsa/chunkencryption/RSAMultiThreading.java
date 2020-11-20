package com.ss.rsa.chunkencryption;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import org.apache.commons.io.IOUtils;

import com.ss.file.FileHandling;
import com.ss.rsa.key.KeyHandling;

public class RSAMultiThreading {
	private static Cipher cipher;
	private static PrivateKey privateKey;
	private static PublicKey publicKey;
	
	static byte[] encryptOne = new byte[245];
	static byte[] encryptTwo = new byte[245];
	static byte[] encryptThree = new byte[245];
	static byte[] encryptFour = new byte[245];
	static byte[] encryptFive = new byte[245];
	static byte[] encryptSix = new byte[245];
	
	

	static byte[] decryptOne = new byte[256];
	static byte[] decryptTwo = new byte[256];
	static byte[] decryptThree = new byte[256];
	static byte[] decryptFour = new byte[256];
	static byte[] decryptFive = new byte[256];
	static byte[] decryptSix = new byte[256];
	
	static byte[] readOne = new byte[47185920];
	static byte[] readTwo= new byte[47185920];
	static byte[] readThree= new byte[47185920];
	static byte[] readFour= new byte[47185920];
	static byte[] readFive= new byte[47185920];
	static byte[] readSix= new byte[47185920];
	
	
	static FileInputStream fisEncrypt,fisDecrypt;
	static BufferedInputStream binEncrypt,binDecrypt;
	
	
	
	public static void initiate() throws Exception{
		
		
		fisEncrypt	= new FileInputStream(new File("E:\\Note\\Notes\\SS\\CW-2\\RSA\\DecryptedFiles\\decryptedFile.txt"));
		binEncrypt =new BufferedInputStream(fisEncrypt);  
		
		fisDecrypt	= new FileInputStream(new File("E:\\Note\\Notes\\SS\\CW-2\\RSA\\confidential.txt"));
		binDecrypt =new BufferedInputStream(fisDecrypt);  
		
		KeyHandling n = new KeyHandling();
		
		publicKey =n.getPublic(FileHandling.baseLocationRSA+"RSA_Keys/receiverPublicKey.txt", "RSA");
		privateKey= n.getPrivate(FileHandling.baseLocationRSA+"RSA_Keys/receiverPrivateKey.txt", "RSA");
		
		
		
		cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE,publicKey );
		
	}
	 
	
	
	
	public static void encryptOne() throws Exception{
		Cipher cipher1;
		cipher1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher1.init(Cipher.ENCRYPT_MODE,publicKey );
		binEncrypt.read(readOne,0,47185920);
		ByteArrayInputStream bis1 = new ByteArrayInputStream(readOne);
		  
		while ((bis1.read(encryptOne)) != -1) {
		    	FileHandling.writeToFile(new File(FileHandling.encryptTempOne),cipher1.doFinal(encryptOne));
			//	bufferOne.put(cipher1.doFinal(encryptOne));
		}
//
//		 FileChannel fc = new FileOutputStream("E:\\Note\\Notes\\SS\\CW-2\\RSA\\confidential1.txt").getChannel();
//		    fc.write(bufferOne);
//		    fc.close();
//		bis1.close();
		
	}
	public static void encryptTwo() throws Exception{
		Cipher cipher2;
		
		cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher2.init(Cipher.ENCRYPT_MODE,publicKey );
		binEncrypt.read(readTwo,0,47185920);
		ByteArrayInputStream bis2 = new ByteArrayInputStream(readTwo);
		
		while ((bis2.read(encryptOne)) != -1) {
		    	FileHandling.writeToFile(new File(FileHandling.encryptTempTwo),cipher2.doFinal(encryptOne));
				
		}
		
		bis2.close();
		
		
	}
	public static void encryptThree() throws Exception{
		
		Cipher cipher3;
		
		cipher3 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher3.init(Cipher.ENCRYPT_MODE,publicKey );
		binEncrypt.read(readThree,0,47185920);
		ByteArrayInputStream bis3 = new ByteArrayInputStream(readThree);

		  while ((bis3.read(encryptThree)) != -1) {
		    	FileHandling.writeToFile(new File(FileHandling.encryptTempThree),cipher3.doFinal(encryptThree));
				
		}
			
		bis3.close();
		
	}
	public static void encryptFour() throws Exception{
		
		Cipher cipher4;
		
		cipher4 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher4.init(Cipher.ENCRYPT_MODE,publicKey );
		binEncrypt.read(readFour,0,47185920);
		ByteArrayInputStream bis4 = new ByteArrayInputStream(readFive);

		  while ((bis4.read(encryptFour)) != -1) {
		    	FileHandling.writeToFile(new File(FileHandling.encryptTempFour),cipher4.doFinal(encryptFour));
				
		}
		
		bis4.close();
		
	}
	public static void encryptFive() throws Exception{
		
		Cipher cipher5;
		
		cipher5 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher5.init(Cipher.ENCRYPT_MODE,publicKey );
		binEncrypt.read(readFive,0,47185920);
		ByteArrayInputStream bis5 = new ByteArrayInputStream(readFive);

		  while ((bis5.read(encryptFive)) != -1) {
		    	FileHandling.writeToFile(new File(FileHandling.encryptTempFive),cipher5.doFinal(encryptFive));
				
		}
			
		
		bis5.close();
	}
	
	
	public static void encryptSix() throws Exception{
		
		Cipher cipher6;
		
		cipher6 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher6.init(Cipher.ENCRYPT_MODE,publicKey );
		binEncrypt.read(readSix,0,47185920);
		ByteArrayInputStream bis6 = new ByteArrayInputStream(readSix);

		  while ((bis6.read(encryptSix)) != -1) {
		    	FileHandling.writeToFile(new File(FileHandling.encryptTempSix),cipher6.doFinal(encryptSix));
				
		}
			
		
		bis6.close();
	}
	public static void decryptOne() throws Exception{
		
		Cipher cipher7;
		
		cipher7 = Cipher.getInstance("RSA");
		cipher7.init(Cipher.DECRYPT_MODE,privateKey );
		binDecrypt.read(readOne,0,47185920);
		ByteArrayInputStream bis1 = new ByteArrayInputStream(readOne);

		  while ((bis1.read(decryptOne)) != -1) {
		    	FileHandling.writeToFile(new File(FileHandling.decryptTempOne),cipher7.doFinal(decryptOne));
				
		}
			
		
		bis1.close();
	}
	public static void decryptTwo() throws Exception{
		
		Cipher cipher8;
		
		cipher8 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher8.init(Cipher.DECRYPT_MODE,privateKey );
		binDecrypt.read(readTwo,0,47185920);
		ByteArrayInputStream bis2 = new ByteArrayInputStream(readTwo);

		  while ((bis2.read(decryptTwo)) != -1) {
		    	FileHandling.writeToFile(new File(FileHandling.decryptTempTwo),cipher8.doFinal(decryptTwo));
				
		}
			
		
		bis2.close();
	}
	public static void decryptThree() throws Exception{
		
		Cipher cipher9;
		
		cipher9 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher9.init(Cipher.DECRYPT_MODE,privateKey );
		binDecrypt.read(readThree,0,47185920);
		ByteArrayInputStream bis3 = new ByteArrayInputStream(readThree);

		  while ((bis3.read(decryptThree)) != -1) {
		    	FileHandling.writeToFile(new File(FileHandling.decryptTempThree),cipher9.doFinal(decryptThree));
				
		}
			
		
		bis3.close();
	}
	public static void decryptFour() throws Exception{
		
		Cipher cipher10;
		
		cipher10 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher10.init(Cipher.DECRYPT_MODE,privateKey );
		binDecrypt.read(readFour,0,47185920);
		ByteArrayInputStream bis4 = new ByteArrayInputStream(readFour);

		  while ((bis4.read(decryptFour)) != -1) {
		    	FileHandling.writeToFile(new File(FileHandling.decryptTempFour),cipher10.doFinal(decryptFour));
				
		}
			
		bis4.close();
	}
	public static void decryptFive() throws Exception{
		
		Cipher cipher11;
		
		cipher11 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher11.init(Cipher.DECRYPT_MODE,privateKey );
		binDecrypt.read(readFive,0,47185920);
		ByteArrayInputStream bis5 = new ByteArrayInputStream(readFive);

		  while ((bis5.read(decryptFive)) != -1) {
		    	FileHandling.writeToFile(new File(FileHandling.decryptTempFive),cipher11.doFinal(decryptFive));
				
		}
			
		bis5.close();
	}
	public static void decryptSix() throws Exception{
		
		Cipher cipher12;
		
		cipher12 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher12.init(Cipher.DECRYPT_MODE,privateKey );
		binDecrypt.read(readSix,0,47185920);
		ByteArrayInputStream bis6 = new ByteArrayInputStream(readSix);

		  while ((bis6.read(decryptSix)) != -1) {
		    	FileHandling.writeToFile(new File(FileHandling.decryptTempSix),cipher12.doFinal(decryptSix));
				
		}
			
		bis6.close();
	}
	public static void getFileToEncrypt(File f) throws Exception{
		
	
		//  bin1.skip(11);
		  binEncrypt.read(readTwo,0,11);
		  binEncrypt.read(readFive,0,11);
		    
		
		  ByteArrayInputStream bis2 = new ByteArrayInputStream(readTwo);
		  ByteArrayInputStream bis3 = new ByteArrayInputStream(readFive);
		  
		
		 
		
		
	
		
		
	  
		//fis.skip(20);
	//	String stringss = new String(fbytes);
//		KeyHandling n = new KeyHandling();
//		publicKey =n.getPublic(FileHandling.baseLocation+"RSA_Keys/receiverPublicKey.txt", "RSA");
//		try{for(int loopEncrypt=0;loopEncrypt<=f.length();)
//		{
//			fis.read(fbytes, 0, 117);
//			fis.skip(loopEncrypt);
//			loopEncrypt+=117;
//			
	//	System.out.println(fis.read(fbytes, 0, 117));
		
		//cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		//cipher.init(Cipher.ENCRYPT_MODE,publicKey );
//		FileHandling.writeToFile(new File("E:\\Note\\Notes\\SS\\CW-2\\RSA\\confidential.txt"),fbytes);
//		
//	
//		}}
//		finally
//		{
//			fis.close();
//			
//		}

		fisEncrypt.close();
		

	}
	public static void getFileToDecrypt(File f) throws Exception{
		FileInputStream fis = new FileInputStream(f);
	
		byte[] fbytes = new byte[128];
		int decryptFileSize=(int) f.length();
		
		
		
		System.out.println(decryptFileSize);
	
		//fis.skip(20);

	
		
		cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE,privateKey);
		
		 while ((fis.read(fbytes)) != -1) {
		    	FileHandling.writeToFile(new File("E:\\Note\\Notes\\SS\\CW-2\\RSA\\decrypt.txt"),cipher.doFinal(fbytes));
					
		    }
		
		//		for(int loop=0;loop<decryptFileSize;)
//		{	
//			
//			
//			fis.read(fbytes);
//			
//			fis.skip(loop);
//		
//			loop+=128;
//		
//			
//			cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
//			cipher.init(Cipher.DECRYPT_MODE,privateKey);
//			FileHandling.writeToFile(new File("E:\\Note\\Notes\\SS\\CW-2\\RSA\\decrypt.txt"),cipher.doFinal(fbytes));
//		
//		}
//		
	//System.out.println(n.getPublic(FileHandling.baseLocation+"RSA_Keys/receiverPublicKey.txt", "RSA").getModulus().bitLength());
		fis.close();
	}

	public void executeEncryptMethods(){
		
		
		
	}
	public static void main(String[] args) throws Exception {
	
		
		initiate();
	    
//	    new Thread(() -> {
//			try {
//				encryptOne();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}).start();
//	    
//	    new Thread(() -> {
//			try {
//				encryptTwo();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}).start();
//	    
//	    new Thread(() -> {
//			try {
//				encryptThree();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}).start();
//	    
//	    new Thread(() -> {
//			try {
//				encryptFour();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}).start();
//	    
//	    new Thread(() -> {
//			try {
//				encryptFive();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}).start();
//	    
//	    new Thread(() -> {
//			try {
//				encryptSix();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}).start();
		
		
////	    
//		getFileToDecrypt(new File("E:\\Note\\Notes\\SS\\CW-2\\RSA\\confidential.txt"));
////		
		 IOCopier.joinFiles(new File(FileHandling.encryptedFile), new File[] {
	               new File(FileHandling.encryptTempOne), new File(FileHandling.encryptTempTwo), new File(FileHandling.encryptTempThree), 
		new File(FileHandling.encryptTempFour), new File(FileHandling.encryptTempFive), 
		new File(FileHandling.encryptTempSix) });

	
//	
//		 new Thread(() -> {
//				try {
//					decryptOne();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}).start();
//		    
//		    new Thread(() -> {
//				try {
//					decryptTwo();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}).start();
//		    
//		    new Thread(() -> {
//				try {
//					decryptThree();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}).start();
//		    
//		    new Thread(() -> {
//				try {
//					decryptFour();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}).start();
//		    
//		    new Thread(() -> {
//				try {
//					decryptFive();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}).start();
//		    
//		    new Thread(() -> {
//				try {
//					decryptSix();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}).start();
	
//	
//		 IOCopier.joinFiles(new File(FileHandling.decryptedFile), new File[] {
//	               new File(FileHandling.decryptTempOne), new File(FileHandling.decryptTempTwo), new File(FileHandling.decryptTempThree), 
//		new File(FileHandling.decryptTempFour), new File(FileHandling.decryptTempFive), 
//		new File(FileHandling.decryptTempSix) });
//	
	}

}

class IOCopier extends Thread {
	
	
    public static void joinFiles(File destination, File[] sources) throws IOException {
    	
        OutputStream output = null;
        InputStream input = null;
        
        try {
            output = new BufferedOutputStream(new FileOutputStream(destination, true));
            
            for (File source : sources){
            	
            	 input = null;
            	 input = new BufferedInputStream(new FileInputStream(source));
                 IOUtils.copy(input, output);
               
            }
        } 
        finally {
        	
        	 IOUtils.closeQuietly(input);
        	 IOUtils.closeQuietly(output);
        }
    } 

}
