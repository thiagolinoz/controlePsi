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
		LoggerFileServiceImpl logDebug = new LoggerFileServiceImpl();
		logDebug.log("teste file 0");
		logDebug.log("teste file 1");
		logDebug.log("teste file 2");
		logDebug.log("teste file 3");
	}

	@Test
	public void createLogDebugFile() {
		LoggerDebugFileServiceImpl logDebug = new LoggerDebugFileServiceImpl();
		logDebug.log("teste debug file 0");
		logDebug.log("teste debug file 1");
		logDebug.log("teste debug file 2");
		logDebug.log("teste debug file 3");
	}

}
