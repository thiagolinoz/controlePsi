package com.spring.codeagenda.service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public abstract class LoggerFileService{
	
	private final static Logger logger = Logger.getLogger(LoggerFileService.class.getName());
	
	public abstract String addPathToHandler();
	
	public void log(String logContent) {
		String userDir = System.getProperty("user.dir");
		
		String filesName = addPathToHandler();

		try {
			FileHandler fileHandler = new FileHandler(userDir + "/src/main/resources/logs/"+ filesName +".log", true);
			logger.addHandler(fileHandler);
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			
			logger.log(Level.INFO, logContent);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
