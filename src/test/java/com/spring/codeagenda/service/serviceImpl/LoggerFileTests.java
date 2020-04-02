package com.spring.codeagenda.service.serviceImpl;

import java.io.File;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggerFileTests {
	
	private LoggerFileServiceImpl loggerFileImpl;
	private final static Logger logger = Logger.getLogger("TestImplementation");
	
	@BeforeEach
	public void LoggerInstacer() {
		loggerFileImpl = new LoggerFileServiceImpl();
	}
	
	@Test
	public void createLogFile() {
		loggerFileImpl.LogErrorFile(logger, "teste logging in a file");
	}
	
	@Test
	public void checkLogFileExists() {
		String userDir = System.getProperty("user.dir");
		
		File file = new File(userDir + "/src/main/resources/logs/Log1585822540.log");
		assertTrue(file.exists());
	}

}
