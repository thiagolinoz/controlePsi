package com.spring.codeagenda.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeagenda.model.Paciente;
import com.spring.codeagenda.service.CodeagendaService;
import com.spring.codeagenda.service.CreateCodeService;
import com.spring.codeagenda.service.LoggerFileService;

@Controller
public class CodeagendaController {
	
	@Autowired
	CodeagendaService codeagendaService;
	@Autowired
	CreateCodeService createNewCode;
	@Autowired
	LoggerFileService loggerInfo;
	
	private final static Logger logger = Logger.getLogger(CodeagendaController.class.getName());
	
	@RequestMapping(value = "/pacientes", method = RequestMethod.GET)
	public ModelAndView getPacientes() {
		
		ModelAndView mv = new ModelAndView("pacientes");
		List<Paciente> pacientes = codeagendaService.findAll();
		mv.addObject("pacientes", pacientes);
		
		return mv;
	}
	
	@RequestMapping(value = "/pacientes/{id}", method = RequestMethod.GET)
	public ModelAndView getPacienteDetails(@PathVariable("id") long id) {
		
		ModelAndView mv = new ModelAndView("pacienteDetails");
		Paciente paciente = codeagendaService.findById(id);
		mv.addObject("paciente", paciente);
		
		return mv;
	}
	
	@RequestMapping(value = "/newpaciente", method = RequestMethod.GET)
	public String getPacienteForm() {
		return "pacienteForm";
	}
	
	@RequestMapping(value = "/newpaciente", method = RequestMethod.POST)
	public String savePaciente(@Valid Paciente paciente, BindingResult result, RedirectAttributes attributes) {
		
		String novoCodigo = createNewCode.novoCodigo();

		if(result.hasErrors()) {
			loggerInfo.LogErrorFile(logger, result);
		}
		
		paciente.setCodigoPaciente(novoCodigo);
		codeagendaService.save(paciente);
		
		return "redirect:/pacientes";
	}

}
