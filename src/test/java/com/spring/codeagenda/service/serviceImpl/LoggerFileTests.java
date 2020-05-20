package com.spring.codeagenda.service.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggerFileTests {
	
	public String userLogDir;
	
	@BeforeEach
	public void getUserDir() {
		userLogDir = System.getProperty("user.dir") + "/src/main/resources/logs/";
	}
	
	@Test
	public void testCreateJustOneLogFile() {
		LoggerFileServiceImpl logFile = new LoggerFileServiceImpl("LogFile");
		int totalOfFiles = new File(userLogDir).list().length;
		
		logFile.logIn("teste file 0");
		logFile.logIn("teste file 1");
		logFile.logIn("teste file 2");
		logFile.logIn("teste file 3");
		
		Assertions.assertEquals(2, totalOfFiles);
	}

	@Test
	public void testCreateJustOneLogDebugFile() {
		LoggerDebugFileServiceImpl logDebug = new LoggerDebugFileServiceImpl("LogDebugFile");
		int totalOfFiles = new File(userLogDir).list().length;
		
		logDebug.logIn("teste debug file 0");
		logDebug.logIn("teste debug file 1");
		logDebug.logIn("teste debug file 2");
		logDebug.logIn("teste debug file 3");
		
		Assertions.assertEquals(2, totalOfFiles);
	}
	
	@Test
	public void testCheckThatLastLineWasWrittenCorrectlyLogFile() {
		List<String> myLastLine = new ArrayList<String>();
		List<String> expectedLastLine = new ArrayList<String>();
		String lastLineLog = null;
		
		try(Scanner scanner = new Scanner(new File(userLogDir+"LogFile.log"))) {
			while (scanner.hasNextLine()) {
				lastLineLog = scanner.nextLine();
			}
			myLastLine.add(lastLineLog);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		expectedLastLine.add("INFO: teste file 3");
		
		Assertions.assertLinesMatch(expectedLastLine, myLastLine);
	}

}
