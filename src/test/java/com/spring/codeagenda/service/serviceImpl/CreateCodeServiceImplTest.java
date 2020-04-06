package com.spring.codeagenda.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.codeagenda.repository.CodeagendaRepository;
import com.spring.codeagenda.service.CreateCodeService;

@SpringBootTest
public class CreateCodeServiceImplTest {
	
	@Autowired
	CodeagendaRepository codeagendaRepository;
	@Autowired
	CreateCodeService createNewCode;
	
	private String lastPaciente; 
	
	@BeforeEach
	public void getLastPacienteCode() {
		lastPaciente = codeagendaRepository.findByLastPacienteCode();
	}
	
	@Test
	public void receiveString() {
		assertEquals(lastPaciente.getClass().getSimpleName(), "String");
	}
	
	@Test
	public void notEqualCodes() {
		String novoCodigo = createNewCode.novoCodigo();
		assertNotEquals(lastPaciente, novoCodigo);
	}

}
