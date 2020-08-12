package com.spring.codeagenda.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeagenda.repository.PacienteRepository;
import com.spring.codeagenda.service.CreateCodeService;
import com.spring.codeagenda.utils.GenerateCodeHelper;

import javassist.NotFoundException;

@Component
public class CreateCodeServiceImpl implements CreateCodeService {
	String ultimoCodigoNaBase;
	@Autowired
	PacienteRepository codeagendaRepository;
	@Autowired
	GenerateCodeHelper generateCode;

	@Override
	public String novoCodigo() {
		ultimoCodigoNaBase = codeagendaRepository.findByLastPacienteCode();
		if (ultimoCodigoNaBase == null) {
			ultimoCodigoNaBase = "A0";
		}
	
		String novoCodigo = generateCode.sumNumberInString(ultimoCodigoNaBase);

		return novoCodigo;
	}

}
