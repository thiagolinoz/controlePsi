package com.spring.codeagenda.service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.stereotype.Service;

@Service
public class LoggerFileService{

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
	public void logIn(String logContent, String filesName) {
		String userDir = System.getProperty("user.dir");

		try {
			FileHandler fileHandler = new FileHandler(userDir + "/src/main/resources/logs/"+ filesName +".log", true);
			
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
