package com.spring.codeagenda.utils;

import org.springframework.stereotype.Component;

@Component
public class GenerateCodeHelper {
	private String removeDigit;
	private int valueSum;
	
	public String sumNumberInString(String codigo) {
		try {
			String removeNonDigit = codigo.replaceAll("\\D", " ").trim();
			removeDigit = codigo.replaceAll("\\d", " ").trim();
			valueSum = Integer.parseInt(removeNonDigit) + 1;
		} catch (NullPointerException e) {
			return e.getMessage();
		}
		return removeDigit + valueSum;
	}

}
