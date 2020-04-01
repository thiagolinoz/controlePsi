package com.spring.codeagenda.service.serviceImpl;

import java.io.IOException;
import java.time.Instant;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.spring.codeagenda.service.LoggerFileService;

@Component
public class LoggerFileImpl implements LoggerFileService{

	@Override
	public void LogErrorFile(Logger logger, BindingResult result) {
		long posix = Instant.now().getEpochSecond();

		try {
			FileHandler handler = new FileHandler("src/main/resources/logs/Log"+ posix +".log");

			logger.addHandler(handler);
			SimpleFormatter formatter = new SimpleFormatter();
			handler.setFormatter(formatter);
			
			logger.log(Level.INFO, result.getFieldErrors().toString());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
