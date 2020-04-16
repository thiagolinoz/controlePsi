package com.spring.codeagenda.service;

import java.io.IOException;
import java.time.Instant;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.stereotype.Component;

import com.spring.codeagenda.controller.CodeagendaController;

@Component
public final class LoggerFileService{
	
	private final static Logger logger = Logger.getLogger(LoggerFileService.class.getName());

	public static void logErrorFile(String logContent) {
		String userDir = System.getProperty("user.dir");

		try {
			FileHandler fileHandler = new FileHandler(userDir + "/src/main/resources/logs/LogFile.log", true);
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
