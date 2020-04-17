package com.spring.codeagenda.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeagenda.repository.PacienteRepository;
import com.spring.codeagenda.model.Paciente;

@Component
public class DummyData {
	
	@Autowired
	PacienteRepository codeagendaRepository;
	
	//@PostConstruct
	public void savePaciente() {
		
		List<Paciente> pacienteList = new ArrayList<>();
		Paciente paciente1 = new Paciente();
		paciente1.setNomeCompleto("Bruno Alexandre");
		paciente1.setCodigoPaciente("A000000001");
		paciente1.setEndereco("Avenida dos abaxacais");
		paciente1.setDataNascimento(LocalDate.now());
		paciente1.setDataInicio(LocalDate.now());
		paciente1.setTelefone("2222222222");
		paciente1.setEmail("contato@email.com");
		paciente1.setProntuario("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

		Paciente paciente2 = new Paciente();
		paciente2.setNomeCompleto("Camila Alexandre");
		paciente2.setCodigoPaciente("A000000002");
		paciente2.setEndereco("Avenida dos abaxacais");
		paciente2.setDataNascimento(LocalDate.now());
		paciente2.setDataInicio(LocalDate.now());
		paciente2.setTelefone("33333333");
		paciente2.setEmail("outroContato@email.com");
		paciente2.setProntuario("Aqui é Body Builder Ipsum PORRA! Tá comigo porra. É esse que a gente quer, é ele que nóis vamo buscar. Vo derrubar tudo essas árvore do parque ibirapuera. Eita porra!, tá saindo da jaula o monstro! Sai filho da puta! Aqui é Body Builder Ipsum PORRA! Não vai dá não. Que não vai dá rapaiz, não vai dá essa porra. AHHHHHHHHHHHHHHHHHHHHHH..., porra! Negativa Bambam negativa. É 37 anos caralho! Boraaa, Hora do Show Porra. Vai subir árvore é o caralho porra! Que não vai dá rapaiz, não vai dá essa porra.");
		
		pacienteList.add(paciente1);
		pacienteList.add(paciente2);
		
		for(Paciente paciente : pacienteList) {
			Paciente pacienteSaved = codeagendaRepository.save(paciente);
			System.out.println(pacienteSaved.getId());
		}
		
	}
	

}
