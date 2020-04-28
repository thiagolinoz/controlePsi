package com.spring.codeagenda.service.serviceImpl;

import com.spring.codeagenda.service.LoggerFileService;

public class LoggerFileServiceImpl extends LoggerFileService {
	public String fileName;

	public LoggerFileServiceImpl(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String getFileLogName() {
		return fileName;
	}

}
