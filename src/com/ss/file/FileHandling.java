package com.ss.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class FileHandling {
	
	
	//Base file locations for RSA encryption
	public static String baseLocationAES = "E:\\Note\\Notes\\SS\\CW-2\\AES\\";
	
	//File locations for AES encryption
	public static String clearTextFile = baseLocationAES+"original.txt";
	public static String clearTextNewFile = baseLocationAES+"neworiginal.txt";
	public static String cipherTextFile = baseLocationAES+"Cipher.txt";
	
	//Base file locations for RSA encryption
	public static String baseLocationRSA = "E:\\Note\\Notes\\SS\\CW-2\\RSA\\";
	
	//file locations for encryption file
	public static String encryptedFile=baseLocationRSA+"\\EncryptedConfidential.txt";
	
	//Temporary file locations for encryption files
	public static String encryptTempOne=baseLocationRSA+"confidential1.txt";
	public static String encryptTempTwo=baseLocationRSA+"confidential2.txt";
	public static String encryptTempThree=baseLocationRSA+"confidential3.txt";
	public static String encryptTempFour=baseLocationRSA+"confidential4.txt";
	public static String encryptTempFive=baseLocationRSA+"confidential5.txt";
	public static String encryptTempSix=baseLocationRSA+"confidential6.txt";
	
	
	//file locations for encryption file
	public static String decryptedFile=baseLocationRSA+"\\DecryptedConfidential.txt";
	
	//Temporary file locations for decryption files
	public static String decryptTempOne=baseLocationRSA+"decrypt1.txt";
	public static String decryptTempTwo=baseLocationRSA+"decrypt2.txt";
	public static String decryptTempThree=baseLocationRSA+"decrypt3.txt";
	public static String decryptTempFour=baseLocationRSA+"decrypt4.txt";
	public static String decryptTempFive=baseLocationRSA+"decrypt5.txt";
	public static String decryptTempSix=baseLocationRSA+"decrypt6.txt";
	
	
	//Files locations for logger file
	public static String logFile = "E:\\Note\\Notes\\SS\\CW-2\\Logger.txt";
	
	
	//method to write data to files
	public static void writeToFile(File output, byte[] toWrite) throws IllegalBlockSizeException, BadPaddingException, IOException{
		output.getParentFile().mkdirs();
		FileOutputStream fos = new FileOutputStream(output,true);
		fos.write(toWrite);
		fos.flush();
		fos.close();
	}
	//method to read data from files
	public static byte[] getFileInBytes(File f) throws IOException{
		FileInputStream fis = new FileInputStream(f);
		byte[] fbytes = new byte[(int) f.length()];
		fis.read(fbytes);
		fis.close();
		return fbytes;
	}

//	public static void readFileAndWriteCipher( ) throws IOException{	 
//		
//		RandomAccessFile aFile = new RandomAccessFile(clearTextFile, "r");
//		 
//        FileChannel inChannel = aFile.getChannel();
// 
//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        while(inChannel.read(buffer) > 0)
//        {
//             buffer.flip();
//            for (int i = 0; i < buffer.limit(); i++)
//            {
//                System.out.print((char) buffer.get());
//            }
//      
//            System.out.println(  getByteArrayFromByteBuffer(buffer));
//            
//            usingFileOutputStream(AESAlgortihm.encrypt(getByteArrayFromByteBuffer(buffer)),cipherTextFile);
//            usingFileOutputStream(AESAlgortihm.decrypt(getByteArrayFromByteBuffer(buffer)),clearTextNewFile);
//            buffer.clear(); // do something with the data and clear/compact it.
//        }
// 
//        inChannel.close();
//        aFile.close();
//	return buffer;
//
//		
//	}
//public static void readFileAndWriteDecrypt( ) throws IOException{	 
//		
//		RandomAccessFile aFile = new RandomAccessFile(cipherTextFile, "r");
//		 
//        FileChannel inChannel = aFile.getChannel();
// 
//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        while(inChannel.read(buffer) > 0)
//        {
//            buffer.flip();
//            for (int i = 0; i < buffer.limit(); i++)
//            {
//                System.out.print((char) buffer.get());
//            }
//            
//            
//            usingFileOutputStream(AESAlgortihm.decrypt(new String(buffer.array(),"UTF-8")),clearTextNewFile);
//            buffer.clear(); // do something with the data and clear/compact it.
//        }
// 
//        inChannel.close();
//        aFile.close();
//        return buffer;
//
//		
//	}
//	
//	
//	private static byte[] getByteArrayFromByteBuffer(ByteBuffer byteBuffer) {
//	    byte[] bytesArray = new byte[byteBuffer.remaining()];
//	    byteBuffer.get(bytesArray, 0, bytesArray.length);
//	    return bytesArray;
//	}
//	public static void usingFileOutputStream(String toWrite,String fileLocation) throws IOException 
//	{
//	  //  String textToAppend = "\r\n Happy Learning !!"; //new line in content
//	     
//	    FileOutputStream outputStream = new FileOutputStream(fileLocation, true);
//	    byte[] strToBytes = toWrite.getBytes();
//	    outputStream.write(strToBytes);
//	  
//	    outputStream.close();
//	}
//
}
