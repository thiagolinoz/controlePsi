package com.spring.codeagenda.service.serviceImpl;

import java.io.File;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.codeagenda.service.LoggerFileService;

@SpringBootTest
public class LoggerFileTests {
	
	@Test
	public void createLogFile() {
		LoggerFileService.logErrorFile("teste logging in a file");
	}
	
	@Test
	public void checkLogFileExists() {
		String userDir = System.getProperty("user.dir");
		
		File file = new File(userDir + "/src/main/resources/logs/LogFile.log");
		assertTrue(file.exists());
	}

}
