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
import com.spring.codeagenda.service.CreateCodeService;
import com.spring.codeagenda.service.PacienteService;

import javassist.NotFoundException;

@Controller
public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;
	@Autowired
	CreateCodeService createNewCode;
	
	@RequestMapping(value = "/pacientes", method = RequestMethod.GET)
	public ModelAndView getPacientes() {
		
		ModelAndView mv = new ModelAndView("Paciente/pacientes");
		List<Paciente> pacientes = pacienteService.findAll();
		mv.addObject("pacientes", pacientes);
		
		return mv;
	}
	
	@RequestMapping(value = "/pacientes/{id}", method = RequestMethod.GET)
	public ModelAndView getPacienteDetails(@PathVariable("id") long id) throws NotFoundException {
		
		ModelAndView mv = new ModelAndView("Paciente/pacienteDetails");
		
		try {
			Paciente paciente = pacienteService.findById(id);
			mv.addObject("paciente", paciente);
		} catch (Exception exception) {
			mv.setViewName("notFound");
		} 
		
		return mv;
	}
	
	@RequestMapping(value = "/newpaciente", method = RequestMethod.GET)
	public String getPacienteForm() {
		return "Paciente/pacienteForm";
	}
	
	@RequestMapping(value = "/editpaciente/{userId}", method = RequestMethod.GET)
	public ModelAndView showPacienteForm(@PathVariable("userId") long userId) throws NotFoundException {
		
		ModelAndView mv = new ModelAndView("Paciente/editPacienteForm");
		
		try {
			Paciente paciente = pacienteService.findById(userId);
			mv.addObject("paciente", paciente);
		} catch (Exception exception) {
			mv.setViewName("notFound");
		} 
		
		return mv;
	}
	
	@RequestMapping(value = "/pacientes", method = RequestMethod.POST)
	public String savePaciente(@Valid Paciente paciente, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return "redirect:/pacientes";
		}
		
		String novoCodigo = createNewCode.novoCodigo();
		paciente.setCodigoPaciente(novoCodigo);

		pacienteService.save(paciente);
		
		return "redirect:/pacientes";
	}
	
	@RequestMapping(value = "/pacientes", method = RequestMethod.PUT)
	public String savePaciente(@PathVariable("userId") long userId, @Valid Paciente paciente, BindingResult result) {
		
		if(result.hasErrors()) {
			return "redirect:/pacientes";
		}
		
		try {
			pacienteService.save(paciente);
		} catch (Exception e){
			return "redirect:/notFound";
		}
		
		
		return "redirect:/pacientes";
	}
	
	@RequestMapping(value = "/pacientes/{userId}", method = RequestMethod.DELETE)
	public String deletePaciente(@PathVariable("userId") long userId) throws NotFoundException {
		
		try {
			Paciente paciente = pacienteService.findById(userId);
			pacienteService.delete(paciente);
		} catch (Exception e) {
			return "redirect:/notFound";
		}
		
		return "redirect:/pacientes";
	}
	
}
