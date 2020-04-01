package com.spring.codeagenda.service;

import java.util.logging.Logger;

import org.springframework.validation.BindingResult;

public interface LoggerFileService {
	
	void LogErrorFile(Logger logger, BindingResult results);

}
