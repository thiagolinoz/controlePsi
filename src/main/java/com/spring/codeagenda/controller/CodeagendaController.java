package com.spring.codeagenda.controller;

import java.util.List;

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

import javassist.NotFoundException;

@Controller
public class CodeagendaController {
	
	@Autowired
	CodeagendaService codeagendaService;
	@Autowired
	CreateCodeService createNewCode;
	
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
	
	@RequestMapping(value = "/editpaciente/{userId}", method = RequestMethod.GET)
	public ModelAndView showPacienteForm(@PathVariable("userId") long userId) throws NotFoundException {
		
		ModelAndView mv = new ModelAndView("editPacienteForm");
		
		Paciente paciente = codeagendaService.findById(userId);
		if(paciente == null) {
			throw new NotFoundException("Not found user with ID " + userId);
		}
		
		mv.addObject("paciente", paciente);
		
		return mv;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePaciente(@Valid Paciente paciente, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			LoggerFileService.logErrorFile(result.getFieldErrors().toString());
			return "redirect:/pacientes";
		}
		
		if(paciente.getId() == null) {
			String novoCodigo = createNewCode.novoCodigo();
			paciente.setCodigoPaciente(novoCodigo);
		}

		codeagendaService.save(paciente);
		
		return "redirect:/pacientes";
	}
	
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public String deletePaciente(@PathVariable("userId") long userId) throws NotFoundException {
		
		Paciente paciente = codeagendaService.findById(userId);
		
		if(paciente == null) {
			throw new NotFoundException("Not found user with ID " + userId);
		}
		
		codeagendaService.delete(paciente);
		
		return "redirect:/pacientes";
	}
	
}
