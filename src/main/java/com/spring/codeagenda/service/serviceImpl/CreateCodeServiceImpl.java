package com.spring.codeagenda.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeagenda.repository.CodeagendaRepository;
import com.spring.codeagenda.service.CreateCodeService;
import com.spring.codeagenda.utils.GenerateCodeHelper;

@Component
public class CreateCodeServiceImpl implements CreateCodeService {
	
	@Autowired
	CodeagendaRepository codeagendaRepository;
	@Autowired
	GenerateCodeHelper generateCode;

	@Override
	public String novoCodigo() {
		
		String ultimoCodigoNaBase = codeagendaRepository.findByLastPacienteCode();
		
		String novoCodigo = generateCode.sumNumberInString(ultimoCodigoNaBase);
		
		return novoCodigo;
	}

}
