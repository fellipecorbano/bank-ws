package com.ciandt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {	
		model.addAttribute("message", "Hello Spring MVC Framework!");

  		return "index";
	}
	
}
