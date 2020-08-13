package com.spring.codeagenda.service;

import java.util.List;

import com.spring.codeagenda.model.Paciente;

public interface PacienteService {
	
	List<Paciente> findAll();
	Paciente findById(long id);
	Paciente save(Paciente paciente);
	void delete(Paciente paciente);
}
