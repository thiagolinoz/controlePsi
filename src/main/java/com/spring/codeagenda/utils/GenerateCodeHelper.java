package com.spring.codeagenda.utils;

public class GenerateCodeHelper {
	
	public String sumNumberInString(String codigo) {
		
		String removeNonDigit = codigo.replaceAll("\\D", " ").trim();
		String removeDigit = codigo.replaceAll("\\d", " ").trim();
		int valueSum = Integer.parseInt(removeNonDigit) + 1;
		
		return removeDigit + valueSum;
	}

}
