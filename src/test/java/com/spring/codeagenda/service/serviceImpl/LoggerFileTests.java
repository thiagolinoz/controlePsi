package com.spring.codeagenda.service.serviceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggerFileTests {
	
	public String userDir;
	
	@BeforeEach
	public void getUserDir() {
		userDir = System.getProperty("user.dir");
	}
	
	@Test
	public void createLogFile() {
		LoggerFileServiceImpl logFile = new LoggerFileServiceImpl("LogFile");
		logFile.logIn("teste file 0");
		logFile.logIn("teste file 1");
		logFile.logIn("teste file 2");
		logFile.logIn("teste file 3");
	}

	@Test
	public void createLogDebugFile() {
		LoggerDebugFileServiceImpl logDebug = new LoggerDebugFileServiceImpl("LogDebugFile");
		logDebug.logIn("teste debug file 0");
		logDebug.logIn("teste debug file 1");
		logDebug.logIn("teste debug file 2");
		logDebug.logIn("teste debug file 3");
	}

}
