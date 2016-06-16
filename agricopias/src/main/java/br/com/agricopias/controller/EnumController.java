package br.com.agricopias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agricopias.enums.Unidade;

@Controller
@RequestMapping("/enums")
public class EnumController {
	
	@RequestMapping(value = "/unidade", method = RequestMethod.GET)
	public @ResponseBody Unidade[] findAll() {
		return Unidade.values();
	}
}
