package com.springboot.web.security.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.security.entity.Contactaf;

@Controller
public class TestController {

	@RequestMapping("/helo")
	public String showform(Model model) {
		model.addAttribute("Contactaf", new Contactaf());
		return "form";
	}
	@PostMapping("/submit")
	public String submitForm(@ModelAttribute("Contactaf") @Valid Contactaf contactaf, BindingResult result ) {
		if(result.hasErrors()) {
		return "form";

	}
	return  "success";
}}
