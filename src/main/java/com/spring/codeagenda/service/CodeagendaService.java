package com.spring.codeagenda.service;

import java.util.List;

import com.spring.codeagenda.model.Paciente;

public interface CodeagendaService {
	
	List<Paciente> findAll();
	Paciente findById(long id);
	Paciente save(Paciente paciente);

}
