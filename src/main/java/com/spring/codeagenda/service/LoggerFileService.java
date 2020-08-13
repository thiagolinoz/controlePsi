package com.spring.codeagenda.service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.stereotype.Service;

@Service
public abstract class LoggerFileService{

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public abstract String getFileLogName();
	
	public void logIn(String logContent) {
		String userDir = System.getProperty("user.dir");
		String fileName = getFileLogName(); 
		try {
			FileHandler fileHandler = new FileHandler(userDir + "/src/main/resources/logs/"+ fileName +".log", true);
			
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			LOGGER.addHandler(fileHandler);
			LOGGER.log(Level.INFO, logContent);
			fileHandler.close();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
