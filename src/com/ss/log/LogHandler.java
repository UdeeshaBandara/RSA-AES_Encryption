package com.ss.log;


import java.io.IOException;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.ss.file.FileHandling;


public class LogHandler {
  

	//private static final LogManager logger = (LogManager) LogManager.getLogger("Logger");
    private static FileHandler fh = null;
    //private final static Logger logger = Logger.getLogger(LogHandler.class.getName());
    
    public static void initt(){
    	 try {
    		 
    	
    		 fh=new FileHandler(FileHandling.logFile, false);
    	 
    	 } catch (SecurityException | IOException e) {
    	 
    		 e.printStackTrace();
    	 }
    	
	    	 Logger l = Logger.getLogger("");
	    	 fh.setFormatter(new SimpleFormatter());
	    	 l.addHandler(fh);
	    	 l.setLevel(Level.CONFIG);
    	 }

	}

	


