package com.spring.codeagenda.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.codeagenda.model.Paciente;
import com.spring.codeagenda.repository.CodeagendaRepository;
import com.spring.codeagenda.service.CodeagendaService;

@Service
public class CodeagendaServiceImpl implements CodeagendaService{
	
	@Autowired
	CodeagendaRepository codeagendaRepository;

	@Override
	public List<Paciente> findAll() {
		return codeagendaRepository.findAll();
	}

	@Override
	public Paciente findById(long id) {
		return codeagendaRepository.findById(id).get();
	}

	@Override
	public Paciente save(Paciente paciente) {
		return codeagendaRepository.save(paciente);
	}

}
