package com.spring.codeagenda.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GenerateCodeHelperTests {
	
	private GenerateCodeHelper newCodeObj;
	private String newCode;
	
	@BeforeEach
	public void codeHelperInstance () {
		this.newCodeObj = new GenerateCodeHelper();
		this.newCode = newCodeObj.sumNumberInString("A2");
	}
	
	@Test
	void addStringCorrectly() {
		assertEquals("A3", newCode); 
	}
	
	@Test
	void didntAddStringCorrectly() {
		assertNotEquals("A2", newCode);
	}
	
}
