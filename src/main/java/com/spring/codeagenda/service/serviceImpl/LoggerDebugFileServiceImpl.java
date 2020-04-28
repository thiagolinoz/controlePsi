package com.spring.codeagenda.service.serviceImpl;

import com.spring.codeagenda.service.LoggerFileService;

public class LoggerDebugFileServiceImpl extends LoggerFileService {
	public String fileName;

	public LoggerDebugFileServiceImpl(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String getFileLogName() {
		return fileName;
	}
}
