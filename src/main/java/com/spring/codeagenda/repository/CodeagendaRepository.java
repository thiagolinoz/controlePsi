package com.spring.codeagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.codeagenda.model.Paciente;

public interface CodeagendaRepository extends JpaRepository<Paciente, Long>{
	
	@Query(value = "SELECT codigo_paciente FROM tb_paciente ORDER BY id DESC LIMIT 1", nativeQuery = true)
	String findByLastPacienteCode();

}