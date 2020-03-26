package com.spring.codeagenda.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeagenda.repository.CodeagendaRepository;
import com.spring.codeagenda.utils.GenerateCodeHelper;

@Component
public class CodePacienteImpl implements CreateCode {
	
	@Autowired
	CodeagendaRepository codeagendaRepository;
	GenerateCodeHelper generateCode;

	@Override
	public String novoCodigo() {
		
		String ultimoCodigoNaBase = codeagendaRepository.findByLastPacienteCode();
		
		String novoCodigo = generateCode.sumNumberInString(ultimoCodigoNaBase);
		
		return novoCodigo;
	}

}
