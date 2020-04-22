package com.spring.codeagenda.service.serviceImpl;

import com.spring.codeagenda.service.LoggerFileService;

public class LoggerDebugFileServiceImpl{
	
	private String fileName;
	
	public void log(String logContent){
		fileName = "LogDebugFile";
		LoggerFileService loggerFileService = new LoggerFileService();
		loggerFileService.logIn(logContent, fileName);
	}
	
}
