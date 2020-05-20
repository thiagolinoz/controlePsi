package com.spring.codeagenda.service.serviceImpl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.spring.codeagenda.CodeagendaApplication;
import com.spring.codeagenda.model.Paciente;
import com.spring.codeagenda.service.PacienteService;

@ActiveProfiles("test")
@SpringBootTest(classes = CodeagendaApplication.class)
public class PacienteServiceImplTest {
	
	@Mock
	private PacienteService pacienteService;
	
	@Mock
	private Paciente paciente;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMockCreation() {
		assertNotNull(paciente);
		assertNotNull(pacienteService);
	}
	
	@Test
	public void testFindAPacienteById() {
		when(pacienteService.findById(1L)).thenReturn(paciente);
		assertEquals(paciente, pacienteService.findById(1L));
	}
	
	@Test
	public void testFindAllPacientes() {
		List<Paciente> listPaciente = new ArrayList<Paciente>();
		when(pacienteService.findAll()).thenReturn(listPaciente);
		assertEquals(listPaciente, pacienteService.findAll());
	}
	
	@Test
	public void testSaveAPaciente() {
		when(pacienteService.save(paciente)).thenReturn(paciente);
		assertEquals(paciente, pacienteService.save(paciente));
	}

}
