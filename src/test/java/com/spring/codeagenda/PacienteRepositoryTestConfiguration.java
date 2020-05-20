package com.spring.codeagenda;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.spring.codeagenda.repository.PacienteRepository;

@Profile("test")
@Configuration
public class PacienteRepositoryTestConfiguration {
	@Bean
	@Primary
	public PacienteRepository pacienteRepository() {
		return Mockito.mock(PacienteRepository.class);
	}
}
