package com.spring.codeagenda.service.serviceImpl;

import java.io.IOException;
import java.time.Instant;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.stereotype.Component;

import com.spring.codeagenda.service.LoggerFileService;

@Component
public class LoggerFileServiceImpl implements LoggerFileService{

	@Override
	public void LogErrorFile(Logger logger, String logContent) {
		long posix = Instant.now().getEpochSecond();
		String userDir = System.getProperty("user.dir");

		try {
			FileHandler handler = new FileHandler(userDir + "/src/main/resources/logs/Log"+ posix +".log");

			logger.addHandler(handler);
			SimpleFormatter formatter = new SimpleFormatter();
			handler.setFormatter(formatter);
			
			logger.log(Level.INFO, logContent);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
