package com.spring.codeagenda.service.serviceImpl;

import com.spring.codeagenda.service.LoggerFileService;

public class LoggerFileServiceImpl{
	
	private String fileName;
	
	public void log(String logContent){
		fileName = "LogFile";
		LoggerFileService loggerFileService = new LoggerFileService();
		loggerFileService.logIn(logContent, fileName);
	}
	
}
