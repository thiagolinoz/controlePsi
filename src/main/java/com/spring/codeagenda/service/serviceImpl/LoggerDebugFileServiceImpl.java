package com.spring.codeagenda.service.serviceImpl;

import com.spring.codeagenda.service.LoggerFileService;

import org.springframework.stereotype.Component;

@Component
public class LoggerDebugFileServiceImpl extends LoggerFileService{
	
	public String addPathToHandler() {
		return "LogDebugFile";
	}

}
