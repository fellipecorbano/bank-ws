package com.ciandt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciandt.beans.Account;
import com.ciandt.services.AccountService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/getAccount", method = RequestMethod.GET)
	public String getAccount(Long cpf){
		cpf = 123456789111L;	//TODO: DELETE
		Gson gson = new Gson();		
		Account acc = accountService.getAccountByCPF(cpf);	
		return gson.toJson(acc);		
	}
	
	@RequestMapping(value="/addAccount", method = RequestMethod.GET)
	public String getAccount(Account c){
		
		Gson gson = new Gson();		
		Account acc = accountService.addAccount(c);	
		return gson.toJson(acc);		
	}
	
	@RequestMapping(value="/removeAccount", method = RequestMethod.GET)
	public JsonElement removeAccount(Long cpf){
		
		return new JsonPrimitive(accountService.removeAccountByCPF(cpf) ? true : false);
	}
	
}
